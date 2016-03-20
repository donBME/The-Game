

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
	 * 
	 * @param interactfrom: belépés iránya
	 * @param carriedobject: doboz
	 */
	public boolean Put(CVector interactfrom, Box carriedobject){
		return false;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setdata(DataAccessPoint newVal){
		data = newVal;
	}

}