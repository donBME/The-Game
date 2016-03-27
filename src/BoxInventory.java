import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:32
 */
public class BoxInventory {

	private Box m_Box;
	QuestionAssistant questionAssistant = new QuestionAssistant();

	/**
	 * @author Mate
	 * @param coord: koordináták
	 */
	public void Delete(Coordinate coord){
		System.out.println(">>BoxInventory::Delete(Coordinate coord)");
		System.out.println("<<BoxInventory::Delete(Coordinate coord)");
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
	 * @author Mate
	 * @param coord: koordináták
	 */
	public boolean IsThere(Coordinate coord){
		System.out.println(">>BoxInventory::IsThere(Coordinate coord)");
        boolean isThere = questionAssistant.ask("Is there a box? (y/n)");
		System.out.println("<<BoxInventory::IsThere(Coordinate coord)");
		return isThere;
	}

	/**
	 * @author Mate
	 * @param coord: koordináták
	 * @param carriedobject: doboz
	 */
	public void PutBox(Coordinate coord, Box carriedobject){
		System.out.println(">>BoxInventory::PutBox(Coordinate coord, Box carriedobject)");
		System.out.println("<<BoxInventory::PutBox(Coordinate coord, Box carriedobject)");
	}

	/**
	 * 
	 * @param newVal: doboz
	 */
	public void setBox(Box newVal){
		m_Box = newVal;
	}

}