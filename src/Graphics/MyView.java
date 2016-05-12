package Graphics;

import Inventories.DataAccessPoint;
import Players.Player;
import Tools.CVector;
import Tools.Controller;
import Tools.Coordinate;
import Tools.Direction;

import javax.swing.*;



import GameObjects.FieldObject;
import GameObjects.StarGate;

/**
 * @author Laszlo
 * @version 1.0
 */

public class MyView implements Notifiable{

    private DataAccessPoint data;
    private Controller controller;

    private int OBJECT_WIDTH, OBJECT_HEIGHT;

    public MyView(){
        JFrame jFrame = new JFrame();
        jFrame.setSize(600,600);
        jFrame.setVisible(true);
        controller = new Controller(this);
        controller.loadMap(10);

        jFrame.addKeyListener(controller);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
}
