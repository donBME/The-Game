import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-m�rc.-2016 12:28:32
 */
public class BoxInventory {

	QuestionAssistant questionAssistant = new QuestionAssistant();

	/**
	 * @author Mate
	 * @param coord: koordin�t�k
	 */
	public void Delete(Coordinate coord){
		System.out.println(">>BoxInventory::Delete(Coordinate coord)");
		System.out.println("<<BoxInventory::Delete(Coordinate coord)");
	}

	/**
	 * 
	 * @param coord: koordin�t�k
	 */
	public Box GetBox(Coordinate coord){
        System.out.println(">>BoxInventory::GetBox(Coordinate coord)");
        System.out.println("<<BoxInventory::GetBox(Coordinate coord)");
		return null;
	}

	/**
	 * @author Mate
	 * @param coord: koordin�t�k
	 */
	public boolean IsThere(Coordinate coord){
		System.out.println(">>BoxInventory::IsThere(Coordinate coord)");
        boolean isThere = questionAssistant.ask("Is there a box? (y/n)");
		System.out.println("<<BoxInventory::IsThere(Coordinate coord)");
		return isThere;
	}

	/**
	 * @author Mate
	 * @param coord: koordin�t�k
	 * @param carriedobject: doboz
	 */
	public void PutBox(Coordinate coord, Box carriedobject){
		System.out.println(">>BoxInventory::PutBox(Coordinate coord, Box carriedobject)");
		System.out.println("<<BoxInventory::PutBox(Coordinate coord, Box carriedobject)");
	}

}