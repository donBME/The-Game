package Tools;

/**
 * @author Laszlo
 * @version 1.0
 */

public class CVector extends Coordinate {

    // Kiegészített attribútumok egy mozgásiránnyal.
    private Direction dir;

    /**
     * Értékadó kostruktor
     *
     * @param sx x koordináta
     * @param sy y koordináta
     * @param sd irány
     */
    public CVector(int sx, int sy, Direction sd) {
        Set(sx, sy);
        dir = sd;
    }

    /**
     * Irány getter fgv.
     *
     * @return Mozgási irány
     */
    public Direction GetDir() {
        return dir;
    }

    /**
     * @param sx x koordináta
     * @param sy y koordináta
     * @param sd irány
     */
    public void SetD(int sx, int sy, Direction sd) {
        Set(sx, sy);
        dir = sd;
    }

    /**
     * Átkonvertálja a CVectort egy sima Tools.Coordinate osztályra, irány nélkül.
     *
     * @return Egyszer?sített Tools.CVector
     */
    public Coordinate toCoord() {
        return new Coordinate(GetX(), GetY());
    }

    /**
     * Tools.CVector -> Tools.Coordinate átalakító
     *
     * @return az irány alapján következ? koordináták
     */
    public CVector toNextCoord() {
        switch (dir) {
            case North:
                return new CVector(GetX(), GetY() + 1, dir);
            case South:
                return new CVector(GetX(), GetY() - 1, dir);
            case East:
                return new CVector(GetX() + 1, GetY(), dir);
            case West:
                return new CVector(GetX() - 1, GetY(), dir);
        }
        return this;
    }

	@Override
		public boolean equals(Object obj) {
			Tools.CVector comparing = (Tools.CVector)obj;
			return this.GetX() == comparing.GetX() && this.GetY() == comparing.GetY() && this.dir == comparing.dir;
		}
}