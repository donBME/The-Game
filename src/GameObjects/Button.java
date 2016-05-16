package GameObjects;

/**
 * @author Laszlo
 * @version 1.0
 */
public class Button {
    private Door wire;
    private int requiredWeight;

    /**
     * Gomb konstruktor.
     *
     * @param door                 A gombhoz tartozó ajtó.
     * @param requiredWeightToOpen Az ajtó nyitásához szükséges súly.
     */
    public Button(Door door, int requiredWeightToOpen) {

        // Belsö változók inicializálása.
        wire = door;
        requiredWeight = requiredWeightToOpen;
    }

    /**
     * Gombnyomáskor lefutó függvény.
     */
    public void Action() {
        wire.Statechanged();
    }

    /**
     * Ajtó zárása
     */
    public void lockDoor() {
        if (wire.Steppable()) {
            wire.Statechanged();
        }
    }

    /**
     * Ajtó nyitása
     */
    public void unlockDoor() {
        if (!wire.Steppable()) {
            wire.Statechanged();
        }
    }

    /**
     * @return Visszatér a nyitáshoz szükséges súllyal.
     */
    public int getRequiredWeight() {
        return requiredWeight;
    }

    public boolean isLocked() {
        return wire.Steppable();
    }
}