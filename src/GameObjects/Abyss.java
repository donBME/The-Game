package GameObjects;

/**
 * @author Laszlo
 * @version 1.0
 */
public class Abyss implements FieldObject {

    /**
     * @return Igazzal tér vissza, a szakadékba esés halálos.
     */
    @Override
    public boolean IsMortal() {
        return true;
    }

    /**
     * @return Hamissal tér vissza, szakadékra nem löhetö csillagkapu.
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

}