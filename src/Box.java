

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:32
 */
public class Box implements FieldObject {

	public Box(){
		System.out.println("<<Box::Create()");
	}
	
	@Override
	public boolean IsMortal() {
		return false;
	}

	@Override
	public boolean Shootable() {
		return false;
	}

	@Override
	public boolean Steppable() {
		return false;
	}

}