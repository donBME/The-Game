package Handlers;

import GameObjects.FieldObject;
import GameObjects.Way;
import Inventories.DataAccessPoint;
import Tools.CVector;
import Tools.Direction;

/**
 * Lépést vezérlő osztály
 */
public class StepHandler {

    private final DataAccessPoint data;
    private final boolean canCollect;//a replikátor nem vehet fel zpm-t Albert
    private boolean isCollected;

    /**
     * Konstrukor
     *
     * @param data Ahonan eléri a többi adatot.
     */
    public StepHandler(DataAccessPoint data, boolean canCollect) {
        this.data = data;
        this.canCollect = canCollect;//a replikátor nem vehet fel zpm-t Albert
        isCollected = false;
    }


    /**
     * Lépés ellenőrző fgv.
     *
     * @param where Ahova a játékos szeretne lépni
     * @return Ráléphet-e az adott koordinátára
     */
    private boolean CanStep(CVector where) {
        FieldObject fieldObject = data.fields.GetFieldObject(where);
        if (fieldObject != null && fieldObject.Steppable() && !data.isPlayerAtCoordinate(where.toCoordinate())) {
            if (data.buttons.isThere(where.toPreviousCoordinate().toCoordinate()) &&
                    data.buttons.getButtonAt(where.toPreviousCoordinate().toCoordinate()).getDoor() == fieldObject) {
                return false;
            }
            if (!data.boxes.IsThere(where)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param playerpos      A játékos pozíciója
     * @param dir            A lápás iránya
     * @param canGenerateZPM kiválthat-e a lépéssel új GameObjects.ZPM létrejöttét
     * @return A lépés utáni pozíció
     */
    public CVector NextStep(CVector playerpos, Direction dir, boolean canGenerateZPM, int ZPMs, boolean canFillAbyss) {
        if (playerpos.GetDir() != dir) {

            // Ha nem a lépés irányába néz a player, akkor arra fordul
            System.out.print("new position: " + playerpos.GetX() + "," + playerpos.GetY() + " ");
            return new CVector(playerpos.GetX(), playerpos.GetY(), dir);
        }

        CVector nextpos = playerpos.toNextCoordinate();

        if (data.stargates.isThere(nextpos)) {
            nextpos = data.stargates.stepIn(nextpos);
        }

        if (CanStep(nextpos)) {

            System.out.print("new position: " + nextpos.GetX() + "," + nextpos.GetY() + " ");

            // Gombról való lelépés figyelése
            data.buttons.EventOn(playerpos, 0);
            if (data.fields.GetFieldObject(nextpos).IsMortal()) {

                if (canFillAbyss) {
                    data.fields.addFieldObject(nextpos.toCoordinate(), new Way());
                    System.out.print("way spawned ");
                } else System.out.print("Game Over ");
                return null;
            }
            // GameObjects.ZPM felvétel figyelése
            if (data.collectables.isThere(nextpos) && canCollect) {

                data.collectables.GetCollectibleAt(nextpos);
                isCollected = true;

                if (canGenerateZPM && (ZPMs + 1) % 2 == 0) {
                    data.collectables.addToRandomCoordinate();
                }
            }
            data.buttons.EventOn(nextpos, 1);
            return nextpos;
        } else {
            System.out.print("new position: " + playerpos.GetX() + "," + playerpos.GetY() + " ");
            return playerpos;
        }
    }

    /**
     * GameObjects.ZPM felvétel ellenörzés
     *
     * @return Vett-e fel a járékos a körben GameObjects.ZPM modult
     */
    public boolean isZPMcollected() {
        boolean returnVal = isCollected;
        isCollected = false;
        return returnVal;
    }

}