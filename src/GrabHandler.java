

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
		Coordinate checkedPos = interactfrom.toNextCoord();

        if(data.stargates.IsThere(interactfrom.toNextCoord())){
            checkedPos = data.stargates.StepIn(interactfrom.toNextCoord());
        }
        if(data.boxes.IsThere(checkedPos)){
            Box returnBox;

            returnBox =  data.boxes.GetBox(interactfrom.toNextCoord());

			if (returnBox != null){
				System.out.println("Box grabbed at: " + checkedPos.GetX() + "," + checkedPos.GetY());
			}

			// Gomb felengedés kezelése
			data.buttons.EventOn(checkedPos, data.boxes.isThereV2(checkedPos));

			return returnBox;
        }
        return null;
	}
	
	/**
	 * @author Mate
	 * @param interactfrom belépés iránya
	 */
	private boolean CanPut(CVector interactfrom){
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
	 * @author Mate
	 * @param interactfrom belépés iránya
	 * @param carriedobject doboz
	 */
	public boolean Put(CVector interactfrom, Box carriedobject){
		CVector checkedPos = interactfrom.toNextCoord();

		if(data.stargates.IsThere(checkedPos)){
			checkedPos = data.stargates.StepIn(checkedPos);
		}
		if(CanPut(checkedPos)){
			data.boxes.PutBox(checkedPos, carriedobject);

			if(data.fields.GetFieldObject(checkedPos).IsMortal()){
				data.boxes.Delete(checkedPos);
			}

			System.out.println("Box put to: " + checkedPos.GetX() + "," + checkedPos.GetY());

			// Ajtónyitás kezelése
			data.buttons.EventOn(checkedPos,data.boxes.isThereV2(checkedPos));

			return true;
		} else {
			return false;
		}
	}

}