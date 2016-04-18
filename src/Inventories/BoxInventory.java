package Inventories;

import GameObjects.Box;
import Tools.Coordinate;
import Tools.CustomHashMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Laszlo
 * @version 1.0
 */
public class BoxInventory {

    // Dobozok tárolója
    private Map<Coordinate, List<Box>> boxList;

    /**
     * Tároló konstruktor
     */
	public BoxInventory(){
        boxList = new CustomHashMap();
	}

    /**
     * Egyelöre még nem látom ennek a metódusnak mi haszna lesz, de megvalósítom.
     * Max a végén ki lesz törölve.
     * @param coord Törölni kívánt mezö koordinátája.
     */
	public void Delete(Coordinate coord){
        boxList.remove(coord);
	}

    /**
     * Dobozok lekérése a tárolóból.
     * @param coord A lekérdezni kívánt mezö koordinátája.
     * @return A dobozlista elsö eleme.
     */
	public Box GetBox(Coordinate coord){

        // Visszatér a lista legfelsö elemével.
        if(boxList.containsKey(coord)){
            if(boxList.get(coord).size()>0){
                Box returnValue =  boxList.get(coord).get(0);
                boxList.get(coord).remove(returnValue);

                // Töröljük a kulcsot is, ha nincs alatta már doboz.
                if(boxList.get(coord).size()==0){
                    boxList.remove(coord);
                }

                return returnValue;
            }
            else {

                // Ha üres a lista, töröljük a hozzá tartotó kulcsot is.
                boxList.remove(coord);
                return null;
            }
        }
        else {

            // Egyébként legyen NULL a visszatérési érték.
            return null;
        }
	}

    /**
     * Doboz hozzáadása az inventoryhoz.
     * @param coord: Doboz helye
     * @param newBox: Doboz objektum
     */
	public void addBox(Coordinate coord, Box newBox){

        // Ha nincs még doboz a koordniátán, hozzuk létre a tárolót.
        if(!boxList.keySet().contains(coord)){
            boxList.put(coord, new ArrayList<>());
        }

        // Adjuk hozzá a létezö tárolóhoz a dobozt.
        boxList.get(coord).add(newBox);
	}

    /**
     * Megadja, hogy a keresett koordniátán van-e doboz.
     * @param coord Mezö koordinátája.
     * @return Igazzal tér vissza, ha van a mezön doboz, hamissal ha nincs.
     */
	public boolean IsThere(Coordinate coord){

        // Ha van a kiválasztott koordinátán tároló és nem üres, akkor tér vissza igazzal.
        return boxList.containsKey(coord) && boxList.get(coord).size() > 0;
	}

    /**
     * Továbbfejlesztett isThere függvény.
     * @param coord A keresett koordinátájú mezö.
     * @return A mezön lévö dobozok összsúlya.
     */
    public int isThereV2(Coordinate coord){

        // Visszatér a mezön lévö dobozok összsúlyával.
        if(boxList.containsKey(coord)){
            return boxList.get(coord).size();
        }
        else {
            return 0;
        }
    }

    /**
     * A játékos kezében lévö dobozt helyezi a megadott koordinátára.
     * Ugyanaz, mint az addBox.
     * @param coord A doboz leendö koordinátája.
     * @param carriedObject A letenni kívánt doboz.
     */
	public void PutBox(Coordinate coord, Box carriedObject){

        // Funkcionalitása megegyezik az addBox-éval.
        addBox(coord,carriedObject);
	}

}