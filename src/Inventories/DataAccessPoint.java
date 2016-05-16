package Inventories;

import Players.Player;
import Players.Replicator;
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
    public Player Jaffa;
    public Player Colonel;
    public Replicator Repli;

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
    }

    /**
     * Megadja, hogy van-e j�t�kos a kijel�lt koordin�t�n
     *
     * @param coord K�rd�ses koordin�ta
     * @return van j�t�kos vagy nincs
     */
    public boolean isPlayerAtCoord(Coordinate coord) {
        return Colonel.getPos().toCoord().equals(coord) || (Jaffa != null && Jaffa.getPos().toCoord().equals(coord)) ||
                (Repli != null && Repli.getPos() != null && Repli.getPos().toCoord().equals(coord));
    }
}