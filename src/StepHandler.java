

/**
 * @author Laszlo
 * @version 1.0
 */
public class StepHandler {

	private boolean pushed;
	private boolean isCollected;
	private DataAccessPoint data;

	/**
	 * @param data Ahonan el?ri a t?bbi adatot.
	 */
	public StepHandler(DataAccessPoint data) {
		this.data = data;
		isCollected = false;
	}
	
	/**
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
	 * @param playerpos A j?t?kos poz?ci?ja
	 * @param dir A l?p?s ir?nya
	 * @param canGenerateZPM kiv?lthat-e a l?p?ssel ?j ZPM l?trej?tt?t
	 * @return A l?p?s ut?nai poz?ci?
	 */
	public CVector NextStep(CVector playerpos, Direction dir, boolean canGenerateZPM, int ZPMs, boolean canFillAbyss) {
		if(playerpos.GetDir() != dir){
			// Ha nem a l?p?s ir?ny?ba n?z a palyer, akkor arra fordul
			return new CVector(playerpos.GetX(), playerpos.GetY(), dir); 
		}
		
		CVector nextpos = playerpos.toNextCoord();
		
		if (data.stargates.IsThere(nextpos)) {
			nextpos = data.stargates.StepIn(nextpos);
		}
		
		if (CanStep(nextpos)) {
			// Gombr?l val? lel?p?s figyel?se
			data.buttons.EventOn(playerpos, 0);
			if(data.fields.GetFieldObject(nextpos).IsMortal()){

				if (canFillAbyss) {
					data.fields.addFieldObject(nextpos, new Way());
				}
				return null;
			}
			// ZPM felv?tel figyel?se
			if(data.collectables.IsThere(nextpos)){
				if(canGenerateZPM && (ZPMs + 1) % 2 == 0 ){
					data.collectables.addToRandomCoord();
				}
				data.collectables.GetCollectableAt(nextpos);
				isCollected = true;
			}
			data.buttons.EventOn(nextpos, 1);
			return nextpos;
		} else{
			return playerpos;
		}
	}

	/**
	 * ZPM felvétel ellenörzés
	 *
	 * @return Vett-e fel a járékos a körben ZOM modult
	 */
	public boolean isZPMcollected(){
		boolean returnVal = isCollected;
		isCollected = false;
		return returnVal;
	}

}