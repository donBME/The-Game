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
	private QuestionAssistant questionAssistant = new QuestionAssistant();

	
	public StarGateInventory(){
		System.out.println(">>StarGateInventory::StarGateInventory()");
		System.out.println("<<StarGateInventory::StarGateInventory()");
	}
	/**
	 * 
	 * @param portalpos csillagkapu helye
	 * @param color szín
	 */
	public void Create(CVector portalpos, StarGateColor color){
        System.out.println(">>StarGateInventory::Create(CVector portalpos, StarGateColor color)");
        System.out.println("<<StarGateInventory::Create(CVector portalpos, StarGateColor color)");
	}

	/**
	 * 
	 * @param color szín
	 */
	public void Delete(StarGateColor color){
        System.out.println(">>StarGateInventory::Delete(StarGateColor color)");
        System.out.println("<<StarGateInventory::Delete(StarGateColor color)");
	}
	
	/**
	 * @author Mate
	 * @param pos A player lépéséek helye
	 * @return A belépés irányának megfelelõ irányú pozícó
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
			return new CVector(pos.GetX()-1, pos.GetY(), Direction.East);
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
		if(yellow != null && yellow.GetPos() == f){
			return true;
		} else if(blue != null && blue.GetPos() == f){
			return true;
		} else if(red != null && red.GetPos() == f){
			return true;
		} else if(green != null && green.GetPos() == f){
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
		if(yellow != null && yellow.GetPos() == f){
			if(blue != null){
				return ExitPos(blue.GetPos());
			} else return from;
		} else if(blue != null && blue.GetPos() == f){
			if(yellow != null){
				return ExitPos(yellow.GetPos());
			} else return from;
		} else if(red != null && red.GetPos() == f){
			if(green != null){
				return ExitPos(green.GetPos());
			} else return from;
		} else if(green != null && green.GetPos() == f){
			if(red != null){
				return ExitPos(red.GetPos());
			} else return from;
		} else {
			return from;
		}
	}

}