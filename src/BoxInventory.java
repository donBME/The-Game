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
public class BoxInventory {

	QuestionAssistant questionAssistant = new QuestionAssistant();
	private List<Box> boxList;

	public BoxInventory(){
		System.out.println(">>BoxInventory::BoxInventory()");
        boxList = new ArrayList<>();
		System.out.println("<<BoxInventory::BoxInventory()");
	}
	
	/**
	 * @author Mate
	 * @param coord koordináták
	 */
	public void Delete(Coordinate coord){
		System.out.println(">>BoxInventory::Delete(Coordinate coord)");
		System.out.println("<<BoxInventory::Delete(Coordinate coord)");
	}

	/**
	 * 
	 * @param coord koordináták
	 */
	public Box GetBox(Coordinate coord){
        System.out.println(">>BoxInventory::GetBox(Coordinate coord)");
        System.out.println("<<BoxInventory::GetBox(Coordinate coord)");
		return null;
	}
	
	public void addBox(Box newVal){
        System.out.println(">>BoxInventory::addBox(Box newVal)");
		boxList.add(newVal);
		System.out.println("<<BoxInventory::addBox(Box newVal)");
	}

	/**
	 * @author Mate
	 * @param coord koordináták
	 */
	public boolean IsThere(Coordinate coord){
		System.out.println(">>BoxInventory::IsThere(Coordinate coord)");
        boolean isThere = questionAssistant.ask("Is there a box? (y/n)");
		System.out.println("<<BoxInventory::IsThere(Coordinate coord)");
		return isThere;
	}

	/**
	 * @author Mate
	 * @param coord koordináták
	 * @param carriedobject doboz
	 */
	public void PutBox(Coordinate coord, Box carriedobject){
		System.out.println(">>BoxInventory::PutBox(Coordinate coord, Box carriedobject)");
		System.out.println("<<BoxInventory::PutBox(Coordinate coord, Box carriedobject)");
	}

}