

/**
 * @author Laszlo
 * @version 1.0
 */
public abstract class Player {

	// Belsö tárolók
	protected int ZPMs;
	protected Box handfull;
	protected CVector pos;
	protected GrabHandler hand;
	protected StepHandler leg;
	protected ShotHandler gun;
	protected boolean canGenerateZPM;
	protected boolean canFillAbyss;

	/**
	 * Player konstruktor
	 *
	 * @param shothandler    Fegyver vezérlő.
	 * @param grabhandler    Box vezérlő.
	 * @param stephandler    Lépés vezérlő.
	 * @param canGenerateZPM Tud-e a játékos ZPM-et generálni.
	 * @param canFillAbyss   Szakadékba lépés esetén az betöltődik-e.
	 * @param sx             Kezdeti pozíció: x
	 * @param sy             Kezdeti pozíció: y
	 */
	public Player(ShotHandler shothandler, GrabHandler grabhandler, StepHandler stephandler, boolean canGenerateZPM, boolean canFillAbyss, int sx, int sy) {
		gun = shothandler;
		hand = grabhandler;
		leg = stephandler;
		ZPMs = 0;
		this.canGenerateZPM = canGenerateZPM;
		this.canFillAbyss = canFillAbyss;
		Direction dir = Direction.North;
		pos = new CVector(sx, sy, dir);
	}

	/**
	 * Müvelet végrehajtása
	 * @param fromThisPosition Erröl a pozícióról akarunk müveletet végrehajtani.
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
	 * Csillagkapu tövés
	 * @param color Csilagkapu színe
	 */
	public void Shoot(StarGateColor color){
		if (handfull == null && pos != null) {
			gun.Shoot(pos,color);
        }
	}

	/**
	 * Lépés
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