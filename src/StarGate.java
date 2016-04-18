

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:33
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
	StarGate(CVector starGatePosition, StarGateColor starGateColor){
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