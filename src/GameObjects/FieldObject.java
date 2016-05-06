package GameObjects;

/**
 * @author Laszlo
 * @version 1.0
 */
public interface FieldObject {

    /**
     * @return Hal�los-e az objektumra val� r�l�p�s
     */
    boolean IsMortal();

    /**
     * @return L�het�-e az objektumra csillagkapu.
     */
    boolean Shootable();

    /**
     * @return R� lehet-e l�pni az objektumra.
     */
    boolean Steppable();
}