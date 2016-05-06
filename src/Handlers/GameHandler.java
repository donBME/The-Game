package Handlers;

import Inventories.*;
import Players.Player;
import Tools.*;

public class GameHandler {

    private LoadField fieldLoader;

    /**
     * GameHandler konstruktor.
     *
     * @param fLoader Pályabetöltő
     */
    public GameHandler(LoadField fLoader) {
        fieldLoader = fLoader;
    }

    public void runMap(int testNum) {

        //init
        FieldObjectInventory fieldObjectInventory = new FieldObjectInventory();
        StarGateInventory stargateInventory = new StarGateInventory();
        BoxInventory boxInventory = new BoxInventory();
        ButtonInventory buttonInventory = new ButtonInventory();
        CollectableInventory collectableInventory = new CollectableInventory();

        DataAccessPoint dataAccesspoint = new DataAccessPoint(stargateInventory, fieldObjectInventory, boxInventory, buttonInventory, collectableInventory);
        collectableInventory.setData(dataAccesspoint);

        //mapbetöltés
        fieldLoader.Load("testmap" + testNum + ".txt", dataAccesspoint);
    }

    public void executeCommand(String command){
        System.out.println(command);
    }

    //megadott játékossal lép
    private void step(Player p, String dirstr) {
        Direction dir;
        switch (dirstr) {
            case "East":
                dir = Direction.valueOf("East");
                p.Step(dir);
                break;
            case "North":
                dir = Direction.valueOf("North");
                p.Step(dir);
                break;
            case "West":
                dir = Direction.valueOf("West");
                p.Step(dir);
                break;
            case "South":
                dir = Direction.valueOf("South");
                p.Step(dir);
                break;
            default:
                break;
        }
    }

    private void shoot(Player p, String colorstr, boolean blueandyellow) {
        StarGateColor col;
        if (blueandyellow) {
            switch (colorstr) {
                case "Blue":
                    col = StarGateColor.valueOf("Blue");
                    p.Shoot(col);
                    break;
                case "Yellow":
                    col = StarGateColor.valueOf("Yellow");
                    p.Shoot(col);
                    break;
                default:
                    break;
            }
        } else {
            switch (colorstr) {
                case "Green":
                    col = StarGateColor.valueOf("Green");
                    p.Shoot(col);
                    break;
                case "Red":
                    col = StarGateColor.valueOf("Red");
                    p.Shoot(col);
                    break;
                default:
                    break;
            }
        }
    }

    private void playerAction(Player p, String[] commands) {
        switch (commands[1]) {
            case "Step":
                step(p, commands[2]);
                break;
            case "Shoot":
                shoot(p, commands[2], commands[0].equals("Colonel"));
                break;
            case "Interact":
                p.Interact(p.getPos());
                break;
            default:
                break;
        }
    }


}
