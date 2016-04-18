package Inventories;

import GameObjects.FieldObject;
import Tools.Coordinate;
import Tools.CustomHashMap;

import java.util.Map;

/**
 * @author Laszlo
 * @version 1.0
 */
public class FieldObjectInventory {

	private Map<Coordinate, FieldObject> fieldObjects;
	
	/**
	 * Konstruktor
	 */
	public FieldObjectInventory(){
		fieldObjects = new CustomHashMap();
	}

	/**
	 *
	 * @param coord ahonnan la a karjuk kérni, hogy ott van-e FeildObject
	 * @return A koordinátán található GameObjects.FieldObject
	 */
	public FieldObject GetFieldObject(Coordinate coord){
		return fieldObjects.get(coord);
	}

	/**
	 * @param newFieldObject új GameObjects.FieldObject
	 */
	public void addFieldObject(Coordinate coord, FieldObject newFieldObject){
        fieldObjects.put(coord, newFieldObject);
	}

	/**
	 * Pálya maximális méretét megadó függvény
	 * @return Pálya max mérete
	 */
	Coordinate getMaxCoords() {
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