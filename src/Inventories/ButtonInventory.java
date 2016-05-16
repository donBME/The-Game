package Inventories;

import GameObjects.Button;
import Tools.Coordinate;
import Tools.CustomHashMap;

import java.util.Map;

/**
 * @author Laszlo
 * @version 1.0
 */
public class ButtonInventory {

    private Map<Coordinate, Button> buttonList;

    /**
     * Nyom�lap konstruktor.
     * L�trehozza a gombokat t�rol� kollekci�t.
     */
    public ButtonInventory() {
        buttonList = new CustomHashMap();
    }

    /**
     * Nyom�lap hozz�ad�sa a list�hoz
     *
     * @param coord  Nyom�lap helye
     * @param button A Nyom�lap
     */
    public void addButton(Coordinate coord, Button button) {
        buttonList.put(coord, button);
    }

    /**
     * Nyom�lapra t�rt�n� dobozrarak�s vagy r�l�p�s eset�n lefut� f�ggv�ny.
     *
     * @param coord         A nyom�lap koordin�t�ja
     * @param weightOnCoord A koordin�t�n tal�lhat� �sszs�ly
     */
    public void EventOn(Coordinate coord, int weightOnCoord) {
        Button button;

        if (buttonList.containsKey(coord)) {
            button = buttonList.get(coord);

            // Ajt�nyit�s kezel�se
            if (button.getRequiredWeight() > weightOnCoord) {
                button.lockDoor();
            } else {
                button.unlockDoor();
            }
        }
    }

    /**
     * Megmondja, hogy van-e egy adott koordin�t�j� ponton nyom�lap.
     *
     * @param coord A keresett koordin�t�j� mez�.
     * @return igaz / hamis
     */
    public boolean isThere(Coordinate coord) {
        return buttonList.containsKey(coord);
    }

    public boolean isOpenAt(Coordinate coordinate) {
        return buttonList.containsKey(coordinate) && !buttonList.get(coordinate).isLocked();
    }
}