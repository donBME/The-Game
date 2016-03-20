

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-m�rc.-2016 12:28:33
 */
public class StepHandler {

	private boolean pushed;
	private DataAccessPoint data;

	public StepHandler(){

	}

	public void finalize() throws Throwable {

	}

	public DataAccessPoint getdata(){
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
	public void setdata(DataAccessPoint newVal){
		data = newVal;
	}

}