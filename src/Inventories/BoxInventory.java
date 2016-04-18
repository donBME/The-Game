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

    // Dobozok t�rol�ja
    private Map<Coordinate, List<Box>> boxList;

    /**
     * T�rol� konstruktor
     */
	public BoxInventory(){
        boxList = new CustomHashMap();
	}

    /**
     * Egyel�re m�g nem l�tom ennek a met�dusnak mi haszna lesz, de megval�s�tom.
     * Max a v�g�n ki lesz t�r�lve.
     * @param coord T�r�lni k�v�nt mez� koordin�t�ja.
     */
	public void Delete(Coordinate coord){
        boxList.remove(coord);
	}

    /**
     * Dobozok lek�r�se a t�rol�b�l.
     * @param coord A lek�rdezni k�v�nt mez� koordin�t�ja.
     * @return A dobozlista els� eleme.
     */
	public Box GetBox(Coordinate coord){

        // Visszat�r a lista legfels� elem�vel.
        if(boxList.containsKey(coord)){
            if(boxList.get(coord).size()>0){
                Box returnValue =  boxList.get(coord).get(0);
                boxList.get(coord).remove(returnValue);

                // T�r�lj�k a kulcsot is, ha nincs alatta m�r doboz.
                if(boxList.get(coord).size()==0){
                    boxList.remove(coord);
                }

                return returnValue;
            }
            else {

                // Ha �res a lista, t�r�lj�k a hozz� tartot� kulcsot is.
                boxList.remove(coord);
                return null;
            }
        }
        else {

            // Egy�bk�nt legyen NULL a visszat�r�si �rt�k.
            return null;
        }
	}

    /**
     * Doboz hozz�ad�sa az inventoryhoz.
     * @param coord: Doboz helye
     * @param newBox: Doboz objektum
     */
	public void addBox(Coordinate coord, Box newBox){

        // Ha nincs m�g doboz a koordni�t�n, hozzuk l�tre a t�rol�t.
        if(!boxList.keySet().contains(coord)){
            boxList.put(coord, new ArrayList<>());
        }

        // Adjuk hozz� a l�tez� t�rol�hoz a dobozt.
        boxList.get(coord).add(newBox);
	}

    /**
     * Megadja, hogy a keresett koordni�t�n van-e doboz.
     * @param coord Mez� koordin�t�ja.
     * @return Igazzal t�r vissza, ha van a mez�n doboz, hamissal ha nincs.
     */
	public boolean IsThere(Coordinate coord){

        // Ha van a kiv�lasztott koordin�t�n t�rol� �s nem �res, akkor t�r vissza igazzal.
        return boxList.containsKey(coord) && boxList.get(coord).size() > 0;
	}

    /**
     * Tov�bbfejlesztett isThere f�ggv�ny.
     * @param coord A keresett koordin�t�j� mez�.
     * @return A mez�n l�v� dobozok �sszs�lya.
     */
    public int isThereV2(Coordinate coord){

        // Visszat�r a mez�n l�v� dobozok �sszs�ly�val.
        if(boxList.containsKey(coord)){
            return boxList.get(coord).size();
        }
        else {
            return 0;
        }
    }

    /**
     * A j�t�kos kez�ben l�v� dobozt helyezi a megadott koordin�t�ra.
     * Ugyanaz, mint az addBox.
     * @param coord A doboz leend� koordin�t�ja.
     * @param carriedObject A letenni k�v�nt doboz.
     */
	public void PutBox(Coordinate coord, Box carriedObject){

        // Funkcionalit�sa megegyezik az addBox-�val.
        addBox(coord,carriedObject);
	}

}