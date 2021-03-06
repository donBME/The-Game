package GameObjects;

/**
 * Fal objektum
 */
public class Wall implements FieldObject {

    /**
     * Konstrukor
     */
    public Wall() {
    }

    /**
     * Halálos-e az objektumra lépés
     *
     * @return Nem, a falra lépés nem halálos
     */
    @Override
    public boolean IsMortal() {
        return false;
    }

    /**
     * Lőhető-e a falra csillagkapu
     *
     * @return Nem, alapesetben a falra nem lőhető csillagkapu.
     */
    @Override
    public boolean Shootable() {
        return false;
    }

    /**
     * Rá lehet-e lépni a falra
     *
     * @return Nem, a fal nem átjárható.
     */
    @Override
    public boolean Steppable() {
        return false;
    }

    /**
     * Ajtó-e az objektum
     *
     * @return hamis, a fal nem ajtó
     */
    @Override
    public boolean isDoor() {
        return false;
    }

}