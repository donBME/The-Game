

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:33
 */
public interface FieldObject {

	/**
	 * @return Halálos-e az objektumra való rálépés
	 */
	public boolean IsMortal();

	/**
	 * @return Löhetö-e az objektumra csillagkapu.
	 */
	public boolean Shootable();

	/**
	 *
	 * @return Rá lehet-e lépni az objektumra.
	 */
	public boolean Steppable();
}