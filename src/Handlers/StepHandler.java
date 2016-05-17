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
     * @param playerPosition      A játékos pozíciója
     * @param dir            A lápás iránya
     * @param canGenerateZPM kiválthat-e a lépéssel új GameObjects.ZPM létrejöttét
     * @return A lépés utáni pozíció
     */
    public CVector NextStep(CVector playerPosition, Direction dir, boolean canGenerateZPM, int ZPMs, boolean canFillAbyss) {
        if (playerPosition.GetDir() != dir) {

            // Ha nem a lépés irányába néz a player, akkor arra fordul
            System.out.print("new position: " + playerPosition.GetX() + "," + playerPosition.GetY() + " ");
            return new CVector(playerPosition.GetX(), playerPosition.GetY(), dir);
        }

        CVector nextPosition = playerPosition.toNextCoordinate();

        if (data.stargates.isThere(nextPosition)) {
            nextPosition = data.stargates.stepIn(nextPosition);
        }

        if (CanStep(nextPosition)) {

            System.out.print("new position: " + nextPosition.GetX() + "," + nextPosition.GetY() + " ");

            // Gombról való lelépés figyelése
            data.buttons.EventOn(playerPosition, 0);
            if (data.fields.GetFieldObject(nextPosition).IsMortal()) {

                if (canFillAbyss) {
                    data.fields.addFieldObject(nextPosition.toCoordinate(), new Way());
                    System.out.print("way spawned ");
                } else System.out.print("Game Over ");
                return null;
            }
            // GameObjects.ZPM felvétel figyelése
            if (data.collectables.isThere(nextPosition) && canCollect) {

                data.collectables.GetCollectibleAt(nextPosition);
                isCollected = true;

                if (canGenerateZPM && (ZPMs + 1) % 2 == 0) {

                    // A random ZPM miatt már ideiglenesen itt áthelyezzük a játékost
                    playerPosition.Set(nextPosition.GetX(), nextPosition.GetY());
                    data.collectables.addToRandomCoordinate();
                }
            }
            data.buttons.EventOn(nextPosition, 1);
            return nextPosition;
        } else {
            System.out.print("new position: " + playerPosition.GetX() + "," + playerPosition.GetY() + " ");
            return playerPosition;
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