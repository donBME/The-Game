package GameObjects;

/**
 * Ajtó objektum
 */
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
     * @return Hamis, az ajtóba lépés nem halálos.
     */
    @Override
    public boolean IsMortal() {
        return false;
    }

    /**
     * @return Hamis, az ajtóra nem lőhető csillagkapu.
     */
    @Override
    public boolean Shootable() {
        return false;
    }

    /**
     * @return Attól függően igaz/hamis, hogy az ajto nyitott vagy zárt állapotban van.
     */
    @Override
    public boolean Steppable() {
        return open;
    }

    /**
     * @return Igaz, csak az ajtóra.
     */
    @Override
    public boolean isDoor() {
        return true;
    }

}