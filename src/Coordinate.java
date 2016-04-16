

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
	 * Üres konstruktor
	 */
	public Coordinate(){}

	/**
	 * Egyböl értékadó konstruktor
	 * @param sx x koordináta
	 * @param sy y koordináta
     */
	public Coordinate(int sx, int sy){
		x = sx;
		y = sy;
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

	/**
	 * Hashmap összehasonlításhoz.
	 * @param obj Összehasonlítandó érték
	 * @return igaz/hamis
     */
	@Override
	public boolean equals(Object obj) {
		Coordinate comparing = (Coordinate)obj;
		return x == comparing.GetX() && y == comparing.GetY();
	}
}