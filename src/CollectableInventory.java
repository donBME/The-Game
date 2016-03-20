

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-m�rc.-2016 12:28:32
 */
public class CollectableInventory {

	private Collectable m_Collectable;

	public CollectableInventory(){

	}

	public void finalize() throws Throwable {

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
	 * 
	 * @param coord: koordináták
	 */
	public boolean IsThere(Coordinate coord){
		return false;
	}

	/**
	 * 
	 * @param newVal: collectable
	 */
	public void setCollectable(Collectable newVal){
		m_Collectable = newVal;
	}

}