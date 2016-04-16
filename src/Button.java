

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:32
 */
public class Button {
	private Door wire;
	private int requiredWeight;

    /**
     * Gomb konstruktor.
     * @param door A gombhoz tartozó ajtó.
     * @param requiredWeightToOpen Az ajtó nyitásához szükséges súly.
     */
	public Button(Door door, int requiredWeightToOpen){

        // Belsö változók inicializálása.
		wire = door;
        requiredWeight = requiredWeightToOpen;
	}

    /**
     * Gombnyomáskor lefutó függvény.
     */
	public void Action(){
		wire.Statechanged();
	}

    /**
     *
     * @return Visszatér a nyitáshoz szükséges súllyal.
     */
    public int getRequiredWeight(){
        return requiredWeight;
    }
}