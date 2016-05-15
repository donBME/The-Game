package GameObjects;

/**
 * @author Laszlo
 * @version 1.0
 */
public class Abyss implements FieldObject {

    /**
     * @return Igazzal t?r vissza, a szakad?kba es?s hal?los.
     */
    @Override
    public boolean IsMortal() {
        return true;
    }

    /**
     * @return Hamissal t?r vissza, szakad?kra nem l?het? csillagkapu.
     */
    @Override
    public boolean Shootable() {
        return false;
    }

    /**
     * @return Igazzal t?r vissza, a szakad?kra r? lehet l?pni.
     */
    @Override
    public boolean Steppable() {
        return true;
    }

}