import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:32
 */
public class CollectableInventory {

	private List<Collectable> collectables;
	private QuestionAssistant questionAssistant = new QuestionAssistant();

	public CollectableInventory(){
		System.out.println(">>CollectableInventory::CollectableInventory()");
        collectables = new ArrayList<>();
		System.out.println("<<CollectableInventory::CollectableInventory()");
	}

	/**
	 * 
	 * @param coord: koordináták
	 */
	public Collectable GetCollectableAt(Coordinate coord){
        System.out.println(">>CollectableInventory::GetCollectableAt(Coordinate coord)");
        System.out.println("<<CollectableInventory::GetCollectableAt(Coordinate coord)");
        return collectables.get(0);
	}

	/**
	 * @author Mate
	 * @param coord: koordináták
	 */
	public boolean IsThere(Coordinate coord){
		System.out.println(">>CollectableInventory::IsThere(Coordinate coord)");
        boolean thereis = questionAssistant.ask("Is there a collectable item? (y/n)");
		System.out.println("<<CollectableInventory::IsThere(Coordinate coord)");
		return thereis;
	}

	/**
	 * 
	 * @param newVal: collectable
	 */
	public void addCollectable(Collectable newVal){
        System.out.println(">>CollectableInventory::addCollectable(Collectable newVal)");
		collectables.add(newVal);
		System.out.println("<<CollectableInventory::addCollectable(Collectable newVal)");
	}

}