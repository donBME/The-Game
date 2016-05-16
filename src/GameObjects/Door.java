package GameObjects;

public class Door implements FieldObject {

    // Nyitottságot jelző belső változó.
    private boolean open;

    /**
     * Üres konstruktor, alaphelyzetben az ajtó zárt állapotban van.
     */
    public Door() {
        open = false;
    }

    /**
     * Nyitottság megváltoztatása
     */
    void Statechanged() {

        // Negálja a nyitottság változó értékét.
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