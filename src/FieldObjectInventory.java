

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-m�rc.-2016 12:28:33
 */
public class FieldObjectInventory {

	private FieldObject m_FieldObject;

	public FieldObjectInventory(){

	}

	/**
	 * 
	 * @author Mate
	 * @param coord: koordin�t�k
	 */
	public FieldObject GetFieldObject(Coordinate coord){
		System.out.println(">>FieldObjectInventory::GetFieldObject(Coordinate coord)");
		System.out.println("<<FieldObjectInventory::GetFieldObject(Coordinate coord)");
		return new FieldObjectSample();
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