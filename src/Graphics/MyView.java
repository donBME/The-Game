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
    
    /* ablak inicializ�l�sa:
     *   config bet�lt�se
     *   vez�rl�elemek elhelyez�se
     */
    private void initwindow(){
    	
    	//Adatok bet�lt�se
    	String[] config = getConfig();
    	//Ha nem sikeres visszajelz�st kapunk kil�p�nk
    	if(!config[0].equals("ok!"))
    		return;
    	
    	//ablak l�trehoz�sa
        jFrame = new JFrame();
        try{
        	//config adatok be�ll�t�sa az ablakon
            int w = Integer.parseInt(config[1]);
            int h = Integer.parseInt(config[2]);
            jFrame.setSize(w,h);
            num_of_maps = Integer.parseInt(config[3]);
        } catch (NumberFormatException e){
        	//amennyiben a config f�jl tartalma nem konzisztens az elv�r�sokkal, alap�rtelmezett �rt�keket haszn�lunk
        	jFrame.setSize(800,600);
        	num_of_maps = 0;
        }
        //c�m k�z�pre �s fel�lre igaz�tva
        JLabel title = new JLabel("don Game - Stargates");
        ptitle = new JPanel();
        ptitle.add(title, BorderLayout.CENTER);
        
        
        //p�lyav�laszt�shoz leg�rd�l� lista:
        String[] combolabels = new String[num_of_maps];
        for (int i = 0; i < num_of_maps; i++){
        	combolabels[i] = "" + (i+1); 
        }
        //c�mk�k hozz�ad�sa
        mapselectbox = new JComboBox<>(combolabels);
        //t�j�koztat� felirat
        JLabel info = new JLabel("Please select map number below:");
        //ezeket tartalmaz� panel
        maps = new JPanel();
        GridLayout mapsLayout = new GridLayout(20,0);
        //layout be�ll�t�se, elemek hozz�ad�sa
        maps.setLayout(mapsLayout);
        maps.add(info);
        maps.add(mapselectbox);
        
        //gombpanel �s gomb l�trehoz�sa, igaz�t�sok
        buttonpanel = new JPanel();
        startbutton = new JButton();
        startbutton.setText("Start!");
        buttonpanel.add(startbutton, BorderLayout.CENTER);
        ButtonActionListener buttlistener = new ButtonActionListener();
        startbutton.addActionListener(buttlistener);        
        
        //panelek ablakhoz hozz�ad�sa
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
        
        
        
        
        //mapbet�lt�s teszt
        //controller.loadMap(10);

        jFrame.addKeyListener(controller);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      
    }
    
    /* 
     * config.ini f�jlb�l adatok kiolvas�sa
     * az ablak �s a p�lyabemeneti param�terek �gy programon k�v�l egyszer�en testreszabhat�
     */
    private String[] getConfig(){
    	BufferedReader read;
    	
		try {
			//elt�roljuk a configb�l beolvasott adatokat �s a v�lasz eredm�ny�t
			String[] result = new String[CONFIG_SIZE+1];
			read = new BufferedReader(new FileReader("config.ini"));
			//beolvassuk a sorokat
			for (int i = 1; i < CONFIG_SIZE+1; i++ ){
				String row = read.readLine();
				String [] tmp = row.split(" ");
				result[i] = tmp[1];
			}
			read.close();
			//nyugt�zzuk hogy minden j�l ment
			result[0] = "ok!";
			return result;
		} catch (FileNotFoundException e) {
			//ha nem l�tezik a f�jl
			e.printStackTrace();
			String[] result = new String[1];
			result[0] = "File not found";
			return result;
		} catch (IOException e) {
			//b�rmely io hiba eset�n
			e.printStackTrace();
			String[] result = new String[1];
			result[0] = "Unexpected Error";
			return result;
		} 
    }

    @Override
    public void notifyView() {
        System.out.println("This view has been notified!");
		drawAll();
    }

    @Override
    public void setData(DataAccessPoint data) {
        this.data = data;
		drawAll();
    }

    public void drawMenu(){

    }
    
    private void drawBox(Coordinate coord) {}
    
    private void drawButton(Coordinate coord) {}
    
    private void drawFieldObject(FieldObject fieldObject, Coordinate coord) {

	}
    
    private void drawPlayer(Player player) {
		final int x = jFrame.getWidth() / OBJECT_WIDTH, y = jFrame.getHeight() / OBJECT_HEIGHT;
		CVector pos;

		// Colonel
		pos = data.Colonel.getPos();
		jFrame.add(new Kep("Don-Graphics/OneillUpstep1.png", x * pos.GetX(), y * pos.GetY(), x, y));
	}
    
    private void drawStarGate(StarGate stargate) {}
    
    private void drawZPM(Coordinate coord) {}
    
    private void drawWin() {}

    private void drawGameOver() {}
    
    private void drawAll() {
    	Coordinate maxCoord = data.fields.getMaxCoords();
		OBJECT_WIDTH = maxCoord.GetX();
		OBJECT_HEIGHT = maxCoord.GetY();
		jFrame.getContentPane().removeAll();

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
				if (data.Jaffa != null){
					cv = data.Jaffa.getPos();
					if(coord.equals(cv))
						drawPlayer(data.Jaffa);
				}
				if (data.Repli != null){
					cv = data.Repli.getPos();
					if(coord.equals(cv))
						drawPlayer(data.Repli);
				}
    		}
    	}
		jFrame.setVisible(true);
    }
    
    
    private class ButtonActionListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			int selectedmap = mapselectbox.getSelectedIndex() + 1;
			jFrame.remove(maps);
			jFrame.remove(ptitle);
			jFrame.remove(buttonpanel);
			
			controller.loadMap(selectedmap);
		}
		
    }
    
    
    
}
