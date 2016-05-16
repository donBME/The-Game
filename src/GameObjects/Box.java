package GameObjects;

public class Box implements FieldObject {

    /**
     * @return Hamissal tér vissza. A doboz nem öl meg.
     */
    @Override
    public boolean IsMortal() {
        return false;
    }

    /**
     * @return Hamissal tér vissza. A dobozra nem lőhető csillagkapu.
     */
    @Override
    public boolean Shootable() {
        return false;
    }

    /**
     * @return Hamissal tér vissza. A dobozra nem is lehet rálépni.
     */
    @Override
    public boolean Steppable() {
        return false;
    }

    /**
     *
     * @return Hamissal tér vissza, a doboz nem ajtó.
     */
    @Override
    public boolean isDoor() {
        return false;
    }

}