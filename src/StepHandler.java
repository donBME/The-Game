

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:33
 */
public class StepHandler {

	private boolean pushed;
	private DataAccessPoint data;

	/**
	 * @author Mate
	 * @param data Ahonan el?ri a t?bbi adatot.
	 */
	public StepHandler(DataAccessPoint data) {
		this.data = data;
	}
	
	/**
	 * @author Mate
	 * @param where Ahova a j?t?kos szeretne l?pni
	 * @return R?l?phet-e az adott koordin?t?ra
	 */
	private boolean CanStep(CVector where){
		FieldObject fieldObject = data.fields.GetFieldObject(where);
		if(fieldObject != null && fieldObject.Steppable()){
			if(!data.boxes.IsThere(where)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @author Mate
	 * @param playerpos A j?t?kos poz?ci?ja
	 * @param dir A l?p?s ir?nya
	 * @retun A player poz?cioj?nka ?s a l?p?s ir?ny?nak megfelel? CVectort, ahova szeretne l?pni.
	 */
	private CVector NextPos(CVector playerpos, Direction dir){
		switch (dir) {
		case North:
			return new CVector(playerpos.GetX(), playerpos.GetY()+1, dir);
		case South:
			return new CVector(playerpos.GetX(), playerpos.GetY()-1, dir);
		case East:
			return new CVector(playerpos.GetX()+1, playerpos.GetY(), dir);
		case West:
			return new CVector(playerpos.GetX()-1, playerpos.GetY(), dir);
		default:
			return playerpos;
		}
	}
	
	/**
	 * @author Mate
	 * @param playerpos A j?t?kos poz?ci?ja
	 * @param dir A l?p?s ir?nya
	 * @param canGenerateZPM kiv?lthat-e a l?p?ssel ?j ZPM l?trej?tt?t
	 * @param ZPMs eddig felvett ZPM-ek sz?ma
	 * @return A l?p?s ut?nai poz?ci?
	 */
	public CVector NextStep(CVector playerpos, Direction dir, boolean canGenerateZPM, int ZPMs){
		if(playerpos.GetDir() != dir){
			// Ha nem a l?p?s ir?ny?ba n?z a palyer, akkor arra fordul
			return new CVector(playerpos.GetX(), playerpos.GetY(), dir); 
		}
		
		CVector nextpos = NextPos(playerpos, dir);
		
		if (data.stargates.IsThere(nextpos)) {
			nextpos = data.stargates.StepIn(nextpos);
		}
		
		if (CanStep(nextpos)) {
			// Gombr?l val? lel?p?s figyel?se
			data.buttons.EventOn(playerpos);
			if(data.fields.GetFieldObject(nextpos).IsMortal()){
				return null;
			}
			// ZPM felv?tel figyel?se
			if(data.collectables.IsThere(nextpos)){
				if(canGenerateZPM && (ZPMs + 1) % 2 == 0 ){
					data.collectables.addToRandomCoord();
				}
				data.collectables.GetCollectableAt(nextpos, ZPMs);
			}
			data.buttons.EventOn(nextpos);
			return nextpos;
		} else{
			return playerpos;
		}
	}

}