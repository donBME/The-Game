
/*
 * Created by Laszlo on 2016. 02. 18..
 */

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
    private Wall wall;
    private SpecialWall specialWall;
    private Abyss abyss;
    private Way way;
    private Door door;
    private Box box;
    private StarGateInventory stargateInventory;
    private BoxInventory boxInventory;
    private Button button;
    private ButtonInventory buttonInventory;
    private ZPM zpm;
    private CollectableInventory collectableInventory;
    private DataAccessPoint dataAccesspoint;
    private ShotHandler shotHandler;
    private GrabHandler grabHandler;
    private StepHandler stepHandler;
    private Player player;


    public static void main(String[] args) {
        // Anything which isn't evident at first glimpse, must be rigorously described in a comment beforehand.
        //System.out.println("Test method:" + System.lineSeparator() + "Starting one hell of a game from scratch!");
        GameClass menu = new GameClass();

        menu.Init();


        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = new String();
        System.out.println("1: Init\n" +
                "2: Box put/grab\n" +
                "3: Shoot\n" +
                "4: Step\n" +
                "q: Quit");

        while(!line.equals("q")){
            System.out.println("Waitin' for command!");
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            switch (line) {
                case "1":
                    menu.Init();
                    break;
                case "2":
                    menu.Interact();
                    break;
                case "3":
                    menu.Shoot();
                    break;
                case "4":
                    menu.Step();
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

        shotHandler = new ShotHandler(dataAccesspoint);
        grabHandler = new GrabHandler(dataAccesspoint);
        stepHandler = new StepHandler(dataAccesspoint);

        player = new Player(shotHandler, grabHandler, stepHandler,true, 0, 0);

        fieldObjectInventory.addFieldObject(new Coordinate(0,0),new Way());
        fieldObjectInventory.addFieldObject(new Coordinate(1,0),new Way());
        boxInventory.addBox(new Coordinate(1,0),new Box());
        fieldObjectInventory.addFieldObject(new Coordinate(2,0),new Wall());

    }

    private void Interact(){
        player.Interact(player.getPos());
    }

    private void Step(){
        player.Step(Direction.East);
        player.Interact(player.getPos());
        player.Step(Direction.East);
        player.Step(Direction.West);
        player.Interact(player.getPos());
        player.Step(Direction.West);

    }

    private void Shoot(){
        player.Shoot(null,null);
    }

}
