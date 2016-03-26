

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:33
 */
public class DataAccessPoint {

	public BoxInventory boxes;
	public ButtonInventory buttons;
	public CollectableInventory collectables;
	public StarGateInventory stargates;
	public FieldObjectInventory fields;

	public DataAccessPoint(){

	}

	public void finalize() throws Throwable {

	}

}