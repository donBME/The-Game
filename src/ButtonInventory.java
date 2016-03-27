import java.util.List;

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:32
 */
public class ButtonInventory {

	private QuestionAssistant questionAssistant = new QuestionAssistant();
	Door m_door = new Door();
	Button m_button = new Button(m_door);


	/**
	 *
	 * @param coord: koordináták
	 */
	public boolean EventOn(Coordinate coord){
        System.out.println(">>ButtonInventory::EventOn(Coordinate coord)");

		boolean thereis = questionAssistant.ask("Is there a button item? (y/n)");
		if(thereis== true)
		{

			m_button.Action();
			System.out.println("<<ButtonInventory::EventOn(Coordinate coord)");
			return true;
		}

        System.out.println("<<ButtonInventory::EventOn(Coordinate coord)");
		return false;
	}

}