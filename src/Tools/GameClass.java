package Tools;

/**
 * @author Laszlo
 * @version 1.0
 */

import GameObjects.*;
import Handlers.GrabHandler;
import Handlers.ShotHandler;
import Handlers.StepHandler;
import Inventories.*;
import Players.Colonel;
import Players.Player;
import Players.Replicator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Template comment describing the goal of the method.
 * Test function for educational purposes to commence and teach the usage of bitbucket.
 *
 * Input:
 * args contains the supplied command-line arguments as an array of String objects.
 *
 * Output:
 * void type methods have no return value.
 */
public class GameClass {

    private FieldObjectInventory fieldObjectInventory;
    private StarGateInventory stargateInventory;
    private BoxInventory boxInventory;
    private ButtonInventory buttonInventory;
    private CollectableInventory collectableInventory;
    private DataAccessPoint dataAccesspoint;
    private ShotHandler shotHandler;
    private GrabHandler grabHandler;
    private StepHandler stepHandler;
    private Player player;
    private Replicator rep1;


    public static void main(String[] args) {
        // Anything which isn't evident at first glimpse, must be rigorously described in a comment beforehand.
        //System.out.println("Test method:" + System.lineSeparator() + "Starting one hell of a game from scratch!");
        GameClass menu = new GameClass();

        menu.Init();


        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = "";
        System.out.println("w: Elore\n" +
                "a: Balra\n" +
                "s: Hatra\n" +
                "d: Jobbra\n" +
                "f: Sarga portal\n" +
                "g: Kek portal\n" +
                "e: Doboz felvetel/learkas");

        while(!line.equals("q")){

            menu.drawMap();

            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            switch (line) {
                case "w":
                    menu.Step(Direction.North);
                    break;
                case "a":
                    menu.Step(Direction.West);
                    break;
                case "s":
                    menu.Step(Direction.South);
                    break;
                case "d":
                    menu.Step(Direction.East);
                    break;
                case "f":
                    menu.Shoot(StarGateColor.Yellow);
                    break;
                case "g":
                    menu.Shoot(StarGateColor.Blue);
                    break;
                case "e":
                    menu.Interact();
                    break;
                default:
                    break;
            }
        }

    }

