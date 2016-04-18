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

public class Replicator extends Player {

    /**
     * Replikátor konstruktora
     *
     * @param shothandler Fegyver vezérlő.
     * @param grabhandler GameObjects.Box vezérlő.
     * @param stephandler Lépés vezérlő.
     * @param sx          Kezdeti pozíció: x
     * @param sy          Kezdeti pozíció: y
     */
    public Replicator(ShotHandler shothandler, GrabHandler grabhandler, StepHandler stephandler, int sx, int sy) {
        super(shothandler, grabhandler, stephandler, false, true, sx, sy);
    }

    /**
     * Felüldefiniált lövés fgv.
     * @param color Csilagkapu színe
     */
    @Override
    public void Shoot(StarGateColor color) {
        // nem lő
    }

    /**
     * Felüldefiniált interact fgv.
     * @param fromThisPosition Erröl a pozícióról akarunk müveletet végrehajtani.
     */
    @Override
    public void Interact(CVector fromThisPosition) {
        // nem mozgat semmit
    }

    /**
     * Felüldefiniált lépés fgv.
     * @param toDir a l?p?s ir?nya
     */
    @Override
    public void Step(Direction toDir) {
        System.out.print("Replicator ");
        super.Step(toDir);


        if (pos == null) {
            // Valami legyen
        }
    }
}
