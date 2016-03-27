
public class Game {
	
	FieldObjectInventory fieldObjects;
	public Game ()
	{
		
		System.out.println(">>FieldObjectInventory::Create()");
		fieldObjects = new FieldObjectInventory();
		
		System.out.println(">>Wall::Create()");
		Wall wall = new Wall();
		System.out.println(">>FieldObjectInventory::setFieldOject(Wall wall)");
		fieldObjects.setFieldObject(wall);
		
		System.out.println(">>SpecialWall::Create()");
		SpecialWall specwall = new SpecialWall();
		System.out.println(">>FieldObjectInventory::setFieldOject(SpecialWall specwall)");
		fieldObjects.setFieldObject(specwall);
		
		System.out.println(">>Abyss::Create()");
		Abyss abyss = new Abyss();
		System.out.println(">>FieldObjectInventory::setFieldOject(Abyss abyss)");
		fieldObjects.setFieldObject(abyss);
		
		System.out.println(">>Way::Create()");
		Way way = new Way(); 
		System.out.println(">>FieldObjectInventory::setFieldOject(Way way)");
		fieldObjects.setFieldObject(way);
		
		System.out.println(">>Door::Create()");
		Door door = new Door();
		System.out.println(">>FieldObjectInventory::setFieldOject(Door door)");
		fieldObjects.setFieldObject(door);
		
		System.out.println(">>Box::Create()");
		Box box = new Box();
		System.out.println(">>FieldObjectInventory::setFieldOject(Box box)");
		fieldObjects.setFieldObject(box);
		
		System.out.println(">>StarGateInventory::Create()");
		StarGateInventory stargateinventory = new StarGateInventory();
		
		System.out.println(">>BoxInventory::Create()");
		BoxInventory boxinventory = new BoxInventory();
		System.out.println(">>BoxInventory::setBox(Box box)");
		boxinventory.setBox(box);
		
		System.out.println(">>Button::Create(Door door)");
		Button button = new Button(door);
		
		System.out.println(">>ButtonInventory::Create()");
		ButtonInventory buttoninventory = new ButtonInventory();
		
		System.out.println(">>ButtonInventory::setButton(Button button)");
		buttoninventory.setButton(button);
		
		System.out.println(">>ZPM::Create()");
		ZPM zpm = new ZPM();
		
		System.out.println(">>CollectableInventory::Create()");
		CollectableInventory collectables = new CollectableInventory();
		
		System.out.println(">>CollectableInventory::setCollectable(ZPM zpm)");
		
		System.out.println(">>DataAccessPoint::Create(StarGateInventory, FieldObjectInventory, BoxInventory, ButtonInventory, CollectableInventory)");
		DataAccessPoint data = new DataAccessPoint(stargateinventory, fieldObjects, boxinventory, buttoninventory, collectables);
		
		System.out.println(">>ShotHandler::Create(DataAccessPoint data)");
		ShotHandler shothandler = new ShotHandler(data);
		
		System.out.println(">>GrabHandler::Create(DataAccessPoint data)");
		GrabHandler grabhandler = new GrabHandler(data);
		
		System.out.println(">>StepHandler::Create(DataAccessPoint data)");
		StepHandler stephandler = new StepHandler(data);
		
		System.out.println(">>Player::Create(ShotHandler shothandler, GrabHandler grabhandler, StepHandler stephandler)");
		Player player = new Player(shothandler, grabhandler, stephandler);
		
		System.out.println("<<Game::Create()");
	}
}
