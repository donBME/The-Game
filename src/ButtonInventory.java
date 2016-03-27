import java.util.ArrayList;
import java.util.List;

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:32
 */
public class ButtonInventory {

	private QuestionAssistant questionAssistant = new QuestionAssistant();
	private List<Button> buttons;

	public ButtonInventory(){
		System.out.println(">>ButtonInventory::ButtonInventory()");
        buttons = new ArrayList<>();
		System.out.println("<<ButtonInventory::ButtonInventory()");
	}
	
	public void addButton(Button newVal){
        System.out.println(">>ButtonInventory::addButton(Button newVal)");
		buttons.add(newVal);
		System.out.println("<<ButtonInventory::addButton(Button newVal)");
	}

	/**
	 *
	 * @param coord: koordináták
	 */
	public boolean EventOn(Coordinate coord){
        System.out.println(">>ButtonInventory::EventOn(Coordinate coord)");

		boolean thereis = questionAssistant.ask("Is there a button item? (y/n)");
		if(thereis == true)
		{

			buttons.get(0).Action();
			System.out.println("<<ButtonInventory::EventOn(Coordinate coord)");
			return true;
		}

        System.out.println("<<ButtonInventory::EventOn(Coordinate coord)");
		return false;
	}

}