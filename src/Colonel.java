/**
 * Created by Laszlo on 2016. 04. 17..
 */
public class Colonel extends Player {
    public Colonel(ShotHandler shothandler, GrabHandler grabhandler, StepHandler stephandler, int sx, int sy) {
        super(shothandler, grabhandler, stephandler, true, sx, sy);
    }
}
