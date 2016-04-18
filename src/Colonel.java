/**
 * Created by Laszlo on 2016. 04. 17..
 */
public class Colonel extends Player {
    public Colonel(ShotHandler shothandler, GrabHandler grabhandler, StepHandler stephandler, int sx, int sy) {
        super(shothandler, grabhandler, stephandler, true, false, sx, sy);
    }

    @Override
    public void Step(Direction toDir) {
        super.Step(toDir);

        if (pos == null) {

            System.out.println("You are dead! Game over!");
        } else {
            System.out.println("Player position: " + pos.GetX() + "," + pos.GetY() + " " + toDir);
        }
    }
}
