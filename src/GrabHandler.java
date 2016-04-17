

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:33
 */
public class GrabHandler {

	private DataAccessPoint data;

	public GrabHandler(DataAccessPoint data){
		this.data = data;
	}

	/**
	 * 
	 * @param interactfrom belépés iránya
	 */
	public Box Grab(CVector interactfrom){
		//TODO Csillagkapu kezelése
        //if(data.stargates.IsThere(interactfrom)){
        //    interactfrom = data.stargates.StepIn(interactfrom);
        //}
        if(data.boxes.IsThere(interactfrom.toNextCoord())){
            Box returnBox;

            returnBox =  data.boxes.GetBox(interactfrom.toNextCoord());

			// Gomb felengedés kezelése
			data.buttons.EventOn(interactfrom.toNextCoord(), data.boxes.isThereV2(interactfrom.toNextCoord()));

			return returnBox;
        }
        return null;
	}
	
	/**
	 * @author Mate
	 * @param interactfrom belépés iránya
	 */
	private boolean CanPut(CVector interactfrom){
		if(data.fields.GetFieldObject(interactfrom.toNextCoord()).Steppable()){
			if(!data.boxes.IsThere(interactfrom.toNextCoord())){
				if(!data.collectables.IsThere(interactfrom.toNextCoord())){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * @author Mate
	 * @param interactfrom belépés iránya
	 * @param carriedobject doboz
	 */
	public boolean Put(CVector interactfrom, Box carriedobject){
		//TODO Csillagkapu
		//if(data.stargates.IsThere(interactfrom)){
		//	interactfrom = data.stargates.StepIn(interactfrom);
		//}
		if(CanPut(interactfrom)){
			data.boxes.PutBox(interactfrom.toNextCoord(), carriedobject);

			if(data.fields.GetFieldObject(interactfrom.toNextCoord()).IsMortal()){
				data.boxes.Delete(interactfrom.toNextCoord());
			}

			// Ajtónyitás kezelése
			data.buttons.EventOn(interactfrom.toNextCoord(),data.boxes.isThereV2(interactfrom.toNextCoord()));

			return true;
		} else {
			return false;
		}
	}

}