

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:32
 */
public class Button {

	private Door wire;

	public Button(Door door){
		wire = door;
		System.out.println("<<Button::Create()");
	}

	public void Action(){
		System.out.println(">>Button::Action()");
		wire.Statechanged();
        System.out.println("<<Button::Action()");
	}
}