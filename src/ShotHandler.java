

/**
 * @author Laszlo
 * @version 1.0
 */
public class ShotHandler {

	private DataAccessPoint data;
	
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