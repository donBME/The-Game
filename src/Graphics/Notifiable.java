package Graphics;

import Inventories.DataAccessPoint;

/**
 * @author Laszlo
 * @version 1.0
 */

public interface Notifiable {

    void notifyView();

    void setData(DataAccessPoint dataAccessPoint);
}
