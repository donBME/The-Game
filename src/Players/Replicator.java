package Players;

import Handlers.GrabHandler;
import Handlers.ShotHandler;
import Handlers.StepHandler;
import Tools.CVector;
import Tools.Direction;

import java.util.Random;

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
     * Felüldefiniált interact fgv.
     *
     * @param fromThisPosition Erröl a pozícióról akarunk müveletet végrehajtani.
     */

    public void Interact(CVector fromThisPosition) {
        // nem mozgat semmit
    }

    /**
     * Felüldefiniált lépés fgv.
     *
     * @param toDir a l?p?s ir?nya
     */
    public void Step(Direction toDir) {
        System.out.print("Replicator ");

        super.Step(toDir);
        if (pos == null) {
        }
    }

    public void randomMove() {
                Random rn = new Random();
                int answer = rn.nextInt(4);
        switch (answer) {
            case 0:
                Step(Direction.East);
                Step(Direction.East);
                break;
            case 1:
                Step(Direction.North);
                Step(Direction.North);
                break;
            case 2:
                Step(Direction.West);
                Step(Direction.West);
                break;
            case 3:
                Step(Direction.South);
                Step(Direction.South);break;
        }

    }

    public boolean Shootable() {
        return true;
    }

    /**
     * Visszaadja a j�t�kos nev�t
     */
    @Override
    public String whichPlayer() {
        return "Replicator";
    }
}
