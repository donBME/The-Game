import java.util.List;

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-m�rc.-2016 12:28:32
 */
public class ButtonInventory {

    private List<Button> buttons;

	/**
	 * 
	 * @param coord: koordin�t�k
	 */
	public boolean EventOn(Coordinate coord){
        System.out.println(">>ButtonInventory::EventOn(Coordinate coord)");
        System.out.println("<<ButtonInventory::EventOn(Coordinate coord)");
		return false;
	}

}