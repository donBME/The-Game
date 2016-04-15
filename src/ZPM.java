

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-mÃ¡rc.-2016 12:28:33
 */
public class ZPM implements Collectable {

	private static int count;

	public ZPM(){}

	/**
	 * @author Mate
	 * @param c ZPMek száma
	 */
	public static void setCount(int c){
		count = c;
	}
	
	/**
	 * @author Mate
	 * @return A pályán található ZPM-ek száma
	 */
	public static int GetCount() {
		return count;
	}
	
	/**
	 * @author Mate
	 * @param collected Az eddig összegyûjtött ZPM-ek száma
	 */
	@Override
	public void Collect(int collected) {
		collected++;
		count--;
		
	}
}