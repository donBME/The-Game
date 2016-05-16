package GameObjects;

/**
 * Járható út obektum
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

    /**
     * Ajtó-e az objetum
     *
     * @return hamis, nem ajtó
     */
    @Override
    public boolean isDoor() {
        return false;
    }

}