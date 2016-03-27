

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
	
	public DataAccessPoint(StarGateInventory stargates, FieldObjectInventory fields,
			BoxInventory boxes, ButtonInventory buttons, CollectableInventory collectables) {
		System.out.println(">>DataAccesspoint::Create(StarGateInventory stargates, FieldObjectInventory fields,BoxInventory boxes, ButtonInventory buttons, CollectableInventory collectables)");
		this.boxes = boxes;
		this.buttons = buttons;
		this.collectables = collectables;
		this.stargates = stargates;
		this.fields = fields;
		System.out.println("<<DataAccesspoint::Create(StarGateInventory stargates, FieldObjectInventory fields,BoxInventory boxes, ButtonInventory buttons, CollectableInventory collectables)");
	}
}