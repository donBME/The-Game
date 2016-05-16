package Inventories;

import GameObjects.Box;
import Tools.Coordinate;
import Tools.CustomHashMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Dobozokat tároló osztály
 */
@SuppressWarnings("unchecked")
public class BoxInventory {

    // Dobozok tárolója
    private final Map<Coordinate, List<Box>> boxList;

    /**
     * Tároló konstruktor
     */
    public BoxInventory() {
        boxList = new CustomHashMap();
    }

    /**
     * @param coordinate Törölni kívánt mező koordinátája
     */
    public void Delete(Coordinate coordinate) {
        boxList.remove(coordinate);
    }

    /**
     * @param coordinate A lekérdezni kívánt mező koordinátája.
     * @return A dobozlista első eleme.
     */
    public Box GetBox(Coordinate coordinate) {

        // Visszatér a lista legfelső elemével.
        if (boxList.containsKey(coordinate)) {
            if (boxList.get(coordinate).size() > 0) {
                Box returnValue = boxList.get(coordinate).get(0);
                boxList.get(coordinate).remove(returnValue);

                // Töröljük a kulcsot is, ha nincs alatta már doboz.
                if (boxList.get(coordinate).size() == 0) {
                    boxList.remove(coordinate);
                }

                return returnValue;
            } else {

                // Ha üres a lista, töröljük a hozzá tartozó kulcsot is.
                boxList.remove(coordinate);
                return null;
            }
        } else {

            // Egyébként legyen NULL a visszatérési érték.
            return null;
        }
    }

    /**
     * Doboz hozzáadása az inventoryhoz.
     *
     * @param coordinate: Doboz helye
     * @param newBox:     Doboz objektum
     */
    public void addBox(Coordinate coordinate, Box newBox) {

        // Ha nincs még doboz a koordinátán, hozzuk létre a tárolót.
        if (!boxList.keySet().contains(coordinate)) {
            boxList.put(coordinate, new ArrayList<>());
        }

        // Adjuk hozzá a létező tárolóhoz a dobozt.
        boxList.get(coordinate).add(newBox);
    }

    /**
     * Megadja, hogy a keresett koordinátán van-e doboz.
     *
     * @param coordinate Mező koordinátája.
     * @return Igazzal tér vissza, ha van a mezőn doboz, hamissal ha nincs.
     */
    public boolean IsThere(Coordinate coordinate) {

        // Ha van a kiválasztott koordinátán tároló és nem üres, akkor tér vissza igazzal.
        return boxList.containsKey(coordinate) && boxList.get(coordinate).size() > 0;
    }

    /**
     * Továbbfejlesztett isThere függvény.
     *
     * @param coordinate A keresett koordinátájú mező.
     * @return A mezőn lévő dobozok összsúlya.
     */
    public int isThereV2(Coordinate coordinate) {

        // Visszatér a mezőn lévő dobozok összsúlyával.
        if (boxList.containsKey(coordinate)) {
            return boxList.get(coordinate).size();
        } else {
            return 0;
        }
    }

    /**
     * A játékos kezében lévő dobozt helyezi a megadott koordinátára.
     * Ugyanaz, mint az addBox.
     *
     * @param coordinate    A doboz leendő koordinátája.
     * @param carriedObject A letenni kívánt doboz.
     */
    public void PutBox(Coordinate coordinate, Box carriedObject) {

        // Funkcionalitása megegyezik az addBox-éval.
        addBox(coordinate, carriedObject);
    }

}