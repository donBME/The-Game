

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-m�rc.-2016 12:28:33
 */
public class FieldObjectInventory {

	private FieldObject m_FieldObject;

	public FieldObjectInventory(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param coord: koordináták
	 */
	public FieldObject GetFieldObject(Coordinate coord){
		return null;
	}

	public FieldObject getFieldObject(){
		return m_FieldObject;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFieldObject(FieldObject newVal){
		m_FieldObject = newVal;
	}

}