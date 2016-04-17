import java.util.ArrayList;
import java.util.List;

/**
 * @author Laszlo
 * @version 1.0
 */
public class DataAccessPoint {

	public BoxInventory boxes;
	public ButtonInventory buttons;
	public CollectableInventory collectables;
	public StarGateInventory stargates;
	public FieldObjectInventory fields;
	public List<Player> players;
	
	public DataAccessPoint(StarGateInventory stargates, FieldObjectInventory fields,
			BoxInventory boxes, ButtonInventory buttons, CollectableInventory collectables) {
		this.boxes = boxes;
		this.buttons = buttons;
		this.collectables = collectables;
		this.stargates = stargates;
		this.fields = fields;
		players = new ArrayList<>();
	}

	/**
	 * Megadja, hogy van-e játékos a kijelölt koordinátán
	 *
	 * @param coord Kérdéses koordináta
	 * @return van játékos vagy nincs
	 */
	public boolean isPlayerAtCoord(Coordinate coord) {
		boolean isThere = false;

		for (Player player : players) {
			Coordinate playerPos = new Coordinate(player.getPos().GetX(), player.getPos().GetY());

			if (playerPos.equals(coord)) {
				isThere = true;
			}
		}

		return isThere;
	}
}