package Players;

import Handlers.GrabHandler;
import Handlers.ShotHandler;
import Handlers.StepHandler;
import Tools.Direction;

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
        super.Step(toDir);

        // Ha a játékos halott
        if (pos == null) {

            System.out.println("Players.Colonel is dead!");
        } else {
            System.out.println("Players.Colonel position: " + pos.GetX() + "," + pos.GetY() + " " + toDir);
        }
    }
}
