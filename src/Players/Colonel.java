package Players;

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

public class Colonel extends Player {

    /**
     * Az ezredest megvalósító osztály konstruktora.
     *
     * @param shothandler Fegyver vezérlő.
     * @param grabhandler GameObjects.Box vezérlő.
     * @param stephandler Lépés vezérlő.
     * @param sx          Kezdeti pozíció: x
     * @param sy          Kezdeti pozíció: y
     */
    public Colonel(ShotHandler shothandler, GrabHandler grabhandler, StepHandler stephandler, int sx, int sy) {
        super(shothandler, grabhandler, stephandler, true, false, sx, sy);
    }

    /**
     * Felüldefiniált lépés osztály.
     * @param toDir a l?p?s ir?nya
     */
    @Override
    public void Step(Direction toDir) {
        System.out.print("Colonel ");
        super.Step(toDir);

        // Ha a játékos halott
        if (pos == null) {
        }
    }

    /**
     * Doboz felvétel/lerakás fgv.
     *
     * @param fromThisPosition Erröl a pozícióról akarunk müveletet végrehajtani.
     */
    @Override
    public void Interact(CVector fromThisPosition) {
        System.out.print("Colonel ");
        super.Interact(fromThisPosition);
    }

    /**
     * Csillagkapu lövés
     *
     * @param color Csilagkapu színe
     */
    @Override
    public void Shoot(StarGateColor color) {
        System.out.print("Colonel ");
        super.Shoot(color);
    }
    
    /**
     * Visszaadja a j�t�kos nev�t
     */
    @Override
	public String whichPlayer(){
		return "Colonel";
    }
}
