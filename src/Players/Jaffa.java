package Players;

import Handlers.GrabHandler;
import Handlers.ShotHandler;
import Handlers.StepHandler;
import Tools.CVector;
import Tools.StarGateColor;

/**
 * @author Laszlo
 * @version 1.0
 */

public class Jaffa extends Player {

    /**
     * Players.Jaffa konstruktora
     *
     * @param shothandler Fegyver vezérlő.
     * @param grabhandler GameObjects.Box vezérlő.
     * @param stephandler Lépés vezérlő.
     * @param sx          Kezdeti pozíció: x
     * @param sy          Kezdeti pozíció: y
     */
    public Jaffa(ShotHandler shothandler, GrabHandler grabhandler, StepHandler stephandler, int sx, int sy) {
        super(shothandler, grabhandler, stephandler, false, false, sx, sy);
    }

    /**
     * Felüldefiniált lépés függvény
     *
     * @param toDir a lépés iránya
     */
    @Override
    public void Step(Tools.Direction toDir) {
        System.out.print("Jaffa ");
        super.Step(toDir);

        if (pos == null) {

        }
    }

    /**
     * Box felvétel / lerakás
     *
     * @param fromThisPosition Erröl a pozícióról akarunk müveletet végrehajtani.
     */
    @Override
    public void Interact(CVector fromThisPosition) {
        System.out.print("Jaffa ");
        super.Interact(fromThisPosition);
    }

    /**
     * Csillagkapu lövés
     *
     * @param color Csilagkapu színe
     */
    @Override
    public void Shoot(StarGateColor color) {
        System.out.print("Jaffa ");
        super.Shoot(color);
    }

    /**
     * Visszaadja a játékos nevét
     */
    @Override
    public String whichPlayer() {
        return "Jaffa";
    }
}
