

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-m�rc.-2016 12:28:32
 */
public class ButtonInventory {

	private Button m_Button;

	public ButtonInventory(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param coord: koordin�t�k
	 */
	public boolean EventOn(Coordinate coord){
		return false;
	}

	public Button getButton(){
		return m_Button;
	}

	/**
	 * 
	 * @param newVal: gomb
	 */
	public void setButton(Button newVal){
		m_Button = newVal;
	}

}