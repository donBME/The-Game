import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:32
 */
public class CollectableInventory {

	private Collectable m_Collectable;
	private QuestionAssistant questionAssistant = new QuestionAssistant();

	public CollectableInventory(){
		System.out.println("<<CollectableInventory::Create()");
	}
	
	public Collectable getCollectable(){
		return m_Collectable;
	}

	/**
	 * 
	 * @param coord: koordináták
	 */
	public Collectable GetCollectableAt(Coordinate coord){
		return null;
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
	public void setCollectable(Collectable newVal){
		m_Collectable = newVal;
		System.out.println("<<CollectableInventory::setCollectable(Collectable newVal)");
	}

}