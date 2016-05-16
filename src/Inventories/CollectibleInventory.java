package Inventories;

import GameObjects.Collectible;
import GameObjects.ZPM;
import Tools.Coordinate;
import Tools.CustomHashMap;

import java.util.Map;
import java.util.Random;

/**
 * Gyűjthető elemek tárolója
 */
@SuppressWarnings("unchecked")
public class CollectibleInventory {

    private final Map<Coordinate, Collectible> collectibles;
    // Belső változók
    private DataAccessPoint data;

    /**
     * Gyűjthetö elemeket tároló osztály konstruktora.
     * Létrehozza a tárolót.
     */
    public CollectibleInventory() {
        collectibles = new CustomHashMap();
    }

    /**
     * A GameObjects.ZPM generáláshoz ismernie kell a fieldObjectek és box-ok helyét.
     *
     * @param dataAccessPoint Központi adattároló
     */
    public void setData(DataAccessPoint dataAccessPoint) {
        data = dataAccessPoint;
    }

    /**
     * @param coordinate Koordináta, ahonnan felvesszük a Collactible-t
     */
    public void GetCollectibleAt(Coordinate coordinate) {
        collectibles.get(coordinate).Collect();
        collectibles.remove(coordinate);
    }

    /**
     * @param coordinate Ahol megnézzük, hogy van-e GameObjects.Collectible
     */
    public boolean isThere(Coordinate coordinate) {
        return collectibles.get(coordinate) != null;
    }

    /**
     * @param coordinate     Ahova tesszük
     * @param newCollectible Új collectible
     */
    public void addCollectible(Coordinate coordinate, Collectible newCollectible) {
        collectibles.put(coordinate, newCollectible);
    }

    /**
     * Gyűjthetö elem hozzáadása a pálya egy random pontjára.
     */
    public void addToRandomCoordinate() {

        // Segédváltozók inicializálása
        Coordinate maxCoords = data.fields.getMaxCoordinates();
        int maxX = maxCoords.GetX();
        int maxY = maxCoords.GetY();
        int x, y;
        Random random = new Random();

        x = random.nextInt(maxX + 1);
        y = random.nextInt(maxY + 1);
        Coordinate coordinate = new Coordinate(x, y);

		/* Csak olyan helyre hozhatunk létre új gyüjthetö elemet, amelyre:
        - a játékos is ráléphet
		- nincs rajta már egy korábban létrehozott gyüjthetö elem
		- nincs a koordinátán játékos
		- nincs rajta nyomólap
		- nem szakadék
		- nincs rajta doboz

		Ha ezek közül valamelyik teljesül, új koordinátát generálunk.
		*/
        while (!data.fields.GetFieldObject(coordinate).Steppable()
                || collectibles.containsKey(coordinate)
                || data.isPlayerAtCoordinate(coordinate)
                || data.buttons.isThere(coordinate)
                || data.fields.GetFieldObject(coordinate).IsMortal()
                || data.boxes.IsThere(coordinate)) {
            x = random.nextInt(maxX + 1);
            y = random.nextInt(maxY + 1);
            coordinate.Set(x, y);
        }

        // GameObjects.ZPM modul elhelyezése a számolt pozícióra.
        collectibles.put(coordinate, new ZPM());

        System.out.print("ZPM spawned ");
    }

    /**
     * @return Jelenleg a pályán lévő ZPM modulok száma
     */
    public int ZPMCount() {
        return collectibles.size();
    }
}