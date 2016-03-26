

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-m�rc.-2016 12:28:33
 */
public class GrabHandler {

	private DataAccessPoint data;

	public GrabHandler(){

	}

	public void finalize() throws Throwable {

	}

	public DataAccessPoint getdata(){
		return data;
	}

	/**
	 * 
	 * @param interactfrom: belépés iránya
	 */
	public Box Grab(CVector interactfrom){
		return null;
	}
	
	/**
	 * @author Mate
	 * @param interactfrom: bel�p�s ir�nya
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
	 * @param interactfrom: bel�p�s ir�nya
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

	/**
	 * 
	 * @param newVal
	 */
	public void setdata(DataAccessPoint newVal){
		data = newVal;
	}

}