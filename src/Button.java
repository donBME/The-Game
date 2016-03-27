

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:32
 */
public class Button {

	private Door wire;

	public Button(){

	}

	public void Action(){

	}

	public Door getwire(){
		return wire;
	}

	/**
	 * 
	 * @param newVal: ajtó
	 */
	public void setwire(Door newVal){
		wire = newVal;
	}

}