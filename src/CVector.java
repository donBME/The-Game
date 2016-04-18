

/**
 * @author Laszlo
 * @version 1.0
 */
public class CVector extends Coordinate {

	// Kiegészítettük az attribútumokat egy mozgási iránnyal is.
	private Direction dir;

	/**
	 * Értékadó kostruktor
	 *
	 * @param sx x koordináta
	 * @param sy y koordináta
	 * @param sd irány
	 */
	public CVector(int sx, int sy, Direction sd) {
		Set(sx,sy);
		dir = sd;
	}

	/**
	 * Irány getter fgv.
	 * @return Mozgási irány
	 */
	public Direction GetDir(){
		return dir;
	}

	/**
	 * 
	 * @param sx x koordináta
	 * @param sy y koordináta
	 * @param sd irány
	 */
	public void SetD(int sx, int sy, Direction sd){
		Set(sx,sy);
		dir = sd;
	}

	/**
	 * Átkonvertálja a CVectort egy sima Coordinate osztályra, irány nélkül
	 * @return Egyszerűsített CVector
	 */
	public Coordinate toCoord() {
		return new Coordinate(GetX(), GetY());
	}

	/**
	 * CVector -> Coordinate átalakító
	 * @return az irány alapján következő koordináták
     */
	public CVector toNextCoord() {
		switch (dir) {
			case North:
				return new CVector(GetX(), GetY()+1, dir);
			case South:
				return new CVector(GetX(), GetY()-1, dir);
			case East:
				return new CVector(GetX()+1, GetY(), dir);
			case West:
				return new CVector(GetX()-1, GetY(), dir);
		}
		return this;
	}

//	@Override
//	public boolean equals(Object obj) {
//		CVector comparing = (CVector)obj;
//		return super.equals(obj) && comparing.dir == dir;
//	}
}