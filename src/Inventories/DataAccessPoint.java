package Inventories;

import Players.Player;
import Tools.Coordinate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Laszlo
 * @version 1.0
 */
public class DataAccessPoint {

	// Publikus inventory-k.
	public BoxInventory boxes;
	public ButtonInventory buttons;
	public CollectableInventory collectables;
	public StarGateInventory stargates;
	public FieldObjectInventory fields;
	public List<Player> players;
	public Player Jaffa;
	public Player Colonel;

	/**
	 * �rt�kad� konstruktor.
	 *
	 * @param stargates    Csillagkapu t�rol�
	 * @param fields       P�lyaelem t�rol�.
	 * @param boxes        Doboz t�rol�
	 * @param buttons      Nyom�lap t�rol�
	 * @param collectables Gy�jthet� elem t�rol�
	 */
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
	 * Megadja, hogy van-e j�t�kos a kijel�lt koordin�t�n
	 *
	 * @param coord K�rd�ses koordin�ta
	 * @return van j�t�kos vagy nincs
	 */
	public boolean isPlayerAtCoord(Coordinate coord) {
		boolean isThere = false;

		for (int i = 0; i < players.size(); i++) {
			Player player = players.get(i);
			try {
				Coordinate playerPos = new Coordinate(player.getPos().GetX(), player.getPos().GetY());

				if (playerPos.equals(coord)) {
					isThere = true;
				}
			} catch (NullPointerException e) {
				// Ha ilyen kivételt kapunk, halott a játékos
				players.remove(i);

				// Rekurzív hax
				return isPlayerAtCoord(coord);
			}
		}

		return isThere;
	}
}