

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-mÃ¡rc.-2016 12:28:33
 */
public class Player {

	private boolean canGenerateZPM;
	private int ZPMs;
	private Box handfull;
	private CVector pos;
	private GrabHandler hand;
	private StepHandler leg;
	private ShotHandler gun;
    private QuestionAssistant questionAssistant = new QuestionAssistant();

    public Player(ShotHandler shothandler, GrabHandler grabhandler, StepHandler stephandler, boolean canGenerateZPM) {
		System.out.println(">>Player::Create(ShotHandler shothandler, GrabHandler grabhandler, StepHandler stephandler)");
		gun = shothandler;
		hand = grabhandler;
		leg = stephandler;
		this.canGenerateZPM = canGenerateZPM;
		ZPMs = 0;
		
		System.out.println(">>CVector::Create(int sx, int sy, Direction dir)");
		int sx=0, sy=0;
		Direction dir = Direction.North;
		pos  = new CVector(sx, sy, dir);
		System.out.println("<<Player::Create(ShotHandler shothandler, GrabHandler grabhandler, StepHandler stephandler)");
	}

	/**
	 * 
	 * @author Mate
	 * @param toDir irány
	 */
	public void Interact(Direction toDir){
		System.out.println(">>Player::Interact(Direction toDir)");
        boolean hasBox = questionAssistant.ask("Does the player have a box in hand? (y/n)");
        if(!hasBox)
            handfull = hand.Grab(null);
        else
            hand.Put(null, handfull);
		System.out.println("<<Player::Interact(Direction toDir)");
	}


	/**
	 * 
	 * @param toDir irÃ¡ny
	 * @param color szÃ­n
	 */
	public void Shoot(Direction toDir, StarGateColor color){
        System.out.println(">>Player::Shoot(Direction toDir, StarGateColor color)");
        boolean hasBox = questionAssistant.ask("Does the player have a box in hand? (y/n)");
        if(!hasBox){
            gun.Shoot(null,null);
        }
        System.out.println("<<Player::Shoot(Direction toDir, StarGateColor color)");
	}

	/**
	 * @author Mate
	 * @param toDir a lépés iránya
	 */
	public void Step(Direction toDir)
	{
		pos = leg.NextStep(pos, toDir, canGenerateZPM, ZPMs);
		if(pos == null){
			// FIXME 
			// ezt majd át kell írni csak nem tudom, hogy hogyan fog ez mûködni
			System.out.println("You are dead! Game over!"); 
		}
	}

}