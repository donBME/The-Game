package GameObjects;

/**
 * ZPM modul osztály
 */
public class ZPM implements Collectible {

    /**
     * Üres konstruktor
     */
    public ZPM() {
    }

    /**
     * GameObjects.ZPM begyűjtésekor lefutó fgv.
     */
    @Override
    public void Collect() {
        System.out.print("ZPM collected ");
    }
}