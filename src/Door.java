

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:33
 */
public class Door implements FieldObject {

	private boolean open;

	public void Statechanged(){
		System.out.println(">>Door::Statechanged()");
		open = !open;
		System.out.println("<<Door::Statechanged()");
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
		return open;
	}

}