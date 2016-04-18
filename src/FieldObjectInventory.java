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
		fieldObjects = new CustomHashMap();
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
	 * @param newFieldObject �j FieldObject
	 */
	public void addFieldObject(Coordinate coord, FieldObject newFieldObject){
        fieldObjects.put(coord, newFieldObject);
	}

	/**
	 * P�lya maxim�lis m�ret�t megad� f�ggv�ny
	 * @return P�lya max m�rete
     */
	public Coordinate getMaxCoords(){
		int tmpMaxX = 0, tmpMaxY = 0;

		// Megkeresi a p�lya lehet� legsz�ls� pontj�t.
		for (Coordinate key : fieldObjects.keySet()){
			if (key.GetX() > tmpMaxX){
				tmpMaxX = key.GetX();
			}
			if (key.GetY() > tmpMaxY){
				tmpMaxY = key.GetY();
			}
		}

		return new Coordinate(tmpMaxX,tmpMaxY);

	}

}