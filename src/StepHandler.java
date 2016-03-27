

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

	/**
	 * 
	 * @param playerpos: helyzet
	 * @param dir: irány
	 */
	public CVector NextStep(CVector playerpos, Direction dir){
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