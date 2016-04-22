package Tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import Handlers.GrabHandler;
import Handlers.ShotHandler;
import Handlers.StepHandler;
import Inventories.BoxInventory;
import Inventories.ButtonInventory;
import Inventories.CollectableInventory;
import Inventories.DataAccessPoint;
import Inventories.FieldObjectInventory;
import Inventories.StarGateInventory;
import Players.Player;

public class TestHandler {
	DataAccessPoint dataStore;
	LoadField fieldLoader;
	
	private FieldObjectInventory fieldObjectInventory;
    private StarGateInventory stargateInventory;
    private BoxInventory boxInventory;
    private ButtonInventory buttonInventory;
    private CollectableInventory collectableInventory;
    
    private DataAccessPoint dataAccesspoint;
	
	/**
	 * TestHandler konstruktor.
	 *
	 * @param fLoader   Pályabetöltõ
	 */
	public TestHandler(LoadField fLoader )
	{
		fieldLoader = fLoader;
	}
	
	public void test(int testNum)
	{
		
		//init
        fieldObjectInventory = new FieldObjectInventory();
        stargateInventory = new StarGateInventory();
        boxInventory = new BoxInventory();
        buttonInventory = new ButtonInventory();
        collectableInventory = new CollectableInventory();
        
        dataAccesspoint = new DataAccessPoint(stargateInventory, fieldObjectInventory, boxInventory, buttonInventory, collectableInventory);
        collectableInventory.setData(dataAccesspoint);
		
        //mapbetöltés
		fieldLoader.Load("testmap" + testNum + ".txt", dataAccesspoint);
		
		//kezdeti állapot		
		drawTMap();
		
		//utasítások végrehajtása
		//tesztbemenet betöltés
		String FileName = "test" + testNum + "in.txt";
		try
		{
			BufferedReader read = new BufferedReader(new FileReader(FileName));
			String str;
			//egyenlõre csak kiírjuk
			while((str = read.readLine())!= null)
			{
				System.out.print("in: " + str + "\n");
				String tmp[] = str.split(" ");	
				//szétválasztunk játékosra, csak akkor hívjuk tovább ha létezik is
				if (tmp[0].equals("Colonel"))
				{
					if (dataAccesspoint.Colonel != null)
					{
						playerAction(dataAccesspoint.Colonel, tmp);
					}
				} else if (tmp[0].equals("Jaffa"))
				{
					if (dataAccesspoint.Jaffa != null)
					{
						playerAction(dataAccesspoint.Jaffa, tmp);
					}
				}
				
				drawTMap();
			}		
			read.close();
		}catch(IOException e)
		{
			 System.out.print("Hiba a betöltés során. " + e.getMessage());
		}
		
		/* replikátorok indítása 
		 * FIXME a playersbe csak replikátorokat!! nem tudunk thread-et indítani mert nem látja hogy replicator
		 * Thread[] replicatorTreads = new Thread[dataAccesspoint.players.size()];
		for (int i = 0; i < dataAccesspoint.players.size(); i++){
			replicatorTreads[i] = new Thread(dataAccesspoint.players.get(i));
			replicatorTreads[i].start();
		}*/

		
		//végállapot
		//drawTMap();
	}
	
	
	//megadott játékossal lép
	private void step(Player p, String dirstr){
		Direction dir;
		switch (dirstr){
		case "East": 
			 dir = Direction.valueOf("East");
			 p.Step(dir);
			break;
		case "North":
			 dir = Direction.valueOf("North");
			 p.Step(dir);
			break;
		case "West":
			 dir = Direction.valueOf("West");
			 p.Step(dir);
			break;
		case "South":
			 dir = Direction.valueOf("South");
			 p.Step(dir);
			break;
		default:
			break;
		}
	}
	
	private void shoot(Player p, String colorstr, boolean blueandyellow){
		StarGateColor col;
		if (blueandyellow){
			switch (colorstr){
			case "Blue": 
				 col = StarGateColor.valueOf("Blue");
				 p.Shoot(col);
				break;
			case "Yellow":
				 col = StarGateColor.valueOf("Yellow");
				 p.Shoot(col);
				break;
			default:
				break;
			}
		} else {
			switch (colorstr){
			case "Green": 
				 col = StarGateColor.valueOf("Green");
				 p.Shoot(col);
				break;
			case "Red":
				 col = StarGateColor.valueOf("Red");
				 p.Shoot(col);
				break;
			default:
				break;
			}
		}
	}

	private void playerAction(Player p, String[] commands)
	{
		switch (commands[1]){
		case "Step": 
				step(p, commands[2]);
			break;
		case "Shoot":
				shoot(p, commands[2], commands[0].equals("Colonel"));
			break;
		case "Interact":
			    p.Interact(p.getPos());
			break;
		default:
			break;
		}
	}
	
	
	public void writeResult() {
		try{
			PrintWriter wr = new PrintWriter(new FileWriter(new File("file")));
			wr.println("ezt meg kell még írni");
			wr.close();
		}catch(IOException e)
		{
			 System.out.print("Hiba a kiírás során. " + e.getMessage());
		}
		
	}
	
	private void drawTMap() {
    		
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                Coordinate thisCoord = new Coordinate(x, y);
                if (dataAccesspoint.Colonel != null && dataAccesspoint.Colonel.getPos() != null && dataAccesspoint.Colonel.getPos().toCoord().equals(thisCoord)) {
                    System.out.print((dataAccesspoint.Colonel.hasBox()) ? "|F " : "|E ");
                } else if (dataAccesspoint.Jaffa != null && dataAccesspoint.Jaffa.getPos() != null && dataAccesspoint.Jaffa.getPos().toCoord().equals(thisCoord)) {
                    System.out.print((dataAccesspoint.Jaffa.hasBox()) ? "|H " : "|J ");
                }
                /*else if(rep1.getPos()!= null && rep1.getPos().toCoord().equals(thisCoord))
                {
                    System.out.print("|R ");
                }*/
                else if (boxInventory.IsThere(thisCoord)) {
                    System.out.print("|B ");
                } else if (collectableInventory.IsThere(thisCoord)) {
                    System.out.print("|Z ");
                } else if (buttonInventory.isThere(thisCoord)) {
                    System.out.print("|_ ");
                } else if (stargateInventory.IsThere(new CVector(x, y, Direction.North))
                        || stargateInventory.IsThere(new CVector(x, y, Direction.East))
                        || stargateInventory.IsThere(new CVector(x, y, Direction.South))
                        || stargateInventory.IsThere(new CVector(x, y, Direction.West))) {
                    System.out.print("|O ");
                } else if (fieldObjectInventory.GetFieldObject(thisCoord).Steppable()
                        && !fieldObjectInventory.GetFieldObject(thisCoord).IsMortal()) {
                    System.out.print("|  ");
                } else if (fieldObjectInventory.GetFieldObject(thisCoord).IsMortal()) {
                    System.out.print("|A ");
                } else if (!fieldObjectInventory.GetFieldObject(thisCoord).Steppable()) {
                    System.out.print("|X ");
                }
            }
            System.out.println();
        }
	
	}
}
