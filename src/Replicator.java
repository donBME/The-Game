/**
 * Created by Laszlo on 2016. 04. 17..
 */
public class Replicator extends Player {
    public Replicator(ShotHandler shothandler, GrabHandler grabhandler, StepHandler stephandler, int sx, int sy) {
        super(shothandler, grabhandler, stephandler, false, true, sx, sy);
    }

    @Override
    public void Shoot(StarGateColor color) {
        // nem lő
    }

    @Override
    public void Interact(CVector fromThisPosition) {
        // nem mozgat semmit
    }

    @Override
    public void Step(Direction toDir) {
        super.Step(toDir);


        if (pos == null) {

        } else {
            System.out.println("Replicator position: " + pos.GetX() + "," + pos.GetY() + " " + toDir);
        }
    }
}
