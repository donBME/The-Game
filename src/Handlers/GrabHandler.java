package Handlers;

import GameObjects.Box;
import Inventories.DataAccessPoint;
import Tools.CVector;
import Tools.Coordinate;

/**
 * @author Laszlo
 * @version 1.0
 */
public class GrabHandler {

	// Adattároló
	private DataAccessPoint data;

	/**
	 * Konstruktor
	 *
	 * @param data Adattároló
	 */
	public GrabHandler(DataAccessPoint data){
		this.data = data;
	}

	/**
	 * Doboz felvétele
	 * @param interactfrom Játékos helye a felvételkor
	 */
	public Box Grab(CVector interactfrom) {

		// A felvenni kívánt doboz pozíciója
		Coordinate checkedPos = interactfrom.toNextCoord();

		// Csillagkapun keresztüli dobozfelvétel lehetövé tétele
		if(data.stargates.IsThere(interactfrom.toNextCoord())){
            checkedPos = data.stargates.StepIn(interactfrom.toNextCoord());
		}

		// Van doboz a kiszemelt pozíción?
		if(data.boxes.IsThere(checkedPos)){
            Box returnBox;

			// Felvett doboz
			returnBox =  data.boxes.GetBox(interactfrom.toNextCoord());

			if (returnBox != null){
				System.out.print("has grabbed an item at " + checkedPos.GetX() + "," + checkedPos.GetY() + " ");
			}

			// Gomb felengedés kezelése
			data.buttons.EventOn(checkedPos, data.boxes.isThereV2(checkedPos));

			return returnBox;
        }
        return null;
	}
	
	/**
	 * Rakható-e a kijelölt pozícióra doboz.
	 * @param interactfrom belépés iránya
	 */
	private boolean CanPut(Tools.CVector interactfrom) {
		if(data.fields.GetFieldObject(interactfrom).Steppable()){
//			if(!data.boxes.IsThere(interactfrom)){
				if(!data.collectables.IsThere(interactfrom)){
					return true;
//				}
			}
		}
		return false;
	}

	/**
	 * Dobozlerakás
	 * @param interactfrom Játékos helye a felvételkor.
	 * @param carriedobject Játékos kezében lévö doboz.
	 */
	public boolean Put(CVector interactfrom, Box carriedobject) {

		// A koordináta, melyre a játékos a dobozt tenni szeretné.
		CVector checkedPos = interactfrom.toNextCoord();

		// Csillagkapun keresztüli dobozletétel.
		if(data.stargates.IsThere(checkedPos)){
			checkedPos = data.stargates.StepIn(checkedPos);
		}

		// Rakható-e a kiszemelt koordinátájú pontra doboz?
		if(CanPut(checkedPos)){
			data.boxes.PutBox(checkedPos, carriedobject);

			System.out.print("has put an item at " + checkedPos.GetX() + "," + checkedPos.GetY() + " ");

			// Szakadékba dobás esetén a doboz semmisüljön meg.
			if(data.fields.GetFieldObject(checkedPos).IsMortal()){
				System.out.println("box destroyed ");
				data.boxes.Delete(checkedPos);
			}


			// Ajtónyitás kezelése
			data.buttons.EventOn(checkedPos,data.boxes.isThereV2(checkedPos));

			return true;
		} else {
			System.out.println("can't interact at " + checkedPos.GetX() + "," + checkedPos.GetY() + " ");
			return false;
		}
	}

}