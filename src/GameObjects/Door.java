package GameObjects;

/**
 * @author Laszlo
 * @version 1.0
 */
public class Door implements FieldObject {

    // Nyitotts�got jelz� bels� v�ltoz�.
    private boolean open;

    /**
     * �res konstruktor, alaphelyzetben az ajt� z�rt �llapotban van.
     */
    public Door() {
        open = false;
    }

    /**
     * Nyitotts�g megv�ltoztat�sa
     */
    void Statechanged() {

        // Neg�lja a nyitotts�g v�ltoz� �rt�k�t.
        open = !open;
        if (open) {
            System.out.print("door opened ");
        } else {
            System.out.print("door closed ");
        }
    }

    /**
     * @return Hamis, az ajt�ba l�p�s nem hal�los.
     */
    @Override
    public boolean IsMortal() {
        return false;
    }

    /**
     * @return Hamis, az ajt�ra nem l�het� csillagkapu.
     */
    @Override
    public boolean Shootable() {
        return false;
    }

    /**
     * @return Att�l f�gg�en igaz/hamis, hogy az ajto nyitott vagy z�rt �llapotban van.
     */
    @Override
    public boolean Steppable() {
        return open;
    }

    @Override
    public boolean isDoor() {
        return true;
    }

}