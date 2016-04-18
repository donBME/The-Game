package GameObjects;

import Tools.CVector;
import Tools.StarGateColor;

/**
 * @author Laszlo
 * @version 1.0
 */
public class StarGate {

	// Belső attribútumok
	private StarGateColor color;
	private CVector pos;

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
	 * @return Csillagkapu helye
	 */
	public CVector GetPos(){
		return pos;
	}
	
}