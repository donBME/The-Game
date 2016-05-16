package Tools;

/**
 * Iránnyal kiegészített vektor
 */
@SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
public class CVector extends Coordinate {

    // Kiegészített attribútumok egy mozgásiránnyal.
    private final Direction dir;

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
     * CVector -> solid Coordinate
     *
     * @return Egyszerűsített Tools.CVector
     */
    public Coordinate toCoordinate() {
        return new Coordinate(GetX(), GetY());
    }

    /**
     * Tools.CVector -> Tools.Coordinate átalakító
     *
     * @return az irány alapján következő koordináták
     */
    public CVector toNextCoordinate() {
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

    /**
     * @param obj Összehasonlítandó érték
     * @return igaz/hamis nem referencia alapján számolandó
     */
    @Override
    public boolean equals(Object obj) {
        Tools.CVector comparing = (Tools.CVector) obj;
        return this.GetX() == comparing.GetX() && this.GetY() == comparing.GetY() && this.dir == comparing.dir;
    }
}