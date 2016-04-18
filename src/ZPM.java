

/**
 * @author Laszlo
 * @version 1.0
 */
public class ZPM implements Collectable {

	// Összes ZPM modul száma
	private static int count;

	/**
	 * Üres konstruktor
	 */
	public ZPM(){}

	/**
	 * @param c ZPMek sz?ma
	 */
	public static void setCount(int c){
		count = c;
	}
	
	/**
	 * @return A p?ly?n tal?lhat? ZPM-ek sz?ma
	 */
	public static int GetCount() {
		return count;
	}

	/**
	 * ZPM begy?jtésekor lefutó fgv.
	 */
	@Override
	public void Collect() {
		count--;
		System.out.println("ZPM collected");
	}
}