package Handlers;

import GameObjects.Box;
import Inventories.DataAccessPoint;
import Tools.CVector;
import Tools.Coordinate;

/**
 * Dobozfelvételt és dobozlerakást végző osztály
 */
public class GrabHandler {

    // Adattároló
    private final DataAccessPoint data;

    /**
     * Konstruktor
     *
     * @param data Adattároló
     */
    public GrabHandler(DataAccessPoint data) {
        this.data = data;
    }

    /**
     * Doboz felvétele
     *
     * @param interactfrom Játékos helye a felvételkor
     */
    public Box Grab(CVector interactfrom) {

        // A felvenni kívánt doboz pozíciója
        Coordinate checkedPos = interactfrom.toNextCoordinate().toCoordinate();

        // Csillagkapun keresztüli dobozfelvétel lehetövé tétele
        if (data.stargates.isThere(interactfrom.toNextCoordinate())) {
            checkedPos = data.stargates.stepIn(interactfrom.toNextCoordinate()).toCoordinate();
        }

        // Van doboz a kiszemelt pozíción?
        if (data.boxes.IsThere(checkedPos)) {
            Box returnBox;

            // Felvett doboz
            returnBox = data.boxes.GetBox(checkedPos);

            if (returnBox != null) {
                System.out.print("has grabbed an item at " + checkedPos.GetX() + "," + checkedPos.GetY() + " ");
            }

            // Gomb felengedés kezelése
            data.buttons.EventOn(checkedPos, data.boxes.isThereV2(checkedPos));

            return returnBox;
        }
        System.out.print("can't interact at: " + checkedPos.GetX() + "," + checkedPos.GetY() + " ");
        return null;
    }

    /**
     * Rakható-e a kijelölt pozícióra doboz.
     *
     * @param toPosition a dobozrakás pozíciója
     */
    private boolean canPut(Coordinate toPosition) {
        if (data.fields.GetFieldObject(toPosition).Steppable()) {
            if (!data.collectables.isThere(toPosition) && !data.fields.GetFieldObject(toPosition).isDoor()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Dobozlerakás
     *
     * @param interactfrom  Játékos helye a felvételkor.
     * @param carriedobject Játékos kezében lévö doboz.
     */
    public boolean put(CVector interactfrom, Box carriedobject) {

        // A koordináta, melyre a játékos a dobozt tenni szeretné.
        CVector checkedPos = interactfrom.toNextCoordinate();

        // Csillagkapun keresztüli dobozletétel.
        if (data.stargates.isThere(checkedPos)) {
            checkedPos = data.stargates.stepIn(checkedPos);
        }

        // Rakható-e a kiszemelt koordinátájú pontra doboz?
        if (canPut(checkedPos)) {
            data.boxes.PutBox(checkedPos.toCoordinate(), carriedobject);

            System.out.print("has put an item at " + checkedPos.GetX() + "," + checkedPos.GetY() + " ");

            // Szakadékba dobás esetén a doboz semmisüljön meg.
            if (data.fields.GetFieldObject(checkedPos.toCoordinate()).IsMortal()) {
                System.out.println("box destroyed ");
                data.boxes.Delete(checkedPos.toCoordinate());
            }

            // Ajtónyitás kezelése
            data.buttons.EventOn(checkedPos, data.boxes.isThereV2(checkedPos));

            return true;
        } else {
            System.out.println("can't interact at " + checkedPos.GetX() + "," + checkedPos.GetY() + " ");
            return false;
        }
    }

}