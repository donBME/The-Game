package GameObjects;

/**
 * Pálya elem
 */
public interface FieldObject {

    /**
     * @return Halálos-e az objektumra való rálépés
     */
    boolean IsMortal();

    /**
     * @return Lőhető-e az objektumra csillagkapu.
     */
    boolean Shootable();

    /**
     * @return Rá lehet-e lépni az objektumra.
     */
    boolean Steppable();

    /**
     * @return Ajtó-e az objektum.
     */
    boolean isDoor();
}