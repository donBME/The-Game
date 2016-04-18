

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-m�rc.-2016 12:28:33
 */
public interface FieldObject {

	/**
	 * @return Hal�los-e az objektumra val� r�l�p�s
	 */
	public boolean IsMortal();

	/**
	 * @return L�het�-e az objektumra csillagkapu.
	 */
	public boolean Shootable();

	/**
	 *
	 * @return R� lehet-e l�pni az objektumra.
	 */
	public boolean Steppable();
}