package Players;

import Handlers.GrabHandler;
import Handlers.ShotHandler;
import Handlers.StepHandler;
import Tools.CVector;
import Tools.Direction;
import Tools.StarGateColor;

/**
 * Ezredes osztály
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
     *
     * @param toDir a lépés iránya
     */
    @Override
    public void step(Direction toDir) {
        System.out.print("Colonel ");
        super.step(toDir);
    }

    /**
     * Doboz felvétel/lerakás fgv.
     *
     * @param fromThisPosition Erröl a pozícióról akarunk müveletet végrehajtani.
     */
    @Override
    public void interact(CVector fromThisPosition) {
        System.out.print("Colonel ");
        super.interact(fromThisPosition);
    }

    /**
     * Csillagkapu lövés
     *
     * @param color Csilagkapu színe
     */
    @Override
    public void shoot(StarGateColor color) {
        System.out.print("Colonel ");
        super.shoot(color);
    }

}
