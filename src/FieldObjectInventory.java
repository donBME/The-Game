import java.util.HashMap;
import java.util.Map;

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-m�rc.-2016 12:28:33
 */
public class FieldObjectInventory {

	private Map<Coordinate, FieldObject> fieldObjects;
	
	/**
	 * @author Mate
	 */
	public FieldObjectInventory(){
		fieldObjects = new HashMap<>();
	}

	/**
	 * 
	 * @author Mate
	 * @param coord ahonnan la a karjuk k�rni, hogy ott van-e FeildObject
	 * @return A koordin�t�n tal�lhat� FieldObject
	 */
	public FieldObject GetFieldObject(Coordinate coord){
		return fieldObjects.get(coord);
	}

	/**
	 * @author Mate
	 * @param newFeildObject �j FieldObject
	 */
	public void addFieldObject(Coordinate coord, FieldObject newFeildObject){
        fieldObjects.put(coord, newFeildObject);
	}

}