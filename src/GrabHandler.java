

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:33
 */
public class GrabHandler {

	private DataAccessPoint data;

	public GrabHandler(DataAccessPoint data){
		System.out.println(">>GrabHandler::Create(DataAccessPoint data)");
		this.data = data;
		System.out.println("<<GrabHandler::Create(DataAccessPoint data)");
	}

	/**
	 * 
	 * @param interactfrom: belépés iránya
	 */
	public Box Grab(CVector interactfrom){
        System.out.println(">>GrabHandler::Grab(CVector interactfrom)");
        if(data.stargates.IsThere(interactfrom)){
            interactfrom = data.stargates.StepIn(interactfrom);
        }
        if(data.boxes.IsThere(interactfrom)){
            data.buttons.EventOn(interactfrom);
            System.out.println("<<GrabHandler::Grab(CVector interactfrom)");
            return data.boxes.GetBox(interactfrom);
        }
        System.out.println("<<GrabHandler::Grab(CVector interactfrom)");
        return null;
	}
	
	/**
	 * @author Mate
	 * @param interactfrom: belépés iránya
	 */
	private boolean CanPut(CVector interactfrom){
		if(data.fields.GetFieldObject(interactfrom).Steppable()){
			if(!data.boxes.IsThere(interactfrom)){
				if(!data.collectables.IsThere(interactfrom)){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * @author Mate
	 * @param interactfrom: belépés iránya
	 * @param carriedobject: doboz
	 */
	public boolean Put(CVector interactfrom, Box carriedobject){
		System.out.println(">>GrabHandler::Put(CVectro interactfrom, Box carrieobject)");
		if(data.stargates.IsThere(interactfrom)){
			interactfrom = data.stargates.StepIn(interactfrom);
		}
		if(CanPut(interactfrom)){
			data.boxes.PutBox(interactfrom, carriedobject);
			if(!data.buttons.EventOn(interactfrom)){
				if(data.fields.GetFieldObject(interactfrom).IsMortal()){
					data.boxes.Delete(interactfrom);
				}
			}
			System.out.println("<<GrabHandler::Put(CVectro interactfrom, Box carrieobject)");
			return true;
		} else {
			System.out.println("<<GrabHandler::Put(CVectro interactfrom, Box carrieobject)");
			return false;
		}
	}

}