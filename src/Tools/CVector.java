package Tools;

/**
 * @author Laszlo
 * @version 1.0
 */

public class CVector extends Coordinate {

	// KiegÃ©szÃ­tettÃ¼k az attribÃºtumokat egy mozgÃ¡si irÃ¡nnyal is.
	private Direction dir;

	/**
	 * Ã‰rtÃ©kadÃ³ kostruktor
	 *
	 * @param sx x koordinÃ¡ta
	 * @param sy y koordinÃ¡ta
	 * @param sd irÃ¡ny
	 */
	public CVector(int sx, int sy, Direction sd) {
		Set(sx,sy);
		dir = sd;
	}

	/**
	 * IrÃ¡ny getter fgv.
	 * @return MozgÃ¡si irÃ¡ny
	 */
	public Direction GetDir(){
		return dir;
	}

	/**
	 * 
	 * @param sx x koordinÃ¡ta
	 * @param sy y koordinÃ¡ta
	 * @param sd irÃ¡ny
	 */
	public void SetD(int sx, int sy, Direction sd){
		Set(sx,sy);
		dir = sd;
	}

	/**
	 * Ã�tkonvertÃ¡lja a CVectort egy sima Tools.Coordinate osztÃ¡lyra, irÃ¡ny nÃ©lkÃ¼l
	 * @return EgyszerÅ±sÃ­tett Tools.CVector
	 */
	public Coordinate toCoord() {
		return new Coordinate(GetX(), GetY());
	}

	/**
	 * Tools.CVector -> Tools.Coordinate Ã¡talakÃ­tÃ³
	 * @return az irÃ¡ny alapjÃ¡n kÃ¶vetkezÅ‘ koordinÃ¡tÃ¡k
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