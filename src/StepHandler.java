

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-mÃ¡rc.-2016 12:28:33
 */
public class StepHandler {

	private boolean pushed;
	private DataAccessPoint data;

	/**
	 * @author Mate
	 * @param data Ahonan eléri a többi adatot.
	 */
	public StepHandler(DataAccessPoint data) {
		this.data = data;
	}
	
	/**
	 * @author Mate
	 * @param where Ahova a játékos szeretne lépni
	 * @return Ráléphet-e az adott koordinátára
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
	 * @param playerpos A játékos pozíciója
	 * @param dir A lépés iránya
	 * @retun A player pozíciojánka és a lépés irányának megfelelõ CVectort, ahova szeretne lépni.
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
	 * @param playerpos A játékos pozíciója
	 * @param dir A lépés iránya
	 * @param canGenerateZPM kiválthat-e a lépéssel új ZPM létrejöttét
	 * @param ZPMs eddig felvett ZPM-ek száma
	 * @return A lépés utánai pozíció
	 */
	public CVector NextStep(CVector playerpos, Direction dir, boolean canGenerateZPM, int ZPMs){
		if(playerpos.GetDir() != dir){
			// Ha nem a lépés irányába néz a palyer, akkor arra fordul
			return new CVector(playerpos.GetX(), playerpos.GetY(), dir); 
		}
		
		CVector nextpos = NextPos(playerpos, dir);
		
		if (data.stargates.IsThere(nextpos)) {
			nextpos = data.stargates.StepIn(nextpos);
		}
		
		if (CanStep(nextpos))
		{
			// Gombról való lelépés figyelése
			data.buttons.EventOn(playerpos);
			if(data.fields.GetFieldObject(nextpos).IsMortal()){
				return null;
			}
			// ZPM felvétel figyelése
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