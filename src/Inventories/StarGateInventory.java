package Inventories;

import GameObjects.StarGate;
import Tools.CVector;
import Tools.StarGateColor;

import static Tools.Direction.*;
import static Tools.StarGateColor.*;

/**
 * @author Laszlo
 * @version 1.0
 */
public class StarGateInventory {

    // K?l?nb?z? sz?n? csillagkapuk
    private StarGate yellow, blue, red, green;

    /**
     * Konstruktor
     */
    public StarGateInventory() {
    }

    /**
     * Adott sz?n? csillagkapu l?trehoz?sa, adott poz?ci?n.
     *
     * @param portalpos Csillagkapu helye
     * @param color     Csillagkapu sz?ne
     */
    public void Create(CVector portalpos, StarGateColor color) {
        switch (color) {
            case Yellow:
                Delete(Yellow);
                yellow = new StarGate(EnterPos(portalpos), color);
                break;
            case Blue:
                Delete(Blue);
                blue = new StarGate(EnterPos(portalpos), color);
                break;
            case Red:
                Delete(Red);
                red = new StarGate(EnterPos(portalpos), color);
                break;
            case Green:
                Delete(Green);
                green = new StarGate(EnterPos(portalpos), color);
                break;
        }
    }

    /**
     * Adott sz?n? csillagkapu t?rl?se
     *
     * @param color T?r?lni k?v?nt csillagkapu sz?ne
     */
    private void Delete(StarGateColor color) {
        switch (color) {
            case Yellow:
                yellow = null;
                break;
            case Blue:
                blue = null;
                break;
            case Red:
                red = null;
                break;
            case Green:
                green = null;
                break;
        }
    }

    /**
     * @param pos A player l?p?s?nek helye
     * @return A bel?p?s ir?ny?nak megfelel? ir?ny? poz?ci?
     * Amikor Bel?p?nk egy csillagkapuba
     * akkor az a l?p?s ir?ny?nak
     * ellenkez? ir?nyb?l ny?lik.
     */
    private CVector EnterPos(CVector pos) {
        switch (pos.GetDir()) {
            case North:
                return new CVector(pos.GetX(), pos.GetY(), South);
            case South:
                return new CVector(pos.GetX(), pos.GetY(), North);
            case East:
                return new CVector(pos.GetX(), pos.GetY(), West);
            case West:
                return new CVector(pos.GetX(), pos.GetY(), East);
            default:
                return null;
        }
    }

    /**
     * @param from ir?ny
     * @return A megadott koordin?t?n van-e csillagkapu
     */
    public boolean IsThere(CVector from) {
        CVector f = EnterPos(from);
        return yellow != null && yellow.GetPos().equals(f)
                || blue != null && blue.GetPos().equals(f)
                || red != null && red.GetPos().equals(f)
                || green != null && green.GetPos().equals(f);
    }

	
	public StarGate GetStarGate(CVector from){
    	if(yellow != null && yellow.GetPos().equals(from)){
    		return yellow;
    	} else if(blue != null && blue.GetPos().equals(from)){
    		return blue;
    	} else if(red != null && red.GetPos().equals(from)){
    		return red;
    	} else if(green != null && green.GetPos().equals(from)){
    		return green;
    	} else return null;
    }
	
    /**
     * @param exitGatePos A f?r?gj?rat kij?rat?nak poz?ci?ja
     * @return A f?regj?rat kijarata el?tti koordin?ta
     */
    private CVector ExitPos(CVector exitGatePos) {
        switch (exitGatePos.GetDir()) {
            case North:
                return new CVector(exitGatePos.GetX(), exitGatePos.GetY() + 1, North);
            case South:
                return new CVector(exitGatePos.GetX(), exitGatePos.GetY() - 1, South);
            case East:
                return new CVector(exitGatePos.GetX() + 1, exitGatePos.GetY(), East);
            case West:
                return new CVector(exitGatePos.GetX() - 1, exitGatePos.GetY(), West);
            default:
                return null;
        }
    }


    /**
     * @param from A bel?p?s ir?nya
     * @return A f?regj?rat el?tti poz?ci?
     */
    public CVector StepIn(CVector from) {
        CVector f = EnterPos(from);
        if (yellow != null && yellow.GetPos().equals(f)) {
            if (blue != null) {
                return ExitPos(blue.GetPos());
            } else return from;
        } else if (blue != null && blue.GetPos().equals(f)) {
            if (yellow != null) {
                return ExitPos(yellow.GetPos());
            } else return from;
        } else if (red != null && red.GetPos().equals(f)) {
            if (green != null) {
                return ExitPos(green.GetPos());
            } else return from;
        } else if (green != null && green.GetPos().equals(f)) {
            if (red != null) {
                return ExitPos(red.GetPos());
            } else return from;
        } else {
            return from;
        }
    }

}