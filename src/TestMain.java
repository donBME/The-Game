
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
            System.out.println(">>Menu::Create()");
        	TestMain menu = new TestMain();

        	System.out.println(">>Game::Create()");
            Game game = new Game();

	InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = new String();
            System.out.println("I wait command!");

        TestMain menu = new TestMain();
        while(line != "q"){
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        switch (line) {
		case "1":
			menu.Step();
			System.out.println("I wait command!");
			break;
		case "2":
			menu.Shoot();
			System.out.println("I wait command!");
			break;
		case "3":
			menu.Grab();
			System.out.println("I wait command!");
			break;
		case "4":
			menu.Put();
			System.out.println("I wait command!");
			break;
		default:
			break;
		}
        }

    }

	private void Init(){

    }

    private void CanPut(){

    }

    private void Put(){
        // Initialization
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
