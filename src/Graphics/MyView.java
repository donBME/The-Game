package Graphics;

import Inventories.DataAccessPoint;
import Players.Player;
import Tools.CVector;
import Tools.Controller;
import Tools.Coordinate;
import Tools.Direction;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;



import GameObjects.FieldObject;
import GameObjects.StarGate;

/**
 * @author Laszlo
 * @version 1.0
 */

public class MyView implements Notifiable{
	
	private static final int CONFIG_SIZE = 3;
    private DataAccessPoint data;
    private Controller controller;
    private int num_of_maps;
    private JComboBox<Object> mapselectbox;
    private JButton startbutton;
    private JFrame jFrame;
    private JPanel ptitle;
    private JPanel maps;
    private JPanel buttonpanel;

    private int OBJECT_WIDTH, OBJECT_HEIGHT;

    public MyView(){
    	controller = new Controller(this);
    	initwindow();
    	
    }
    
    /* ablak inicializálása:
     *   config betöltése
     *   vezérlõelemek elhelyezése
     */
    private void initwindow(){
    	
    	//Adatok betöltése
    	String[] config = getConfig();
    	//Ha nem sikeres visszajelzést kapunk kilépünk
    	if(!config[0].equals("ok!"))
    		return;
    	
    	//ablak létrehozása
        jFrame = new JFrame();
        try{
        	//config adatok beállítása az ablakon
            int w = Integer.parseInt(config[1]);
            int h = Integer.parseInt(config[2]);
            jFrame.setSize(w,h);
            num_of_maps = Integer.parseInt(config[3]);
        } catch (NumberFormatException e){
        	//amennyiben a config fájl tartalma nem konzisztens az elvárásokkal, alapértelmezett értékeket használunk
        	jFrame.setSize(800,600);
        	num_of_maps = 0;
        }
        //cím középre és felülre igazítva
        JLabel title = new JLabel("don Game - Stargates");
        ptitle = new JPanel();
        ptitle.add(title, BorderLayout.CENTER);
        
        
        //pályaválasztáshoz legördülõ lista:
        String[] combolabels = new String[num_of_maps];
        for (int i = 0; i < num_of_maps; i++){
        	combolabels[i] = "" + (i+1); 
        }
        //címkék hozzáadása
        mapselectbox = new JComboBox<>(combolabels);
        //tájékoztató felirat
        JLabel info = new JLabel("Please select map number below:");
        //ezeket tartalmazó panel
        maps = new JPanel();
        GridLayout mapsLayout = new GridLayout(20,0);
        //layout beállításe, elemek hozzáadása
        maps.setLayout(mapsLayout);
        maps.add(info);
        maps.add(mapselectbox);
        
        //gombpanel és gomb létrehozása, igazítások
        buttonpanel = new JPanel();
        startbutton = new JButton();
        startbutton.setText("Start!");
        buttonpanel.add(startbutton, BorderLayout.CENTER);
        ButtonActionListener buttlistener = new ButtonActionListener();
        startbutton.addActionListener(buttlistener);        
        
        //panelek ablakhoz hozzáadása
        jFrame.add(ptitle, BorderLayout.PAGE_START);
        jFrame.add(maps, BorderLayout.CENTER);
        jFrame.add(buttonpanel, BorderLayout.PAGE_END);
        
        
        /*
        //BorderLayout defLayout = new BorderLayout();
        //allpanels.setLayout(defLayout);
        allpanels.add(ptitle, BorderLayout.PAGE_START);
        allpanels.add(maps, BorderLayout.CENTER);
        allpanels.add(buttonpanel, BorderLayout.PAGE_END);
        jFrame.add(allpanels);*/
        
        jFrame.setResizable(false);
        jFrame.setVisible(true);
        
        
        
        
        //mapbetöltés teszt
        //controller.loadMap(10);

        jFrame.addKeyListener(controller);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      
    }
    
