package Players;

import Handlers.GrabHandler;
import Handlers.ShotHandler;
import Handlers.StepHandler;
import Tools.CVector;
import Tools.Direction;

import java.util.Random;

/**
 * Replikátor osztály
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
     * Felüldefiniált interact fgv.
     *
     * @param fromThisPosition Erröl a pozícióról akarunk müveletet végrehajtani.
     */

    public void interact(CVector fromThisPosition) {
        // nem mozgat semmit
    }

    /**
     * Felüldefiniált lépés fgv.
     *
     * @param toDir a lépés iránya
     */
    public void step(Direction toDir) {
        System.out.print("Replicator ");

        super.step(toDir);
    }

    /**
     * Replikátor léptetése random irányba
     */
    public void randomMove() {
        Random rn = new Random();
        int answer = rn.nextInt(4);
        switch (answer) {
            case 0:
                step(Direction.East);
                step(Direction.East);
                break;
            case 1:
                step(Direction.North);
                step(Direction.North);
                break;
            case 2:
                step(Direction.West);
                step(Direction.West);
                break;
            case 3:
                step(Direction.South);
                step(Direction.South);
                break;
        }

    }

}
