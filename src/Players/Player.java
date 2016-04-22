package Players;

import GameObjects.Box;
import Handlers.GrabHandler;
import Handlers.ShotHandler;
import Handlers.StepHandler;
import Tools.CVector;
import Tools.Direction;
import Tools.StarGateColor;

/**
 * @author Laszlo
 * @version 1.0
 */
public abstract class Player {

	CVector pos;
	// Belsö tárolók
	private int ZPMs;
	private Box handfull;
	private GrabHandler hand;
	private StepHandler leg;
	private ShotHandler gun;
	private boolean canGenerateZPM;
	private boolean canFillAbyss;

	/**
	 * Players.Player konstruktor
	 *
	 * @param shothandler    Fegyver vezérlő.
	 * @param grabhandler    GameObjects.Box vezérlő.
	 * @param stephandler    Lépés vezérlő.
	 * @param canGenerateZPM Tud-e a játékos GameObjects.ZPM-et generálni.
	 * @param canFillAbyss   Szakadékba lépés esetén az betöltődik-e.
	 * @param sx             Kezdeti pozíció: x
	 * @param sy             Kezdeti pozíció: y
	 */
	Player(ShotHandler shothandler, GrabHandler grabhandler, StepHandler stephandler, boolean canGenerateZPM, boolean canFillAbyss, int sx, int sy) {
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
		System.out.println();
	}


	/**
	 * Csillagkapu tövés
	 * @param color Csilagkapu színe
	 */
	public void Shoot(StarGateColor color){
		if (handfull == null && pos != null) {
			gun.Shoot(pos,color);
			System.out.println();
		}
	}

	/**
	 * Lépés
	 * @param toDir a l?p?s ir?nya
	 */
	public void Step(Direction toDir) {
		if (pos != null) {
			pos = leg.NextStep(pos, toDir, canGenerateZPM, ZPMs, canFillAbyss);
		} else {
			System.out.print("Game over");
		}

		if (leg.isZPMcollected()) {
			ZPMs++;
		}
		System.out.println();
	}

	public boolean Shotable()
	{
		return false;
	}

	/**
	 * Players.Player helyének lekérésére
	 * @return Players.Player pozíciója és iránya
	 */
	public CVector getPos() {
		return pos;
    }

	public boolean hasBox() {
		return (handfull != null);
	}
	
	public abstract String whichPlayer();

	public void kill()
	{
		this.pos=null;
	}
}