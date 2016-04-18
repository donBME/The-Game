import java.util.HashMap;

/**
 * Created by Laszlo on 2016. 04. 16..
 */
public class CustomHashMap extends HashMap {

    /**
     * Egyedi HashMap kulcskereső
     * @param key Coordinate típusú kulcs
     * @return igaz/hamis
     */
    @Override
    public boolean containsKey(Object key) {
        Coordinate customKey = (Coordinate)key;

        /* Mivel a HashMap a kulcsokat referencia alapján keresi,
           megpróbáljuk egy kicsit megtéveszteni.
         */
        for (Object iteratingKey : keySet()){
            Coordinate coordKey = (Coordinate)iteratingKey;
            if(coordKey.equals(customKey)){
                return true;
            }
        }
        return false;
    }


    /**
     * Értékközpontosított get
     * @param key Coordiate típusú kulcs
     * @return Object
     */
    @Override
    public Object get(Object key) {
        Coordinate customKey = (Coordinate)key;

        for (Object iteratingKey : keySet()){
            Coordinate coordKey = (Coordinate)iteratingKey;
            if (coordKey.equals(customKey)) {
                customKey = coordKey;
            }
        }

        return super.get(customKey);

    }

    /**
     *
     * @param key Törlendő kulcs
     * @return Törölt kulcs
     */
    @Override
    public Object remove(Object key) {
        Coordinate customKey = (Coordinate)key;

        for (Object iteratingKey : keySet()){
            Coordinate coordKey = (Coordinate)iteratingKey;
            if (coordKey.equals(customKey)){
                customKey = coordKey;
            }
        }
        return super.remove(customKey);
    }
}
