package Graphics;

import Inventories.DataAccessPoint;
import Players.Colonel;
import Players.Jaffa;
import Players.Player;
import Players.Replicator;
import Tools.CVector;
import Tools.Controller;
import Tools.Coordinate;
import Tools.Direction;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;

import javax.imageio.ImageIO;
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
	private HashMap<String,ImageIcon> iconBuffer;

    private int OBJECT_WIDTH, OBJECT_HEIGHT;
	private Coordinate maxCoord;

    public MyView(){
    	controller = new Controller(this);
    	initwindow();
	}

	private void loadIcons() throws IOException {
		iconBuffer = new HashMap<>();

		iconBuffer.put("ColonelUp",new ImageIcon(ImageIO.read(new File("Don-Graphics/OneilUpstep1/upOneillUpstep1.png")).
				getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
		iconBuffer.put("ColonelRight",new ImageIcon(ImageIO.read(new File("Don-Graphics/OneilUpstep1/rightOneillUpstep1.png")).
				getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
		iconBuffer.put("ColonelLeft",new ImageIcon(ImageIO.read(new File("Don-Graphics/OneilUpstep1/leftOneillUpstep1.png")).
				getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
		iconBuffer.put("ColonelDown",new ImageIcon(ImageIO.read(new File("Don-Graphics/OneilUpstep1/downOneillUpstep1.png")).
				getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));

		iconBuffer.put("JaffaUp",new ImageIcon(ImageIO.read(new File("Don-Graphics/JaffaStep1/upJaffaStep1.png")).
				getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
		iconBuffer.put("JaffaRight",new ImageIcon(ImageIO.read(new File("Don-Graphics/JaffaStep1/rightJaffaStep1.png")).
				getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
		iconBuffer.put("JaffaLeft",new ImageIcon(ImageIO.read(new File("Don-Graphics/JaffaStep1/leftJaffaStep1.png")).
				getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
		iconBuffer.put("JaffaDown",new ImageIcon(ImageIO.read(new File("Don-Graphics/JaffaStep1/downJaffaStep1.png")).
				getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));

		iconBuffer.put("ReplicatorUp",new ImageIcon(ImageIO.read(new File("Don-Graphics/Replicator/upReplicator.png")).
				getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
		iconBuffer.put("ReplicatorRight",new ImageIcon(ImageIO.read(new File("Don-Graphics/Replicator/rightReplicator.png")).
				getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
		iconBuffer.put("ReplicatorLeft",new ImageIcon(ImageIO.read(new File("Don-Graphics/Replicator/leftReplicator.png")).
				getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
		iconBuffer.put("ReplicatorDown",new ImageIcon(ImageIO.read(new File("Don-Graphics/Replicator/downReplicator.png")).
				getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));

		iconBuffer.put("Way",new ImageIcon(ImageIO.read(new File("Don-Graphics/way.png")).
				getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));

		iconBuffer.put("SpecWall",new ImageIcon(ImageIO.read(new File("Don-Graphics/SpecWall.png")).
				getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));

		iconBuffer.put("Wall",new ImageIcon(ImageIO.read(new File("Don-Graphics/wall.png")).
				getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));

		iconBuffer.put("ZPM",new ImageIcon(ImageIO.read(new File("Don-Graphics/ZPM.png")).
				getScaledInstance(OBJECT_WIDTH / 2, OBJECT_HEIGHT / 2, Image.SCALE_SMOOTH)));

		iconBuffer.put("Abyss",new ImageIcon(ImageIO.read(new File("Don-Graphics/Abyss.png")).
				getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));

		iconBuffer.put("RightYellowGate",new ImageIcon(ImageIO.read(new File("Don-Graphics/rightYellowGate.png")).
				getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
		iconBuffer.put("LeftYellowGate",new ImageIcon(ImageIO.read(new File("Don-Graphics/leftYellowGate.png")).
				getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
		iconBuffer.put("UpYellowGate",new ImageIcon(ImageIO.read(new File("Don-Graphics/upYellowGate.png")).
				getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
		iconBuffer.put("DownYellowGate",new ImageIcon(ImageIO.read(new File("Don-Graphics/downYellowGate.png")).
				getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));

		iconBuffer.put("RightGreenGate",new ImageIcon(ImageIO.read(new File("Don-Graphics/rightGreenGate.png")).
				getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
		iconBuffer.put("LeftGreenGate",new ImageIcon(ImageIO.read(new File("Don-Graphics/leftGreenGate.png")).
				getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
		iconBuffer.put("UpGreenGate",new ImageIcon(ImageIO.read(new File("Don-Graphics/upGreenGate.png")).
				getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
		iconBuffer.put("DownGreenGate",new ImageIcon(ImageIO.read(new File("Don-Graphics/downGreenGate.png")).
				getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));

		iconBuffer.put("RightRedGate",new ImageIcon(ImageIO.read(new File("Don-Graphics/rightRedGate.png")).
				getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
		iconBuffer.put("LeftRedGate",new ImageIcon(ImageIO.read(new File("Don-Graphics/leftRedGate.png")).
				getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
		iconBuffer.put("UpRedGate",new ImageIcon(ImageIO.read(new File("Don-Graphics/upRedGate.png")).
				getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
		iconBuffer.put("DownRedGate",new ImageIcon(ImageIO.read(new File("Don-Graphics/downRedGate.png")).
				getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));

		iconBuffer.put("RightBlueGate",new ImageIcon(ImageIO.read(new File("Don-Graphics/rightBlueGate.png")).
				getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
		iconBuffer.put("LeftBlueGate",new ImageIcon(ImageIO.read(new File("Don-Graphics/leftBlueGate.png")).
				getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
		iconBuffer.put("UpBlueGate",new ImageIcon(ImageIO.read(new File("Don-Graphics/upBlueGate.png")).
				getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
		iconBuffer.put("DownBlueGate",new ImageIcon(ImageIO.read(new File("Don-Graphics/downBlueGate.png")).
				getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));

		iconBuffer.put("Box",new ImageIcon(ImageIO.read(new File("Don-Graphics/box.png")).
				getScaledInstance(OBJECT_WIDTH / 2, OBJECT_HEIGHT / 2, Image.SCALE_SMOOTH)));

		iconBuffer.put("ButtonOpened",new ImageIcon(ImageIO.read(new File("Don-Graphics/ButtonOpened.png")).
				getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
		iconBuffer.put("ButtonClosed",new ImageIcon(ImageIO.read(new File("Don-Graphics/ButtonClosed.png")).
				getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));

		iconBuffer.put("DoorOpened",new ImageIcon(ImageIO.read(new File("Don-Graphics/DoorOpened.png")).
				getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
		iconBuffer.put("DoorClosed",new ImageIcon(ImageIO.read(new File("Don-Graphics/DoorClosed.png")).
				getScaledInstance(OBJECT_WIDTH, OBJECT_HEIGHT, Image.SCALE_SMOOTH)));
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
		maxCoord = data.fields.getMaxCoords();
		OBJECT_WIDTH = jFrame.getWidth() / (maxCoord.GetX() + 1);
		OBJECT_HEIGHT = jFrame.getHeight() / (maxCoord.GetY() + 1);
		try {
			loadIcons();
		} catch (IOException ignored) {
		}
		drawAll();
    }

    public void drawMenu(){

    }
    
    private void drawBox(Coordinate coord, int subPosition) {
		JLabel label = new JLabel();

		ImageIcon img = iconBuffer.get("Box");

		label.setIcon(img);
		switch (subPosition){
			case 1:
				label.setBounds(OBJECT_WIDTH * coord.GetX() + OBJECT_WIDTH / 4,
						jFrame.getHeight() - OBJECT_HEIGHT * (coord.GetY() + 1),
						OBJECT_WIDTH, OBJECT_HEIGHT);
				break;
			case 2:
				label.setBounds(OBJECT_WIDTH * coord.GetX(),
						jFrame.getHeight() - OBJECT_HEIGHT * (coord.GetY() + 1) - OBJECT_HEIGHT / 4,
						OBJECT_WIDTH, OBJECT_HEIGHT);
				break;
			case 3:
				label.setBounds(OBJECT_WIDTH * coord.GetX(),
						jFrame.getHeight() - OBJECT_HEIGHT * (coord.GetY() + 1) + OBJECT_HEIGHT / 4,
						OBJECT_WIDTH, OBJECT_HEIGHT);
				break;
			case 4:
				label.setBounds(OBJECT_WIDTH * coord.GetX() + OBJECT_WIDTH / 2,
						jFrame.getHeight() - OBJECT_HEIGHT * (coord.GetY() + 1) + OBJECT_HEIGHT / 4,
						OBJECT_WIDTH, OBJECT_HEIGHT);
				break;
			case 5:
				label.setBounds(OBJECT_WIDTH * coord.GetX() + OBJECT_WIDTH / 2,
						jFrame.getHeight() - OBJECT_HEIGHT * (coord.GetY() + 1) - OBJECT_HEIGHT / 4,
						OBJECT_WIDTH, OBJECT_HEIGHT);
				break;
		}
		jFrame.add(label);
	}
    
    private void drawButton(Coordinate coord) {
		JLabel label = new JLabel();
		ImageIcon img;

		if (data.buttons.isOpenAt(coord)) {
			img = iconBuffer.get("ButtonOpened");
		}
		else {
			img = iconBuffer.get("ButtonClosed");
		}

		label.setIcon(img);
		label.setBounds(OBJECT_WIDTH * coord.GetX(), jFrame.getHeight() - OBJECT_HEIGHT * (coord.GetY() + 1),
				OBJECT_WIDTH, OBJECT_HEIGHT);
		jFrame.add(label);
	}
    
    private void drawFieldObject(FieldObject fieldObject, Coordinate coord) {

		JLabel label = new JLabel();
		ImageIcon img = null;

		//Way
		if (fieldObject.Steppable()){
			if (fieldObject.isDoor()) {
				img = iconBuffer.get("DoorOpened");
			}
			else if (!fieldObject.IsMortal()){
				img = iconBuffer.get("Way");
			}
			else if (fieldObject.IsMortal()){
				img = iconBuffer.get("Abyss");
			}
		}
		else {
			if (fieldObject.isDoor()) {
				img = iconBuffer.get("DoorClosed");
			}
			else if (fieldObject.Shootable()) {
				img = iconBuffer.get("SpecWall");
			}
			else {
				img = iconBuffer.get("Wall");
			}
		}

		if (img != null){
			label.setIcon(img);
			label.setBounds(OBJECT_WIDTH * coord.GetX(), jFrame.getHeight() - OBJECT_HEIGHT * (coord.GetY() + 1),
					OBJECT_WIDTH, OBJECT_HEIGHT);
			jFrame.add(label);
		}

	}
    
    private void drawPlayer(Jaffa jaffa) {
		CVector pos;
		JLabel label = new JLabel();

		// Jaffa
		ImageIcon img = null;
		pos = jaffa.getPos();
		switch (pos.GetDir()){
			case East:
				img = iconBuffer.get("JaffaRight");
				break;
			case North:
				img = iconBuffer.get("JaffaUp");
				break;
			case West:
				img = iconBuffer.get("JaffaLeft");
				break;
			case South:
				img = iconBuffer.get("JaffaDown");
				break;
		}

		if (jaffa.hasBox()) {
			drawBox(pos,1);
		}

		label.setIcon(img);
		label.setBounds(OBJECT_WIDTH * pos.GetX(), jFrame.getHeight() - OBJECT_HEIGHT * (pos.GetY() + 1),
				OBJECT_WIDTH, OBJECT_HEIGHT);
		jFrame.add(label);
	}

	private void drawPlayer(Replicator replicator) {
		CVector pos;
		JLabel label = new JLabel();

		// Replicator
		ImageIcon img = null;
		pos = replicator.getPos();
		switch (pos.GetDir()){
			case East:
				img = iconBuffer.get("ReplicatorRight");
				break;
			case North:
				img = iconBuffer.get("ReplicatorUp");
				break;
			case West:
				img = iconBuffer.get("ReplicatorLeft");
				break;
			case South:
				img = iconBuffer.get("ReplicatorDown");
				break;
		}
		label.setIcon(img);
		label.setBounds(OBJECT_WIDTH * pos.GetX(), jFrame.getHeight() - OBJECT_HEIGHT * (pos.GetY() + 1),
				OBJECT_WIDTH, OBJECT_HEIGHT);
		jFrame.add(label);
	}

	private void drawPlayer(Colonel colonel) {
		CVector pos;
		JLabel label = new JLabel();

		// Colonel
		ImageIcon img = null;
		pos = colonel.getPos();
		switch (pos.GetDir()){
			case East:
				img = iconBuffer.get("ColonelRight");
				break;
			case North:
				img = iconBuffer.get("ColonelUp");
				break;
			case West:
				img = iconBuffer.get("ColonelLeft");
				break;
			case South:
				img = iconBuffer.get("ColonelDown");
				break;
		}

		if (colonel.hasBox()) {
			drawBox(pos,1);
		}

		label.setIcon(img);
		label.setBounds(OBJECT_WIDTH * pos.GetX(), jFrame.getHeight() - OBJECT_HEIGHT * (pos.GetY() + 1),
				OBJECT_WIDTH, OBJECT_HEIGHT);
		jFrame.add(label);
	}
    private void drawStarGate(StarGate stargate) {
		JLabel label = new JLabel();
		ImageIcon img = null;
		CVector pos = stargate.GetPos();

		switch (stargate.getColor()){
			case Yellow:
				switch (pos.GetDir()){
					case East:
						img = iconBuffer.get("RightYellowGate");
						break;
					case North:
						img = iconBuffer.get("UpYellowGate");
						break;
					case West:
						img = iconBuffer.get("LeftYellowGate");
						break;
					case South:
						img = iconBuffer.get("DownYellowGate");
						break;
				}
				break;
			case Blue:
				switch (pos.GetDir()){
					case East:
						img = iconBuffer.get("RightBlueGate");
						break;
					case North:
						img = iconBuffer.get("UpBlueGate");
						break;
					case West:
						img = iconBuffer.get("LeftBlueGate");
						break;
					case South:
						img = iconBuffer.get("DownBlueGate");
						break;
				}
				break;
			case Red:
				switch (pos.GetDir()){
					case East:
						img = iconBuffer.get("RightRedGate");
						break;
					case North:
						img = iconBuffer.get("UpRedGate");
						break;
					case West:
						img = iconBuffer.get("LeftRedGate");
						break;
					case South:
						img = iconBuffer.get("DownRedGate");
						break;
				}
				break;
			case Green:
				switch (pos.GetDir()){
					case East:
						img = iconBuffer.get("RightGreenGate");
						break;
					case North:
						img = iconBuffer.get("UpGreenGate");
						break;
					case West:
						img = iconBuffer.get("LeftGreenGate");
						break;
					case South:
						img = iconBuffer.get("DownGreenGate");
						break;
				}
				break;
		}

		label.setIcon(img);
		label.setBounds(OBJECT_WIDTH * pos.GetX(), jFrame.getHeight() - OBJECT_HEIGHT * (pos.GetY() + 1),
				OBJECT_WIDTH, OBJECT_HEIGHT);
		jFrame.add(label);
	}
    
    private void drawZPM(Coordinate coord) {
		JLabel label = new JLabel();

		ImageIcon img = iconBuffer.get("ZPM");

		label.setIcon(img);
		label.setBounds(OBJECT_WIDTH * coord.GetX() + OBJECT_WIDTH / 4, jFrame.getHeight() - OBJECT_HEIGHT * (coord.GetY() + 1),
				OBJECT_WIDTH, OBJECT_HEIGHT);
		jFrame.add(label);
	}
    
    private void drawWin() {

	}

    private void drawGameOver() {}
    
    private void drawAll() {
		jFrame.getContentPane().removeAll();

		if (data.collectables.ZPMCount() == 0) {
			drawWin();
			jFrame.repaint();
			return;
		}
		else if (data.Colonel.getPos() == null || (data.Jaffa != null && data.Jaffa.getPos() == null)) {
			drawGameOver();
			jFrame.repaint();
			return;
		}

    	for(int i = 0; i <= maxCoord.GetX(); i++){
    		for(int j = 0; j <= maxCoord.GetY(); j++){
    			Coordinate coord = new Coordinate(i, j);
    			FieldObject fo = data.fields.GetFieldObject(coord);

				CVector cv;

				cv = data.Colonel.getPos();
				if(coord.equals(cv))
					drawPlayer((Colonel)data.Colonel);

				if (data.Jaffa != null){
					cv = data.Jaffa.getPos();
					if(coord.equals(cv))
						drawPlayer((Jaffa)data.Jaffa);
				}
				if (data.Repli != null){
					cv = data.Repli.getPos();
					if(coord.equals(cv))
						drawPlayer((Replicator)data.Repli);
				}

				int boxes = data.boxes.isThereV2(coord);
				while (boxes > 0){
					drawBox(coord, boxes);
					boxes--;
				}

				boolean isThere = data.buttons.isThere(coord);
				if(isThere)
					drawButton(coord);

				cv = new CVector(i, j, Direction.North);
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

    			if(fo != null)	
    				drawFieldObject(fo, coord);
    		}
    	}
		jFrame.repaint();
    }
    
    
    private class ButtonActionListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			int selectedmap = mapselectbox.getSelectedIndex() + 1;
			jFrame.remove(maps);
			jFrame.remove(ptitle);
			jFrame.remove(buttonpanel);
			jFrame.setLayout(null);

			controller.loadMap(selectedmap);
		}
		
    }
    
    
    
}
