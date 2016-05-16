package Inventories;

import GameObjects.FieldObject;
import Tools.Coordinate;
import Tools.CustomHashMap;

import java.util.Map;

/**
 * Fieldobject tároló osztály
 */
@SuppressWarnings("unchecked")
public class FieldObjectInventory {

    private final Map<Coordinate, FieldObject> fieldObjects;

    /**
     * Konstruktor
     */
    public FieldObjectInventory() {
        fieldObjects = new CustomHashMap();
    }

    /**
     * @param coordinate ahonnan la a karjuk kérni, hogy ott van-e FieldObject
     * @return A koordinátán található GameObjects.FieldObject
     */
    public FieldObject GetFieldObject(Coordinate coordinate) {
        return fieldObjects.get(coordinate);
    }

    /**
     * Új FieldObject hozzáadása
     *
     * @param coordinate     Hozzáadni kivánt fieldobject koordinátái
     * @param newFieldObject fieldobject referencia
     */
    public void addFieldObject(Coordinate coordinate, FieldObject newFieldObject) {
        fieldObjects.remove(coordinate);
        fieldObjects.put(coordinate, newFieldObject);
    }

    /**
     * Pálya maximális méretét megadó függvény
     *
     * @return Pálya max mérete
     */
    public Coordinate getMaxCoordinates() {
        int tmpMaxX = 0, tmpMaxY = 0;

        // Megkeresi a pálya lehető legszélső pontját.
        for (Coordinate key : fieldObjects.keySet()) {
            if (key.GetX() > tmpMaxX) {
                tmpMaxX = key.GetX();
            }
            if (key.GetY() > tmpMaxY) {
                tmpMaxY = key.GetY();
            }
        }

        return new Coordinate(tmpMaxX, tmpMaxY);

    }

}