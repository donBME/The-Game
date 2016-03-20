

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:33
 */
public class DataAccessPoint {

	private BoxInventory boxes;
	private ButtonInventory buttons;
	private CollectableInventory collectables;
	private StarGateInventory stargates;
	private FieldObjectInventory fields;

	public DataAccessPoint(){

	}

	public void finalize() throws Throwable {

	}

	public BoxInventory getboxes(){
		return boxes;
	}

	public ButtonInventory getbuttons(){
		return buttons;
	}

	public CollectableInventory getcollectables(){
		return collectables;
	}

	public FieldObjectInventory getfields(){
		return fields;
	}

	public StarGateInventory getstargates(){
		return stargates;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setboxes(BoxInventory newVal){
		boxes = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setbuttons(ButtonInventory newVal){
		buttons = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setcollectables(CollectableInventory newVal){
		collectables = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setfields(FieldObjectInventory newVal){
		fields = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setstargates(StarGateInventory newVal){
		stargates = newVal;
	}

}