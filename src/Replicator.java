/**
 * Created by Laszlo on 2016. 04. 17..
 */
public class Replicator extends Player {

    /**
     * Replikátor konstruktora
     *
     * @param shothandler Fegyver vezérlő.
     * @param grabhandler Box vezérlő.
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
        super.Step(toDir);


        if (pos == null) {

        } else {
            System.out.println("Replicator position: " + pos.GetX() + "," + pos.GetY() + " " + toDir);
        }
    }
}
