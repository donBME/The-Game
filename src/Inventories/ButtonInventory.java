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
	 * Nyomólap konstruktor.
	 * Létrehozza a gombokat tároló kollekciót.
	 */
	public ButtonInventory(){
        buttonList = new CustomHashMap();
	}

	/**
	 * Nyomólap hozzáadása a listához
	 * @param coord Nyomólap helye
	 * @param button A Nyomólap
	 */
	public void addButton(Coordinate coord, Button button){
		buttonList.put(coord, button);
	}

	/**
	 * Nyomólapra történö dobozrarakás vagy rálépés esetén lefutó függvény.
	 * @param coord A nyomólap koordinátája
	 * @param weightOnCoord A koordinátán található összsúly
	 */
	public void EventOn(Coordinate coord, int weightOnCoord){
		Button button;

		if (buttonList.containsKey(coord)){
			button = buttonList.get(coord);

			// Ajtónyitás kezelése
			if (button.getRequiredWeight() > weightOnCoord){
				button.lockDoor();
			}
			else {
				button.unlockDoor();
			}
		}
	}

	/**
	 * Megmondja, hogy van-e egy adott koordinátájú ponton nyomólap.
	 * @param coord A keresett koordinátájú mezö.
	 * @return igaz / hamis
     */
	public boolean isThere(Coordinate coord){
		return buttonList.containsKey(coord);
	}

}