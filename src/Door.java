

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:33
 */
public class Door implements FieldObject {

	private boolean open;
	
	public Door(){ open = false; }

	public void Statechanged(){
		open = !open;
		if (open){
			System.out.println("door opened");
		}
		else {
			System.out.println("door closed");
		}
	}

	@Override
	public boolean IsMortal() { return false; }

	@Override
	public boolean Shootable() {
        return false;
	}

	@Override
	public boolean Steppable() {
        return open;
	}

}