package GameObjects;

public class Button {
    private final Door wire;
    private final int requiredWeight;

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
        return !wire.Steppable();
    }
}