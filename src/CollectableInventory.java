import java.util.Map;
import java.util.Random;

/**
 * @author Laszlo
 * @version 1.0
 */
public class CollectableInventory {

	private DataAccessPoint data;
	private Map<Coordinate, Collectable> collectables;

	public CollectableInventory(){
        collectables = new CustomHashMap();
	}

	/**
	 * A ZPM gener?l?shoz ismernie kell a fieldObjectek ?s box-ok hely?t.
	 * @param dataAccessPoint K?zponti adatt?rol?
	 */
	public void setData(DataAccessPoint dataAccessPoint){
		data = dataAccessPoint;
	}

	/**
	 * @param coord Koordin?t?k, ahonnan felvessz?k a Collactable-t
	 */
	public void GetCollectableAt(Coordinate coord){
		collectables.get(coord).Collect();
        collectables.remove(coord);
	}

	/**
	 * @param coord Ahol megn?zz?k, hogy van-e Collectable
	 */
	public boolean IsThere(Coordinate coord){
		if(collectables.get(coord)!= null){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param coord Ahova tessz?k
	 * @param newCollectable ?j collectable
	 */
	public void addCollectable(Coordinate coord, Collectable newCollectable){
		collectables.put(coord, newCollectable);
	}

	public void addToRandomCoord(){
		// Kell hozz? a p?lya m?rete, an?lk?l nem lehet meg?rni
		// A DataAccessPoint-ot ismernie kell, emrt csak Way-re lehet tenni ZPM-et

		Coordinate maxCoords = data.fields.getMaxCoords();
		int maxX = maxCoords.GetX();
		int maxY = maxCoords.GetY();
		int x,y;
		Random random = new Random();

		x = random.nextInt(maxX+1);
		y = random.nextInt(maxY+1);
		Coordinate coordinate = new Coordinate(x,y);

		while (!data.fields.GetFieldObject(coordinate).Steppable() || collectables.containsKey(coordinate) || data.isPlayerAtCoord(coordinate)) {
			x = random.nextInt(maxX+1);
			y = random.nextInt(maxY+1);
			coordinate.Set(x,y);
		}

		collectables.put(coordinate, new ZPM());

		System.out.println("ZPM generated at: " + x + "," + y);
	}
}