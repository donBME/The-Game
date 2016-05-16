package Inventories;

import Players.Player;
import Players.Replicator;
import Tools.Coordinate;

/**
 * Központi adattároló egység
 */
public class DataAccessPoint {

    // Publikus inventory-k.
    public final BoxInventory boxes;
    public final ButtonInventory buttons;
    public final CollectibleInventory collectables;
    public final StarGateInventory stargates;
    public final FieldObjectInventory fields;
    public Player Jaffa;
    public Player Colonel;
    public Replicator Repli;

    /**
     * Értékadó konstruktor.
     *
     * @param starGates    Csillagkapu tároló
     * @param fields       Pályaelem tároló.
     * @param boxes        Doboz tároló
     * @param buttons      Nyomólap tároló
     * @param collectibles Gyűjthető elem tároló
     */
    public DataAccessPoint(StarGateInventory starGates, FieldObjectInventory fields,
                           BoxInventory boxes, ButtonInventory buttons, CollectibleInventory collectibles) {
        this.boxes = boxes;
        this.buttons = buttons;
        this.collectables = collectibles;
        this.stargates = starGates;
        this.fields = fields;
    }

    /**
     * Megadja, hogy van-e játékos a kijelölt koordinátán
     *
     * @param coordinate Kérdéses koordináta
     * @return van játékos vagy nincs
     */
    public boolean isPlayerAtCoordinate(Coordinate coordinate) {
        return Colonel.getPos().toCoordinate().equals(coordinate) ||
                (Jaffa != null && Jaffa.getPos().toCoordinate().equals(coordinate)) ||
                (Repli != null && Repli.getPos() != null && Repli.getPos().toCoordinate().equals(coordinate));
    }
}