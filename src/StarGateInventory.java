import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-m�rc.-2016 12:28:33
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
	 * @param color sz�n
	 */
	public void Create(CVector portalpos, StarGateColor color){
        System.out.println(">>StarGateInventory::Create(CVector portalpos, StarGateColor color)");
        System.out.println("<<StarGateInventory::Create(CVector portalpos, StarGateColor color)");
	}

	/**
	 * 
	 * @param color sz�n
	 */
	public void Delete(StarGateColor color){
        System.out.println(">>StarGateInventory::Delete(StarGateColor color)");
        System.out.println("<<StarGateInventory::Delete(StarGateColor color)");
	}
	
	/**
	 * @author Mate
	 * @param pos A player l�p�s�ek helye
	 * @return A bel�p�s ir�ny�nak megfelel� ir�ny� poz�c�
	 * Amikor Bel�p�nk egy csillagkapuba
	 * akkor az a l�p�s ir�ny�nak
	 * ellenkez� ir�nyb�l ny�lik.
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
	 * @param from ir�ny
	 * @return A megadottkoordin�t�n van-e csillagkapu
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
	 * @param exitGatePos A f�r�gj�rat kij�rat�nak poz�ci�ja 
	 * @return A f�regj�rat kijarata el�tti koordin�ta
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
	 * @param from A bel�p�ls ir�nya
	 * @return A f�regj�rat el�tti poz�ci�
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