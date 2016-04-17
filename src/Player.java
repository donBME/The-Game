

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:33
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

    public Player(ShotHandler shothandler, GrabHandler grabhandler, StepHandler stephandler, boolean canGenerateZPM, int sx, int sy) {
		gun = shothandler;
		hand = grabhandler;
		leg = stephandler;
		this.canGenerateZPM = canGenerateZPM;
		ZPMs = 0;

		Direction dir = Direction.North;
		pos  = new CVector(sx, sy, dir);
	}

    /**
     * Müvelet végrehajtása
     * @param fromThisPosition Erröl a pozícióról akarunk müveletet végrehajtani.
     */
	public void Interact(CVector fromThisPosition){
        if(handfull == null) {
            handfull = hand.Grab(fromThisPosition);
			if (handfull != null) {
				System.out.println("Box grabbed at: " + fromThisPosition.toNextCoord().GetX() + "," + fromThisPosition.toNextCoord().GetY());
			}
        }
        else {
            boolean success = hand.Put(fromThisPosition, handfull);
            if (success) {
				handfull = null;
				System.out.println("Box put to: " + fromThisPosition.toNextCoord().GetX() + "," + fromThisPosition.toNextCoord().GetY());
			}
        }
	}


	/**
	 * 
	 * @param toDir irány
	 * @param color szín
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
	 * @param toDir a l?p?s ir?nya
	 */
	public void Step(Direction toDir)
	{
		pos = leg.NextStep(pos, toDir, canGenerateZPM, ZPMs);
		if(pos == null){
			// FIXME 
			// ezt majd ?t kell ?rni csak nem tudom, hogy hogyan fog ez m?k?dni
			System.out.println("You are dead! Game over!"); 
		}
        else {
            System.out.println("Player position: " + pos.GetX() + "," + pos.GetY() + " " + toDir);
        }
	}

    /**
     * Player helyének lekérésére
     * @return Player pozíciója és iránya
     */
    public CVector getPos() {
        return pos;
    }
}