    private void Init(){

        fieldObjectInventory = new FieldObjectInventory();
        stargateInventory = new StarGateInventory();
        boxInventory = new BoxInventory();
        buttonInventory = new ButtonInventory();
        collectableInventory = new CollectableInventory();

        dataAccesspoint = new DataAccessPoint(stargateInventory, fieldObjectInventory, boxInventory, buttonInventory, collectableInventory);

        collectableInventory.setData(dataAccesspoint);

        shotHandler = new ShotHandler(dataAccesspoint);
        grabHandler = new GrabHandler(dataAccesspoint);
        stepHandler = new StepHandler(dataAccesspoint,true);


        player = new Colonel(shotHandler, grabHandler, stepHandler, 1, 1);

        //itt adjuk hozza a replikatort: Albert
        ShotHandler rep1ShHandler= new ShotHandler(dataAccesspoint);
        GrabHandler rep1GHandler = new GrabHandler(dataAccesspoint);
        StepHandler rep1StHandler =new StepHandler(dataAccesspoint,false);
        rep1= new Replicator(rep1ShHandler,rep1GHandler,rep1StHandler,1,2);

        dataAccesspoint.players.add(player);
        dataAccesspoint.players.add(rep1);

        Thread rep1Thread = new Thread(rep1);
        rep1Thread.start();

//        fieldObjectInventory.addFieldObject(new Tools.Coordinate(0,0),new GameObjects.Way());
//        fieldObjectInventory.addFieldObject(new Tools.Coordinate(1,0),new GameObjects.Way());
//        fieldObjectInventory.addFieldObject(new Tools.Coordinate(2,0),new GameObjects.Way());
//        fieldObjectInventory.addFieldObject(new Tools.Coordinate(4,0),new GameObjects.Way());
//        GameObjects.Door door = new GameObjects.Door();
//        fieldObjectInventory.addFieldObject(new Tools.Coordinate(3,0),door);
//        buttonInventory.addButton(new Tools.Coordinate(1,0),new GameObjects.Button(door,1));
//        boxInventory.addBox(new Tools.Coordinate(2,0), new GameObjects.Box());
//        collectableInventory.addCollectable(new Tools.Coordinate(4,0),new GameObjects.ZPM());

//        fieldObjectInventory.addFieldObject(new Tools.Coordinate(0,0), new GameObjects.Way());
//        fieldObjectInventory.addFieldObject(new Tools.Coordinate(1,0), new GameObjects.Way());
//        fieldObjectInventory.addFieldObject(new Tools.Coordinate(2,0), new GameObjects.Way());
//
//        collectableInventory.addCollectable(new Tools.Coordinate(1,0), new GameObjects.ZPM());
//        collectableInventory.addCollectable(new Tools.Coordinate(2,0), new GameObjects.ZPM());


        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                if (x == 0 || x == 9 || y == 0 || y == 9) {
                    fieldObjectInventory.addFieldObject(new Coordinate(x, y), new SpecialWall());
                } else if (x == 7) {
                    fieldObjectInventory.addFieldObject(new Coordinate(x, y), new Wall());
                } else {
                    fieldObjectInventory.addFieldObject(new Coordinate(x, y), new Way());
                }
            }
        }
        collectableInventory.addCollectable(new Coordinate(5, 5), new ZPM());
        collectableInventory.addCollectable(new Coordinate(5, 6), new ZPM());
        boxInventory.addBox(new Coordinate(6, 2), new Box());
        boxInventory.addBox(new Coordinate(6, 1), new Box());
        Door door = new Door();
        fieldObjectInventory.addFieldObject(new Coordinate(7, 5), door);
        buttonInventory.addButton(new Coordinate(3, 1), new Button(door, 2));
        fieldObjectInventory.addFieldObject(new Coordinate(1, 3), new Abyss());

    }

    private void Interact(){
        player.Interact(player.getPos());
    }

    private void Step(Direction dir) {
//        player.Step(Tools.Direction.East);
//        player.Step(Tools.Direction.East);
//        player.Interact(player.getPos());
//        player.Step(Tools.Direction.East);
//        player.Step(Tools.Direction.West);
//        player.Interact(player.getPos());
//        player.Step(Tools.Direction.East);
//        player.Step(Tools.Direction.East);
//        player.Step(Tools.Direction.East);

        player.Step(dir);

    }

    private void Shoot(StarGateColor color) {
        player.Shoot(color);
    }

    private void drawMap() {
        for (int y = 9; y >= 0; y--) {
            for (int x = 0; x < 10; x++) {
                Coordinate thisCoord = new Coordinate(x, y);
                if (player.getPos() != null && player.getPos().toCoord().equals(thisCoord)) {
                    System.out.print((player.hasBox()) ? "|F " : "|E ");
                }
                else if(rep1.getPos()!= null && rep1.getPos().toCoord().equals(thisCoord))
                {
                    System.out.print("|R ");
                }
                else if (boxInventory.IsThere(thisCoord)) {
                    System.out.print("|B ");
                } else if (collectableInventory.IsThere(thisCoord)) {
                    System.out.print("|Z ");
                } else if (buttonInventory.isThere(thisCoord)) {
                    System.out.print("|_ ");
                } else if (stargateInventory.IsThere(new CVector(x, y, Direction.North))
                        || stargateInventory.IsThere(new CVector(x, y, Direction.East))
                        || stargateInventory.IsThere(new CVector(x, y, Direction.South))
                        || stargateInventory.IsThere(new CVector(x, y, Direction.West))) {
                    System.out.print("|O ");
                } else if (fieldObjectInventory.GetFieldObject(thisCoord).Steppable()
                        && !fieldObjectInventory.GetFieldObject(thisCoord).IsMortal()) {
                    System.out.print("|  ");
                } else if (fieldObjectInventory.GetFieldObject(thisCoord).IsMortal()) {
                    System.out.print("|A ");
                } else if (!fieldObjectInventory.GetFieldObject(thisCoord).Steppable()) {
                    System.out.print("|X ");
                }
            }
            System.out.println();
        }
    }

}
