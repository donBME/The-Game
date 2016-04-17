

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:33
 */
public class ShotHandler {

	private DataAccessPoint data;
    private QuestionAssistant questionAssistant = new QuestionAssistant();
	
	public ShotHandler(DataAccessPoint data) {
		this.data = data;
	}

	/**
	 * 
	 * @param shootfrom lövés iránya
	 * @param color szín
	 */
	public void Shoot(CVector shootfrom, StarGateColor color){
        FieldObject fieldObject;
		CVector checkedPos = shootfrom.toNextCoord();

        while ((fieldObject = data.fields.GetFieldObject(checkedPos)).Steppable() && !data.boxes.IsThere(checkedPos)) {
			checkedPos = checkedPos.toNextCoord();
		}

        if(fieldObject.Shootable()) {
			data.stargates.Create(checkedPos,color);
			System.out.println("created " + color.toString() + " stargate at " + checkedPos.GetX() + "," + checkedPos.GetY());
		}
	}

}