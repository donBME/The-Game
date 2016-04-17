

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
     * M�velet v�grehajt�sa
     * @param fromThisPosition Err�l a poz�ci�r�l akarunk m�veletet v�grehajtani.
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
	 * @param color sz�n
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
     * Player hely�nek lek�r�s�re
     * @return Player poz�ci�ja �s ir�nya
     */
    public CVector getPos() {
        return pos;
    }

	public boolean hasBox() {
		return (handfull != null);
	}
}