package GameObjects;

import Tools.CVector;
import Tools.StarGateColor;

/**
 * Csillagkapu objektum
 */
public class StarGate {

    // Pozíció és szín
    private final CVector pos;
    private final StarGateColor color;

    /**
     * Csillagkapu konstruktor
     *
     * @param starGatePosition Csillagkapu helye
     * @param starGateColor    Csillagkapu színe
     */
    public StarGate(CVector starGatePosition, StarGateColor starGateColor) {
        pos = starGatePosition;
        color = starGateColor;
    }

    /**
     * Csillagkapu pozíció getter fgv.
     *
     * @return Csillagkapu helye
     */
    public CVector GetPos() {
        return pos;
    }

    /**
     * Csillagkapu szín getter
     *
     * @return szín
     */
    public StarGateColor getColor() {
        return color;
    }

}