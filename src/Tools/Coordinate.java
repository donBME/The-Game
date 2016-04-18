package Tools;

/**
 * @author Laszlo
 * @version 1.0
 */
@SuppressWarnings("ALL")
public class Coordinate {

	// Belsö koordináta attribútumok
	private int x;
	private int y;

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
	 * X koordináta getter fgv.
	 *
	 * @return x koordináta
	 */
	public int GetX() {
		return x;
	}

	/**
	 * Y koordináta getter fgv.
	 *
	 * @return y koordináta
	 */
	public int GetY() {
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