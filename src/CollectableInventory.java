import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-m�rc.-2016 12:28:32
 */
public class CollectableInventory {

	private Map<Coordinate, Collectable> collectables;
	DataAccessPoint data;

	/**
	 * @author Mate
	 */
	public CollectableInventory(){
        collectables = new CustomHashMap();
	}

	/**
	 * A ZPM gener�l�shoz ismernie kell a fieldObjectek �s box-ok hely�t.
	 * @param dataAccessPoint K�zponti adatt�rol�
     */
	public void setData(DataAccessPoint dataAccessPoint){
		data = dataAccessPoint;
	}

	/**
	 * @author Mate
	 * @param coord Koordin�t�k, ahonnan felvessz�k a Collactable-t
	 */
	public void GetCollectableAt(Coordinate coord){
		collectables.get(coord).Collect();
        collectables.remove(coord);
	}

	/**
	 * @author Mate
	 * @param coord Ahol megn�zz�k, hogy van-e Collectable
	 */
	public boolean IsThere(Coordinate coord){
		if(collectables.get(coord)!= null){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author Mate
	 * @param coord Ahova tessz�k
	 * @param newCollectable �j collectable
	 */
	public void addCollectable(Coordinate coord, Collectable newCollectable){
		collectables.put(coord, newCollectable);
	}
	
	/**
	 * @author Mate
	 */
	public void addToRandomCoord(){
		// Kell hozz� a p�lya m�rete, an�lk�l nem lehet meg�rni
		// A DataAccessPoint-ot ismernie kell, emrt csak Way-re lehet tenni ZPM-et

		Coordinate maxCoords = data.fields.getMaxCoords();
		int maxX = maxCoords.GetX();
		int maxY = maxCoords.GetY();
		int x,y;
		Random random = new Random();

		x = random.nextInt(maxX+1);
		y = random.nextInt(maxY+1);
		Coordinate coordinate = new Coordinate(x,y);

		while (!data.fields.GetFieldObject(coordinate).Steppable() || collectables.containsKey(coordinate)){
			x = random.nextInt(maxX+1);
			y = random.nextInt(maxY+1);
			coordinate.Set(x,y);
		}

		collectables.put(coordinate, new ZPM());
	}
}