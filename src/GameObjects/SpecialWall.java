package GameObjects;

/**
 * @author Laszlo
 * @version 1.0
 */
public class SpecialWall extends Wall {

    /**
     * GameObjects.SpecialWall kostruktor
     */
    public SpecialWall() {
    }

    /**
     * Lőhető-e a falra csillagkapu?
     *
     * @return Igen, az ilyen típusú falra lőhető csillagkapu.
     */
    @Override
    public boolean Shootable() {
        return true;
    }

    @Override
    public boolean isDoor() {
        return false;
    }
}