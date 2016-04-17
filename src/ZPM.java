

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:33
 */
public class ZPM implements Collectable {

	private static int count;

	public ZPM(){}

	/**
	 * @author Mate
	 * @param c ZPMek sz?ma
	 */
	public static void setCount(int c){
		count = c;
	}
	
	/**
	 * @author Mate
	 * @return A p?ly?n tal?lhat? ZPM-ek sz?ma
	 */
	public static int GetCount() {
		return count;
	}
	
	/**
	 * @author Mate
	 */
	@Override
	public void Collect() {
		count--;
		System.out.println("ZPM collected");
	}
}