    /* 
     * config.ini fájlból adatok kiolvasása
     * az ablak és a pályabemeneti paraméterek így programon kívül egyszerûen testreszabható
     */
    private String[] getConfig(){
    	BufferedReader read;
    	
		try {
			//eltároljuk a configból beolvasott adatokat és a válasz eredményét
			String[] result = new String[CONFIG_SIZE+1];
			read = new BufferedReader(new FileReader("config.ini"));
			//beolvassuk a sorokat
			for (int i = 1; i < CONFIG_SIZE+1; i++ ){
				String row = read.readLine();
				String [] tmp = row.split(" ");
				result[i] = tmp[1];
			}
			read.close();
			//nyugtázzuk hogy minden jól ment
			result[0] = "ok!";
			return result;
		} catch (FileNotFoundException e) {
			//ha nem létezik a fájl
			e.printStackTrace();
			String[] result = new String[1];
			result[0] = "File not found";
			return result;
		} catch (IOException e) {
			//bármely io hiba esetén
			e.printStackTrace();
			String[] result = new String[1];
			result[0] = "Unexpected Error";
			return result;
		} 
    }

    @Override
    public void notifyView() {
        System.out.println("This view has been notified!");
    }

    @Override
    public void setData(DataAccessPoint data) {
        this.data = data;
    }

    public void drawMenu(){

    }
    
    private void drawBox(Coordinate coord) {}
    
    private void drawButton(Coordinate coord) {}
    
    private void drawFieldObject(FieldObject fieldObject, Coordinate coord) {}
    
    private void drawPlayer(Player player) {}
    
    private void drawStarGate(StarGate stargate) {}
    
    private void drawZPM(Coordinate coord) {}
    
    private void drawWin() {}
    
    private void drawGameOver() {}
    
    public void drawAll() {
    	Coordinate maxCoord = data.fields.getMaxCoords();
    	for(int i = 0; i < maxCoord.GetX(); i++){
    		for(int j = 0; j < maxCoord.GetY(); j++){
    			Coordinate coord = new Coordinate(i, j);
    			FieldObject fo = data.fields.GetFieldObject(coord);
    			if(fo != null)	
    				drawFieldObject(fo, coord);
    			boolean isThere = data.buttons.isThere(coord);
    			if(isThere)
    				drawButton(coord);
    			int boxes = data.boxes.isThereV2(coord);
    			while(boxes > 0){
    				drawBox(coord);
    				boxes--;
    			}
    			CVector cv = new CVector(i, j, Direction.North);
    			StarGate sg = data.stargates.GetStarGate(cv);
    			if(sg != null)
    				drawStarGate(sg);
    			cv = new CVector(i, j, Direction.West);
    			sg = data.stargates.GetStarGate(cv);
    			if(sg != null)
    				drawStarGate(sg);
    			cv = new CVector(i, j, Direction.East);
    			sg = data.stargates.GetStarGate(cv);
    			if(sg != null)
    				drawStarGate(sg);
    			cv = new CVector(i, j, Direction.South);
    			sg = data.stargates.GetStarGate(cv);
    			if(sg != null)
    				drawStarGate(sg);
    			isThere = data.collectables.IsThere(coord);
    			if(isThere)
    				drawZPM(coord);
    			cv = data.Colonel.getPos();
    			if(coord.equals(cv))
    				drawPlayer(data.Colonel);
    			cv = data.Jaffa.getPos();
    			if(coord.equals(cv))
    				drawPlayer(data.Jaffa);
    			cv = data.Repli.getPos();
    			if(coord.equals(cv))
    				drawPlayer(data.Repli);
    		}
    	}
    }
    
    
    class ButtonActionListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			int selectedmap = mapselectbox.getSelectedIndex() + 1;
			jFrame.remove(maps);
			jFrame.remove(ptitle);
			jFrame.remove(buttonpanel);
			jFrame.setVisible(false);
			jFrame.setVisible(true);
			
			controller.loadMap(selectedmap);
		}
		
    }
    
    
    
}
