

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:33
 */
public class StarGate {

	private StarGateColor color;
	private CVector pos;

	StarGate(CVector starGatePosition, StarGateColor starGateColor){
        System.out.println(">>StarGate::StarGate(CVector starGatePosition, StarGateColor starGateColor)");
        pos = starGatePosition;
        color = starGateColor;
        System.out.println("<<StarGate::StarGate(CVector starGatePosition, StarGateColor starGateColor)");
    }
	
	public CVector GetPos(){
		return pos;
	}
	
}