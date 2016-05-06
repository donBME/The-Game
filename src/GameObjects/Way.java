package GameObjects;

/**
 * @author Laszlo
 * @version 1.0
 */
public class Way implements FieldObject {

    /**
     * Konstruktor
     */
    public Way() {
    }

    /**
     * Halálos-e az útra lépés.
     *
     * @return Nem, az útra lépés nem halálos.
     */
    @Override
    public boolean IsMortal() {
        return false;
    }

    /**
     * Lőhető-e útra csillagkapu
     *
     * @return Nem, úton nem jöhet létre csillagkapu.
     */
    @Override
    public boolean Shootable() {
        return false;
    }

    /**
     * Rá lehet-e lépni az útra.
     *
     * @return Igen, az útra rá lehet lépni.
     */
    @Override
    public boolean Steppable() {
        return true;
    }

}