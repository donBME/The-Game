import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:33
 */
public class StarGateInventory {
	
    private StarGate yellow, blue, red, green;

	
	public StarGateInventory(){}

	/**
	 * Adott színü csillagkapu létrehozása, adott pozíción.
	 * @param portalpos Csillagkapu helye
	 * @param color Csillagkapu színe
     */
	public void Create(CVector portalpos, StarGateColor color){
		switch (color){
			case Yellow:
				Delete(StarGateColor.Yellow);
				yellow = new StarGate(EnterPos(portalpos),color);
				break;
			case Blue:
				Delete(StarGateColor.Blue);
				blue = new StarGate(EnterPos(portalpos),color);
				break;
			case Red:
				Delete(StarGateColor.Red);
				red = new StarGate(EnterPos(portalpos),color);
				break;
			case Green:
				Delete(StarGateColor.Green);
				green = new StarGate(EnterPos(portalpos),color);
				break;
		}
	}

	/**
	 * Adott színü csillagkapu törlése
	 * @param color Törölni kívánt csillagkapu színe
     */
	public void Delete(StarGateColor color){
		switch (color){
			case Yellow:
				yellow = null;
				break;
			case Blue:
				blue = null;
				break;
			case Red:
				red = null;
				break;
			case Green:
				green = null;
				break;
		}
	}
	
	/**
	 * @author Mate
	 * @param pos A player lépésének helye
	 * @return A belépés irányának megfelelõ irányú pozíció
	 * Amikor Belépünk egy csillagkapuba
	 * akkor az a lépés irányának
	 * ellenkezõ irányból nyílik.
	 */
	private CVector EnterPos(CVector pos){
		switch (pos.GetDir()){
		case North:
			return new CVector(pos.GetX(), pos.GetY(), Direction.South);
		case South:
			return new CVector(pos.GetX(), pos.GetY(), Direction.North);
		case East:
			return new CVector(pos.GetX(), pos.GetY(), Direction.West);
		case West:
			return new CVector(pos.GetX(), pos.GetY(), Direction.East);
		default: return null;
		}
	}
	
	/**
	 * @author Mate
	 * @param from irány
	 * @return A megadottkoordinátán van-e csillagkapu
	 */
	public boolean IsThere(CVector from){
		CVector f = EnterPos(from);
		if(yellow != null && yellow.GetPos().equals(f)){
			return true;
		} else if(blue != null && blue.GetPos().equals(f)){
			return true;
		} else if(red != null && red.GetPos().equals(f)){
			return true;
		} else if(green != null && green.GetPos().equals(f)){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @author Mate
	 * @param exitGatePos A férégjárat kijáratának pozíciója 
	 * @return A féregjárat kijarata elõtti koordináta
	 */
	private CVector ExitPos(CVector exitGatePos){
		switch (exitGatePos.GetDir()){
		case North:
			return new CVector(exitGatePos.GetX(), exitGatePos.GetY()+1, Direction.North);
		case South:
			return new CVector(exitGatePos.GetX(), exitGatePos.GetY()-1, Direction.South);
		case East:
			return new CVector(exitGatePos.GetX()+1, exitGatePos.GetY(), Direction.East);
		case West:
			return new CVector(exitGatePos.GetX()-1, exitGatePos.GetY(), Direction.West);
		default: return null;
		}
	}
	

	/**
	 * @author Mate
	 * @param from A belépéls iránya
	 * @return A féregjárat elõtti pozíció
	 */
	public CVector StepIn(CVector from){
		CVector f = EnterPos(from);
		if(yellow != null && yellow.GetPos().equals(f)){
			if(blue != null){
				return ExitPos(blue.GetPos());
			} else return from;
		} else if(blue != null && blue.GetPos().equals(f)){
			if(yellow != null){
				return ExitPos(yellow.GetPos());
			} else return from;
		} else if(red != null && red.GetPos().equals(f)){
			if(green != null){
				return ExitPos(green.GetPos());
			} else return from;
		} else if(green != null && green.GetPos().equals(f)){
			if(red != null){
				return ExitPos(red.GetPos());
			} else return from;
		} else {
			return from;
		}
	}

}