

/**
 * @author Laszlo
 * @version 1.0
 */
public class Player {

	private boolean canGenerateZPM;
	private int ZPMs;
	private Box handfull;
	private CVector pos;
	private GrabHandler hand;
	private StepHandler leg;
	private ShotHandler gun;

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
        }
        else {
            boolean success = hand.Put(fromThisPosition, handfull);
            if (success) {
				handfull = null;
			}
        }
	}


	/**
	 *
	 * @param color szín
	 */
	public void Shoot(StarGateColor color){
        if(handfull == null){
            gun.Shoot(pos,color);
        }
	}

	/**
	 * @param toDir a l?p?s ir?nya
	 */
	public void Step(Direction toDir) {
		pos = leg.NextStep(pos, toDir, canGenerateZPM, ZPMs);
        if (leg.isZPMcollected()){
            ZPMs++;
        }
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

	public boolean hasBox() {
		return (handfull != null);
	}
}