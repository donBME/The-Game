
/*
 * Created by Laszlo on 2016. 02. 18..
 */

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
public class TestMain {
    public static void main(String[] args) {
        // Anything which isn't evident at first glimpse, must be rigorously described in a comment beforehand.
        //System.out.println("Test method:" + System.lineSeparator() + "Starting one hell of a game from scratch!");

        // Egy menüt rakjunk már ide srácok!

        /*TestMain mivelnincsmenuezureztkellhasznalni = new TestMain();
        mivelnincsmenuezureztkellhasznalni.Grab();*/
        TestMain mivelnincsmenuezureztkellhasznalni = new TestMain();
            mivelnincsmenuezureztkellhasznalni.Step();

    }

	private void Init(){

    }

    private void CanPut(){

    }

    private void Put(){
        // Initialization
        Player player = new Player(new Box());
        GrabHandler grabHandler = new GrabHandler();
        DataAccessPoint dataAccessPoint = new DataAccessPoint();
        dataAccessPoint.boxes = new BoxInventory();
        dataAccessPoint.buttons = new ButtonInventory();
        dataAccessPoint.collectables = new CollectableInventory();
        dataAccessPoint.fields = new FieldObjectInventory();
        dataAccessPoint.stargates = new StarGateInventory();
        grabHandler.setData(dataAccessPoint);
        player.sethand(grabHandler);
        // Real interaction
        player.Interact(null);
    }

    private void Grab(){
        // Initialization
        Player player = new Player(null);
        GrabHandler grabHandler = new GrabHandler();
        DataAccessPoint dataAccessPoint = new DataAccessPoint();
        dataAccessPoint.boxes = new BoxInventory();
        dataAccessPoint.buttons = new ButtonInventory();
        dataAccessPoint.collectables = new CollectableInventory();
        dataAccessPoint.fields = new FieldObjectInventory();
        dataAccessPoint.stargates = new StarGateInventory();
        grabHandler.setData(dataAccessPoint);
        player.sethand(grabHandler);
        // Real interaction
        player.Interact(null);
    }

    private void Step(){
        // Initialization
        Player player = new Player(null);
        StepHandler leg = new StepHandler();
        DataAccessPoint dataAccessPoint = new DataAccessPoint();
        dataAccessPoint.boxes = new BoxInventory();
        dataAccessPoint.buttons = new ButtonInventory();
        dataAccessPoint.collectables = new CollectableInventory();
        dataAccessPoint.fields = new FieldObjectInventory();
        dataAccessPoint.stargates = new StarGateInventory();
        player.setleg(leg);
        leg.setData(dataAccessPoint);
        // Real interaction
        player.Step(Direction.North);
    }

    private void Shoot(){

    }

    private void Push(){

    }


}
