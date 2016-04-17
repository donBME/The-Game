/**
 * Created by Laszlo on 2016. 04. 17..
 */
public class Replicator extends Player {
    public Replicator(ShotHandler shothandler, GrabHandler grabhandler, StepHandler stephandler, int sx, int sy) {
        super(shothandler, grabhandler, stephandler, false, sx, sy);
    }

    @Override
    public void Shoot(StarGateColor color) {
        // nem lő
    }

    @Override
    public void Interact(CVector fromThisPosition) {
        // nem mozgat semmit
    }
}
