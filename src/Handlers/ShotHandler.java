package Handlers;

import GameObjects.FieldObject;
import Inventories.DataAccessPoint;
import Tools.CVector;
import Tools.StarGateColor;

/**
 * @author Laszlo
 * @version 1.0
 */
public class ShotHandler {

	// Adattároló
	private DataAccessPoint data;

	/**
	 * Konstruktor
	 *
	 * @param data Adattároló
	 */
	public ShotHandler(DataAccessPoint data) {
		this.data = data;
	}

	/**
	 * Csillagkapu lövés
	 * @param shootfrom lövés iránya
	 * @param color szín
	 */
	public void Shoot(CVector shootfrom, StarGateColor color){
        FieldObject fieldObject;
		CVector checkedPos = shootfrom.toNextCoord();

		// Becsapódás helyének szimulálása
		while ((fieldObject = data.fields.GetFieldObject(checkedPos)).Steppable() && !data.boxes.IsThere(checkedPos)) {
			checkedPos = checkedPos.toNextCoord();
		}

		// Lőhető-e a kiszámolt helyre csillagkapu.
		if(fieldObject.Shootable()) {
			data.stargates.Create(checkedPos,color);
			System.out.print(color.toString() + " portal at ");
		} else {
			System.out.print("failed to create portal at ");
		}
		System.out.print(checkedPos.GetX() + "," + checkedPos.GetY());
	}

}