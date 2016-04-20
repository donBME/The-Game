package Handlers;

import GameObjects.FieldObject;
import GameObjects.Way;
import Inventories.DataAccessPoint;
import Tools.CVector;
import Tools.Direction;

/**
 * @author Laszlo
 * @version 1.0
 */
public class StepHandler {

	// Belső változók
	private boolean pushed;
	private boolean isCollected;
	private DataAccessPoint data;
	private boolean canCollect;//a replikátor nem vehet fel zpm-t Albert

	/**
	 * Konstrukor
	 * @param data Ahonan el?ri a t?bbi adatot.
	 */
	public StepHandler(DataAccessPoint data, boolean canCollect) {
		this.data = data;
		this.canCollect=canCollect;//a replikátor nem vehet fel zpm-t Albert
		isCollected = false;
	}

	
	/**
	 * Lépés ellenőrző fgv.
	 * @param where Ahova a j?t?kos szeretne l?pni
	 * @return R?l?phet-e az adott koordin?t?ra
	 */
	private boolean CanStep(CVector where){
		FieldObject fieldObject = data.fields.GetFieldObject(where);
		if(fieldObject != null && fieldObject.Steppable() && !data.isPlayerAtCoord(where.toCoord())){
			if(!data.boxes.IsThere(where)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @param playerpos A j?t?kos poz?ci?ja
	 * @param dir A l?p?s ir?nya
	 * @param canGenerateZPM kiv?lthat-e a l?p?ssel ?j GameObjects.ZPM l?trej?tt?t
	 * @return A l?p?s ut?nai poz?ci?
	 */
	public synchronized CVector NextStep(CVector playerpos, Direction dir, boolean canGenerateZPM, int ZPMs, boolean canFillAbyss) {
		if(playerpos.GetDir() != dir){

			// Ha nem a l?p?s ir?ny?ba n?z a palyer, akkor arra fordul
			System.out.print("new position: " + playerpos.GetX() + "," + playerpos.GetY() + " ");
			return new CVector(playerpos.GetX(), playerpos.GetY(), dir); 
		}
		
		CVector nextpos = playerpos.toNextCoord();
		
		if (data.stargates.IsThere(nextpos)) {
			nextpos = data.stargates.StepIn(nextpos);
		}

		if (CanStep(nextpos)) {

			System.out.print("new position: " + nextpos.GetX() + "," + nextpos.GetY() + " ");

			// Gombr?l val? lel?p?s figyel?se
			data.buttons.EventOn(playerpos, 0);
			if(data.fields.GetFieldObject(nextpos).IsMortal()){

				System.out.print("Game Over ");

				if (canFillAbyss) {
					data.fields.addFieldObject(nextpos.toCoord(), new Way());
					System.out.print("way spawned ");
				}
				return null;
			}
			// GameObjects.ZPM felv?tel figyel?se
			if(data.collectables.IsThere(nextpos) && canCollect){

				data.collectables.GetCollectableAt(nextpos);
				isCollected = true;

				if(canGenerateZPM && (ZPMs + 1) % 2 == 0 ){
					data.collectables.addToRandomCoord();
				}
			}
			data.buttons.EventOn(nextpos, 1);
			return nextpos;
		} else{
			System.out.print("new position: " + playerpos.GetX() + "," + playerpos.GetY() + " ");
			return playerpos;
		}
	}

	/**
	 * GameObjects.ZPM felvétel ellenörzés
	 *
	 * @return Vett-e fel a járékos a körben GameObjects.ZPM modult
	 */
	public boolean isZPMcollected(){
		boolean returnVal = isCollected;
		isCollected = false;
		return returnVal;
	}

}