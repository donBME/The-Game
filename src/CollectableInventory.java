import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:32
 */
public class CollectableInventory {

	private Map<Coordinate, Collectable> collectables;

	/**
	 * @author Mate
	 */
	public CollectableInventory(){
        collectables = new HashMap<>();
	}

	/**
	 * @author Mate
	 * @param coord Koordináták, ahonnan felvesszük a Collactable-t
	 * @param count Az eddig összegyûjtöttek száma
	 */
	public void GetCollectableAt(Coordinate coord, int count){
		collectables.get(coord).Collect(count);
        collectables.remove(coord);
	}

	/**
	 * @author Mate
	 * @param coord Ahol megnézzük, hogy van-e Collectable
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
	 * @param coord Ahova tesszük
	 * @param newCollectable új collectable
	 */
	public void addCollectable(Coordinate coord, Collectable newCollectable){
		collectables.put(coord, newCollectable);
	}
	
	/**
	 * @author Mate
	 */
	public void addToRandomCoord(){
		// FIXME
		// Kell hozzá a pálya mérete, anélkül nem lehet megírni
		// A DataAccessPoint-ot ismernie kell, emrt csak Way-re lehet tenni ZPM-et
	}

}