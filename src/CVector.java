

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:32
 */
public class CVector extends Coordinate {

	private Direction dir;

	public Direction GetDir(){
		return dir;
	}

	/**
	 * 
	 * @param sx: x koordináta
	 * @param sy: y koordináta
	 * @param sd: irány
	 */
	public void SetD(int sx, int sy, Direction sd){
		Set(sx,sy);
		dir = sd;
	}

}