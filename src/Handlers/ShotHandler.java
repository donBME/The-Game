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

		boolean replikatorshot=false;//löttünk le az ut során replikátort Albert
		// Becsapódás helyének szimulálása
		while ((fieldObject = data.fields.GetFieldObject(checkedPos)).Steppable() && !data.boxes.IsThere(checkedPos) &&!replikatorshot)
		{

			//megnézi hogy az azon mezőn le tud e lőni replikátort és le is lövi Albert
			for(int i=0;i<data.players.size();i++)
			{
				if(data.players.get(i).getPos().GetX()==checkedPos.GetX() && data.players.get(i).getPos().GetY()==checkedPos.GetY() && data.players.get(i).Shotable())
				{
					data.players.get(i).kill();
					data.players.remove(i);
					replikatorshot=true;
					System.out.println("Replicator has been shot");
					break;
				}
			}
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