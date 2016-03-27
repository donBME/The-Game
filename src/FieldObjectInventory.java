import java.util.ArrayList;
import java.util.List;

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:33
 */
public class FieldObjectInventory {

	private List<FieldObject> fieldObjects;

	public FieldObjectInventory(){
        System.out.println(">>FieldObjectInventory::Create()");
		fieldObjects = new ArrayList<>();
        System.out.println("<<FieldObjectInventory::Create()");
	}

	/**
	 * 
	 * @author Mate
	 * @param coord: koordináták
	 */
	public FieldObject GetFieldObject(Coordinate coord){
		System.out.println(">>FieldObjectInventory::GetFieldObject(Coordinate coord)");
		System.out.println("<<FieldObjectInventory::GetFieldObject(Coordinate coord)");
		return new FieldObjectSample();
	}

	/**
	 * 
	 * @param newVal
	 */
	public void addFieldObject(FieldObject newVal){
        System.out.println(">>FieldObjectInventory::addFieldObject(FieldObject newVal)");
		fieldObjects.add(newVal);
		System.out.println("<<FieldObjectInventory::addFieldObject(FieldObject newVal)");
	}

}