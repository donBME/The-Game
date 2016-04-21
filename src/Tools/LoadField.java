package Tools;

import java.io.BufferedReader;
import java.io.FileReader;
import Inventories.DataAccessPoint;
import GameObjects.*;
import Handlers.*;
import Players.*;

// Viktor
public class LoadField {
	private String s;
	private String[] objs;
	private DataAccessPoint data;
	public void Load(String FileName, DataAccessPoint Data) // <> helyett ; lesz, igy formatum: FieldObject;x;y
	{
		data = Data;
		try
		{
			BufferedReader read = new BufferedReader(new FileReader(FileName));
			read.readLine();
			read.readLine();
			while((s = read.readLine())!= null)
			{
				objs = s.split(";");
				switch ( objs[0]) // itt mindenbol uj van letrehozva, ezert ilyen hosszuak
				{
					case "p": data.players.add(new Colonel(new ShotHandler(data), new GrabHandler(data), new StepHandler(data, true), Integer.parseInt(objs[1]), Integer.parseInt(objs[2]))); break;
					case "j": data.players.add(new Jaffa(new ShotHandler(data), new GrabHandler(data), new StepHandler(data, true), Integer.parseInt(objs[1]), Integer.parseInt(objs[2]))); break;
					case "r": data.players.add(new Replicator(new ShotHandler(data), new GrabHandler(data), new StepHandler(data, false), Integer.parseInt(objs[1]), Integer.parseInt(objs[2])));break;
					case "a": data.fields.addFieldObject(new Coordinate(Integer.parseInt(objs[1]), Integer.parseInt(objs[2])), new Abyss());break;
					case "z": data.collectables.addCollectable(new Coordinate(Integer.parseInt(objs[1]), Integer.parseInt(objs[2])), new ZPM());break;
					case "d": this.addButtonDoor(read.readLine(), s);break;
					case "wl": data.fields.addFieldObject(new Coordinate(Integer.parseInt(objs[1]), Integer.parseInt(objs[2])), new Wall());break;
					case "sw": data.fields.addFieldObject(new Coordinate(Integer.parseInt(objs[1]), Integer.parseInt(objs[2])), new SpecialWall());break;
					case "bx": data.boxes.addBox(new Coordinate(Integer.parseInt(objs[1]), Integer.parseInt(objs[2])), new Box());break;
					case "wy": data.fields.addFieldObject(new Coordinate(Integer.parseInt(objs[1]), Integer.parseInt(objs[2])), new Way()); break;
					
				}
			}
			read.close();
		}catch(Exception e){}
	}
	/* Kulon rakom ossze az ajtot, meg a merleget, hogy ne legyen ronda
	 * 	viszont a merlegek sulyozasara nem gondoltam, azt meg ki kell kuszobolni*/
	
	private void addButtonDoor(String s1, String s2)
	{
		objs = s2.split(";");
		Door door = new Door();
		data.fields.addFieldObject(new Coordinate(Integer.parseInt(objs[1]), Integer.parseInt(objs[2])), door);
		objs = s1.split(";");
		data.buttons.addButton(new Coordinate(Integer.parseInt(objs[1]), Integer.parseInt(objs[2])), new Button(door, Integer.parseInt(objs[3])));
	}
}