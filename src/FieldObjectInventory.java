import java.util.Map;

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:33
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
	 * @param coord ahonnan la a karjuk kérni, hogy ott van-e FeildObject
	 * @return A koordinátán található FieldObject
	 */
	public FieldObject GetFieldObject(Coordinate coord){
		return fieldObjects.get(coord);
	}

	/**
	 * @author Mate
	 * @param newFieldObject új FieldObject
	 */
	public void addFieldObject(Coordinate coord, FieldObject newFieldObject){
        fieldObjects.put(coord, newFieldObject);
	}

	/**
	 * Pálya maximális méretét megadó függvény
	 * @return Pálya max mérete
     */
	public Coordinate getMaxCoords(){
		int tmpMaxX = 0, tmpMaxY = 0;

		// Megkeresi a pálya lehetö legszélsö pontját.
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