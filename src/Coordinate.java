

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-m�rc.-2016 12:28:32
 */
public class Coordinate {

	private int x;
	private int y;

	public int GetX(){
		System.out.println(">>Coordinate::GetX()");
		System.out.println("<<Coordinate::GetX()");
		return x;
	}

	public int GetY(){
        System.out.println(">>Coordinate::GetY()");
        System.out.println("<<Coordinate::GetY()");
        return y;
	}

	/**
	 * 
	 * @param sx: x koordináta
	 * @param sy: y koordináta
	 */
	public void Set(int sx, int sy){
        System.out.println(">>Coordinate::Set(int sx, int sy)");
		x = sx;
		y = sy;
        System.out.println("<<Coordinate::Set(int sx, int sy)");
	}

}