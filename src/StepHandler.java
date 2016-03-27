

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:33
 */
public class StepHandler {

	private boolean pushed;
	private DataAccessPoint data;

	public DataAccessPoint getData(){
		return data;
	}

	private boolean CanStep(CVector interactfrom){
		if(data.fields.GetFieldObject(interactfrom).Steppable()){
			if(!data.boxes.IsThere(interactfrom)){
				return true;
			}
		}
		return false;
	}

	public CVector NextStep(CVector playerpos, Direction dir){
		System.out.println(">>StepHandler::NextStep(CVectro playerpos, Direction dir)");
		if (data.stargates.IsThere(playerpos)) {
			playerpos = data.stargates.StepIn(playerpos);
		}
		if (CanStep(playerpos))
		{
			data.buttons.EventOn(playerpos);// old pos
			if(data.fields.GetFieldObject(playerpos).IsMortal())
			{
				return null;
			}
			data.collectables.IsThere(playerpos);
			data.buttons.EventOn(playerpos);// new pos
			System.out.println("<<StepHandler::NextStep(CVectro playerpos, Direction dir)");
		}
		return null;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setData(DataAccessPoint newVal){
		data = newVal;
	}

}