package Handlers;

import Graphics.Notifiable;
import Inventories.*;
import Players.Player;
import Tools.Direction;
import Tools.LoadField;
import Tools.StarGateColor;

/**
 * A Model külső vezérlését lehetővé tevő osztály
 */
public class GameHandler {

    private final LoadField fieldLoader;
    private final Notifiable view;
    private DataAccessPoint dataAccesspoint;

    /**
     * GameHandler konstruktor.
     *
     * @param fLoader Pályabetöltő
     */
    public GameHandler(LoadField fLoader, Notifiable view) {
        fieldLoader = fLoader;
        this.view = view;
    }

    /**
     * Megadott sorszámú pálya futtatása
     *
     * @param testNum Pálya sorszáma
     */
    public void runMap(int testNum) {

        //init
        FieldObjectInventory fieldObjectInventory = new FieldObjectInventory();
        StarGateInventory stargateInventory = new StarGateInventory();
        BoxInventory boxInventory = new BoxInventory();
        ButtonInventory buttonInventory = new ButtonInventory();
        CollectibleInventory collectableInventory = new CollectibleInventory();

        dataAccesspoint = new DataAccessPoint(stargateInventory, fieldObjectInventory,
                boxInventory, buttonInventory, collectableInventory);
        collectableInventory.setData(dataAccesspoint);

        //mapbetöltés
        fieldLoader.Load("SingleLevel" + testNum + ".txt", dataAccesspoint);

        // View inicializálása
        view.setData(dataAccesspoint);

        // Feliratkozás a nézetekre
        dataAccesspoint.Colonel.subscribe(view);
        try {
            dataAccesspoint.Jaffa.subscribe(view);
        } catch (java.lang.NullPointerException ignored) {
        }

        try {
            dataAccesspoint.Repli.subscribe(view);
        } catch (java.lang.NullPointerException ignored) {
        }
    }

    /**
     * Parancs végrehajtása
     *
     * @param command Kapott parancs
     */
    public void executeCommand(String command) {
        String[] reinterpret = command.split(" ");
        Player currentPlayer = null;

        switch (reinterpret[0]) {
            case "Colonel":
                currentPlayer = dataAccesspoint.Colonel;
                break;
            case "Jaffa":
                currentPlayer = dataAccesspoint.Jaffa;
                break;
        }

        // Parancs továbbítása
        playerAction(currentPlayer, reinterpret);
    }

    /**
     * Lépés megadott játékossal
     *
     * @param p      Megadott játékos
     * @param dirstr Megadott irány
     */
    private void step(Player p, String dirstr) {
        Direction dir;
        switch (dirstr) {
            case "East":
                dir = Direction.valueOf("East");
                p.step(dir);
                break;
            case "North":
                dir = Direction.valueOf("North");
                p.step(dir);
                break;
            case "West":
                dir = Direction.valueOf("West");
                p.step(dir);
                break;
            case "South":
                dir = Direction.valueOf("South");
                p.step(dir);
                break;
            default:
                break;
        }
    }

    /**
     * Lövés megadott játékossal
     *
     * @param p             Játékos
     * @param colorstr      Csillagkapu színe
     * @param blueandyellow Színtartomány kiválasztása
     */
    private void shoot(Player p, String colorstr, boolean blueandyellow) {
        StarGateColor col;
        if (blueandyellow) {
            switch (colorstr) {
                case "Blue":
                    col = StarGateColor.valueOf("Blue");
                    p.shoot(col);
                    break;
                case "Yellow":
                    col = StarGateColor.valueOf("Yellow");
                    p.shoot(col);
                    break;
                default:
                    break;
            }
        } else {
            switch (colorstr) {
                case "Green":
                    col = StarGateColor.valueOf("Green");
                    p.shoot(col);
                    break;
                case "Red":
                    col = StarGateColor.valueOf("Red");
                    p.shoot(col);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Doboz felvétel és lerakás
     *
     * @param p        Játékos
     * @param commands Kapott parancs
     */
    private void playerAction(Player p, String[] commands) {
        if (p != null) {
            switch (commands[1]) {
                case "step":
                    step(p, commands[2]);
                    break;
                case "shoot":
                    shoot(p, commands[2], commands[0].equals("Colonel"));
                    break;
                case "interact":
                    p.interact(p.getPos());
                    break;
                default:
                    break;
            }
        }
    }
}
