package Players;

import GameObjects.Box;
import Graphics.Notifiable;
import Handlers.GrabHandler;
import Handlers.ShotHandler;
import Handlers.StepHandler;
import Tools.CVector;
import Tools.Direction;
import Tools.StarGateColor;

/**
 * Játékos osztály
 */
public abstract class Player {
    private final GrabHandler hand;
    private final StepHandler leg;
    private final ShotHandler gun;
    private final boolean canGenerateZPM;
    private final boolean canFillAbyss;
    private CVector pos;
    // Belső tárolók
    private int ZPMs;
    private Box handfull;
    private Notifiable notifiable;

    /**
     * Players.Player konstruktor
     *
     * @param shothandler    Fegyver vezérlő.
     * @param grabhandler    GameObjects.Box vezérlő.
     * @param stephandler    Lépés vezérlő.
     * @param canGenerateZPM Tud-e a játékos GameObjects.ZPM-et generálni.
     * @param canFillAbyss   Szakadékba lépés esetén az betöltődik-e.
     * @param sx             Kezdeti pozíció: x
     * @param sy             Kezdeti pozíció: y
     */
    Player(ShotHandler shothandler, GrabHandler grabhandler, StepHandler stephandler, boolean canGenerateZPM, boolean canFillAbyss, int sx, int sy) {
        gun = shothandler;
        hand = grabhandler;
        leg = stephandler;
        ZPMs = 0;
        this.canGenerateZPM = canGenerateZPM;
        this.canFillAbyss = canFillAbyss;
        Direction dir = Direction.North;
        pos = new CVector(sx, sy, dir);
    }

    /**
     * Müvelet végrehajtása
     *
     * @param fromThisPosition Erröl a pozícióról akarunk müveletet végrehajtani.
     */
    public void interact(CVector fromThisPosition) {
        if (pos != null) {
            if (handfull == null) {
                handfull = hand.grab(fromThisPosition);
            } else {
                boolean success = hand.put(fromThisPosition, handfull);
                if (success) {
                    handfull = null;
                }
            }
        }
        System.out.println();

        if (notifiable != null) {
            notifiable.notifyView();
        }
    }


    /**
     * Csillagkapu tövés
     *
     * @param color Csilagkapu színe
     */
    public void shoot(StarGateColor color) {
        if (handfull == null && pos != null) {
            gun.Shoot(pos, color);
            System.out.println();

            if (notifiable != null) {
                notifiable.notifyView();
            }
        }
    }

    /**
     * Lépés
     *
     * @param toDir a l?p?s ir?nya
     */
    public void step(Direction toDir) {
        if (pos != null) {
            pos = leg.NextStep(pos, toDir, canGenerateZPM, ZPMs, canFillAbyss);
        } else {
            System.out.print("Game over");
        }

        if (leg.isZPMcollected()) {
            ZPMs++;
        }
        System.out.println();

        if (notifiable != null) {
            notifiable.notifyView();
        }
    }

    /**
     * Players.Player helyének lekérésére
     *
     * @return Players.Player pozíciója és iránya
     */
    public CVector getPos() {
        return pos;
    }

    /**
     * @return van-e doboz a játékosnál
     */
    public boolean hasBox() {
        return (handfull != null);
    }

    /**
     * Játékos megölése
     */
    public void kill() {
        this.pos = null;
    }

    /**
     * Játékos feliratkoztatása egy nézetre
     *
     * @param notifiable értesíthető interfész
     */
    public void subscribe(Notifiable notifiable) {
        this.notifiable = notifiable;
    }
}