package Handlers;

import GameObjects.FieldObject;
import Inventories.DataAccessPoint;
import Tools.CVector;
import Tools.StarGateColor;

/**
 * Lövést végző osztály
 */
public class ShotHandler {

    // Adattároló
    private final DataAccessPoint data;

    /**
     * Konstruktor
     *
     * @param data Adattároló
     */
    public ShotHandler(DataAccessPoint data) {
        this.data = data;
    }

    /**
     * Csillagkapu lövés
     *
     * @param shootfrom lövés iránya
     * @param color     szín
     */
    public void Shoot(CVector shootfrom, StarGateColor color) {
        FieldObject fieldObject;
        CVector checkedPos = shootfrom.toNextCoordinate();

        // Becsapódás helyének szimulálása
        while ((fieldObject = data.fields.GetFieldObject(checkedPos)).Steppable() && !data.boxes.IsThere(checkedPos)) {

            //megnézi hogy az azon mezőn le tud e lőni replikátort és le is lövi Albert

            if (checkedPos.toCoordinate().equals(data.Colonel.getPos().toCoordinate()) ||
                    (data.Jaffa != null && checkedPos.toCoordinate().equals(data.Jaffa.getPos().toCoordinate()))) {
                break;
            } else if (data.Repli != null && data.Repli.getPos() != null &&
                    checkedPos.toCoordinate().equals(data.Repli.getPos().toCoordinate())) {
                data.Repli.kill();
                System.out.println("Replicator has been shot");
                break;
            }

            checkedPos = checkedPos.toNextCoordinate();
        }

        // Lőhető-e a kiszámolt helyre csillagkapu.
        if (fieldObject.Shootable()) {
            data.stargates.Create(checkedPos, color);
            System.out.print(color.toString() + " portal at ");
        } else {
            System.out.print("failed to create portal at ");
        }
        System.out.print(checkedPos.GetX() + "," + checkedPos.GetY());
    }

}