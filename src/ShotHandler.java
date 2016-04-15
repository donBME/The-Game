

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:33
 */
public class ShotHandler {

	private DataAccessPoint data;
    private QuestionAssistant questionAssistant = new QuestionAssistant();
	
	public ShotHandler(DataAccessPoint data) {
		System.out.println(">>ShotHandler::Create(DataAccessPoint data)");
		this.data = data;
		System.out.println("<<ShotHandler::Create(DataAccessPoint data)");
	}

	/**
	 * 
	 * @param shootfrom lövés iránya
	 * @param color szín
	 */
	public void Shoot(CVector shootfrom, StarGateColor color){
        System.out.println(">>ShotHandler::Shoot(CVector shootfrom, StarGateColor color)");
		data.stargates.Delete(null);
        FieldObject fieldObject;
        while ((fieldObject = data.fields.GetFieldObject(null)).Steppable() && !data.boxes.IsThere(null));
        if(fieldObject.Shootable())
            data.stargates.Create(null,null);
        System.out.println("<<ShotHandler::Shoot(CVector shootfrom, StarGateColor color)");
	}

}