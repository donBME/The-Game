package GameObjects;

/**
 * @author Laszlo
 * @version 1.0
 */
public interface FieldObject {

	/**
	 * @return Halálos-e az objektumra való rálépés
	 */
	boolean IsMortal();

	/**
	 * @return Löhetö-e az objektumra csillagkapu.
	 */
	boolean Shootable();

	/**
	 *
	 * @return Rá lehet-e lépni az objektumra.
	 */
	boolean Steppable();
}