package Inventories;

import GameObjects.Button;
import Tools.Coordinate;
import Tools.CustomHashMap;

import java.util.Map;

/**
 * Nyomólapokat tároló osztály
 */
@SuppressWarnings("unchecked")
public class ButtonInventory {

    private final Map<Coordinate, Button> buttonList;

    /**
     * Nyomólap konstruktor.
     * Létrehozza a gombokat tároló kollekciót.
     */
    public ButtonInventory() {
        buttonList = new CustomHashMap();
    }

    /**
     * Nyomólap hozzáadása a listához
     *
     * @param coordinate Nyomólap helye
     * @param button     A Nyomólap
     */
    public void addButton(Coordinate coordinate, Button button) {
        buttonList.put(coordinate, button);
    }

    /**
     * Nyomólapra történő dobozrarakás vagy rálépés esetén lefutó függvény.
     *
     * @param coordinate         A nyomólap koordinátája
     * @param weightOnCoordinate A koordinátán található összsúly
     */
    public void EventOn(Coordinate coordinate, int weightOnCoordinate) {
        Button button;

        if (buttonList.containsKey(coordinate)) {
            button = buttonList.get(coordinate);

            // Ajtónyitás kezelése
            if (button.getRequiredWeight() > weightOnCoordinate) {
                button.lockDoor();
            } else {
                button.unlockDoor();
            }
        }
    }

    /**
     * Megmondja, hogy van-e egy adott koordinátájú ponton nyomólap.
     *
     * @param coordinate A keresett koordinátájú mező.
     * @return igaz / hamis
     */
    public boolean isThere(Coordinate coordinate) {
        return buttonList.containsKey(coordinate);
    }

    /**
     * Megadja, hogy van-e nyitott állapontban lévő gomb a keresett koordinátán
     *
     * @param coordinate keresett koordináta
     * @return igaz / hamis
     */
    public boolean isOpenAt(Coordinate coordinate) {
        return buttonList.containsKey(coordinate) && !buttonList.get(coordinate).isLocked();
    }

    /**
     * Visszaad egy megadott koordináátán lévő nyomólapot
     * @param coordinate keresett koordináta
     * @return keresett nyomólap
     */
    public Button getButtonAt(Coordinate coordinate) {
        if (buttonList.containsKey(coordinate)) {
            return buttonList.get(coordinate);
        }

        return null;
    }
}