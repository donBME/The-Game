import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:32
 */
public class BoxInventory {

    // Dobozok tárolója
	private HashMap<Coordinate,List<Box>> boxList;

    /**
     * Tároló konstruktor
     */
	public BoxInventory(){
        boxList = new HashMap<>();
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
     * @return Megváltoztattam a visszatérési értéket egy listára,
     * mivel nem csak egy objektum lehet egy mezön.
     */
	public List<Box> GetBox(Coordinate coord){
        return boxList.get(coord);
	}

    /**
     * Doboz hozzáadása az inventoryhoz.
     * @param coord: Doboz helye
     * @param newBox: Doboz objektum
     */
	public void addBox(Coordinate coord, Box newBox){

        // Ha nincs még doboz a koordniátán, hozzuk létre a tárolót.
        if(!boxList.keySet().contains(coord)){
            boxList.put(coord, new ArrayList<Box>());
        }

        // Adjuk hozzá a létezö tárolóhoz a dobozt.
        boxList.get(coord).add(newBox);
	}

    /**
     * Megadja, hogy a keresett koordniátán van-e doboz.
     * Lehet inkább a keresett koordinátán lévö dobozok összsúlyát kellene visszaadni.
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