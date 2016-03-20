

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-m�rc.-2016 12:28:32
 */
public class BoxInventory {

	private Box m_Box;

	public BoxInventory(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param coord: koordináták
	 */
	public void Delete(Coordinate coord){

	}

	/**
	 * 
	 * @param coord: koordináták
	 */
	public Box GetBox(Coordinate coord){
		return null;
	}

	public Box getBox(){
		return m_Box;
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
	 * @param coord: koordináták
	 * @param carriedobject: doboz
	 */
	public void PutBox(Coordinate coord, Box carriedobject){

	}

	/**
	 * 
	 * @param newVal: doboz
	 */
	public void setBox(Box newVal){
		m_Box = newVal;
	}

}