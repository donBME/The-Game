package GameObjects;

public class Abyss implements FieldObject {

    /**
     * @return Igazzal tér vissza
     */
    @Override
    public boolean IsMortal() {
        return true;
    }

    /**
     * @return Hamissal tér vissza, szakadékra nem lőhető csillagkapu.
     */
    @Override
    public boolean Shootable() {
        return false;
    }

    /**
     * @return Igazzal tér vissza, a szakadékra rá lehet lépni.
     */
    @Override
    public boolean Steppable() {
        return true;
    }

    /**
     *
     * @return Hamissal tér vissza, a szakadék nem ajtó.
     */
    @Override
    public boolean isDoor() {
        return false;
    }

}