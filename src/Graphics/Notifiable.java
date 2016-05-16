package Graphics;

import Inventories.DataAccessPoint;

/**
 * A nézetekhez szükséges interface
 */
public interface Notifiable {

    /**
     * Nézet értesítése a belső állapot megváltozásáról
     */
    void notifyView();

    /**
     * Az adattároló referencia beállítása
     *
     * @param dataAccessPoint adattároló referencia
     */
    void setData(DataAccessPoint dataAccessPoint);
}
