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
 * @created 20-m�rc.-2016 12:28:32
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
	 * @param coord Koordin�t�k, ahonnan felvessz�k a Collactable-t
	 * @param count Az eddig �sszegy�jt�ttek sz�ma
	 */
	public void GetCollectableAt(Coordinate coord, int count){
		collectables.get(coord).Collect(count);
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
		// FIXME
		// Kell hozz� a p�lya m�rete, an�lk�l nem lehet meg�rni
		// A DataAccessPoint-ot ismernie kell, emrt csak Way-re lehet tenni ZPM-et
	}

}