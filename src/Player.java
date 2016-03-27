

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:33
 */
public class Player {

	private Box handfull;
	private CVector pos;
	private GrabHandler hand;
	private StepHandler leg;
	private ShotHandler gun;
    private QuestionAssistant questionAssistant = new QuestionAssistant();

    public Player(ShotHandler shothandler, GrabHandler grabhandler, StepHandler stephandler) {
		// TODO Auto-generated constructor stub
		gun = shothandler;
		hand = grabhandler;
		leg = stephandler;
		
		System.out.println(">>CVector::Create(int sx, int sy, Direction dir)");
		int sx=0, sy=0;
		Direction dir = Direction.North;
		pos  = new CVector(sx, sy, dir);
		System.out.println("<<Player::Create(ShotHandler shothandler, GrabHandler grabhandler, StepHandler stephandler)");
	}

	public ShotHandler getgun(){
		return gun;
	}

	public GrabHandler gethand(){
		return hand;
	}

	public StepHandler getleg(){
		return leg;
	}

	public CVector getpos(){
		return pos;
	}


	/**
	 * 
	 * @author Mate
	 * @param toDir: irány
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
	 * @param newVal
	 */
	public void setgun(ShotHandler newVal){
		gun = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void sethand(GrabHandler newVal){
		hand = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setleg(StepHandler newVal){
		leg = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setpos(CVector newVal){
		pos = newVal;
	}

	/**
	 * 
	 * @param toDir: irány
	 * @param color: szín
	 */
	public void Shoot(Direction toDir, StarGateColor color){

	}

	/**
	 * mozgás iránnyal hívódik meg, tovobbátja a vezérlést a StepHandlernek, aki
	 * válaszul megadja melyik mezőn, milyen irányba nézve kell a játékosnak lennie
	 * 
	 * @param toDir: irány
	 */
	public void Step(Direction toDir)
	{
		System.out.println(">>Player::Step(Direction toDir)");
		leg.NextStep(pos,toDir);
		System.out.println("<<Player::Step(Direction toDir)");
	}

}