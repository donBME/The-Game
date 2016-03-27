

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-m�rc.-2016 12:28:32
 */
public class Coordinate {

	private int x;
	private int y;

	public int GetX(){
		return x;
	}

	public int GetY(){
		return y;
	}

	/**
	 * 
	 * @param sx: x koordináta
	 * @param sy: y koordináta
	 */
	public void Set(int sx, int sy){
		x = sx;
		y = sy;
	}

}