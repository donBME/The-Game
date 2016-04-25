package Tools;

/**
 * @author Laszlo
 * @version 1.0
 */

public class CVector extends Coordinate {

	// Kieg�sz�tett attrib�tumok egy mozg�sir�nnyal.
	private Direction dir;

	/**
	 * �rt�kad� kostruktor
	 *
	 * @param sx x koordin�ta
	 * @param sy y koordin�ta
	 * @param sd ir�ny
	 */
	public CVector(int sx, int sy, Direction sd) {
		Set(sx,sy);
		dir = sd;
	}

	/**
	 * Ir�ny getter fgv.
	 * @return Mozg�si ir�ny
	 */
	public Direction GetDir(){
		return dir;
	}

	/**
	 * 
	 * @param sx x koordin�ta
	 * @param sy y koordin�ta
	 * @param sd ir�ny
	 */
	public void SetD(int sx, int sy, Direction sd){
		Set(sx,sy);
		dir = sd;
	}

	/**
	 * �tkonvert�lja a CVectort egy sima Tools.Coordinate oszt�lyra, ir�ny n�lk�l.
	 * @return Egyszer�s�tett Tools.CVector
	 */
	public Coordinate toCoord() {
		return new Coordinate(GetX(), GetY());
	}

	/**
	 * Tools.CVector -> Tools.Coordinate �talak�t�
	 * @return az ir�ny alapj�n k�vetkez� koordin�t�k
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
//		Tools.CVector comparing = (Tools.CVector)obj;
//		return super.equals(obj) && comparing.dir == dir;
//	}
}