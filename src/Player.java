

/**
 * @author Laszlo
 * @version 1.0
 */
public abstract class Player {

	protected int ZPMs;
	protected Box handfull;
	protected CVector pos;
	protected GrabHandler hand;
	protected StepHandler leg;
	protected ShotHandler gun;
	protected boolean canGenerateZPM;
	protected boolean canFillAbyss;

	public Player(ShotHandler shothandler, GrabHandler grabhandler, StepHandler stephandler, boolean canGenerateZPM, boolean canFillAbyss, int sx, int sy) {
		gun = shothandler;
		hand = grabhandler;
		leg = stephandler;
		ZPMs = 0;
		this.canGenerateZPM = canGenerateZPM;
		this.canFillAbyss = canFillAbyss;
		Direction dir = Direction.North;
		pos  = new CVector(sx, sy, dir);
	}

    /**
     * M�velet v�grehajt�sa
     * @param fromThisPosition Err�l a poz�ci�r�l akarunk m�veletet v�grehajtani.
     */
	public void Interact(CVector fromThisPosition){
		if (pos != null) {
			if (handfull == null) {
				handfull = hand.Grab(fromThisPosition);
			} else {
				boolean success = hand.Put(fromThisPosition, handfull);
				if (success) {
					handfull = null;
				}
			}
		}
	}


	/**
	 *
	 * @param color sz�n
	 */
	public void Shoot(StarGateColor color){
		if (handfull == null && pos != null) {
			gun.Shoot(pos,color);
        }
	}

	/**
	 * @param toDir a l?p?s ir?nya
	 */
	public void Step(Direction toDir) {
		if (pos != null) {
			pos = leg.NextStep(pos, toDir, canGenerateZPM, ZPMs, canFillAbyss);
		}

		if (leg.isZPMcollected()) {
			ZPMs++;
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