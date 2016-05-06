package GameObjects;

/**
 * @author Laszlo
 * @version 1.0
 */
public class Box implements FieldObject {

    /**
     * @return Hamissal t�r vissza. A doboz nem �l meg.
     */
    @Override
    public boolean IsMortal() {
        return false;
    }

    /**
     * @return Hamissal t�r vissza. A dobozra nem l�het� csillagkapu.
     */
    @Override
    public boolean Shootable() {
        return false;
    }

    /**
     * @return Hamissal t�r vissza. A dobozra nem is lehet r�l�pni.
     */
    @Override
    public boolean Steppable() {
        return false;
    }

}