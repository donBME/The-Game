package Players;

import Handlers.GrabHandler;
import Handlers.ShotHandler;
import Handlers.StepHandler;

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
     * @param toDir a l?p?s ir?nya
     */
    @Override
    public void Step(Tools.Direction toDir) {
        super.Step(toDir);

        if (pos == null) {

            System.out.println("You are dead! Game over!");
        } else {
            System.out.println("Players.Jaffa position: " + pos.GetX() + "," + pos.GetY() + " " + toDir);
        }
    }
}
