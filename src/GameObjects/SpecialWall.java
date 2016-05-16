package GameObjects;

/**
 * Speciális fal objektum, melyre csillagkapu lőhető
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

    /**
     * Ajtó-e az objektum
     *
     * @return hamis, a speciális fal nem ajtó
     */
    @Override
    public boolean isDoor() {
        return false;
    }
}