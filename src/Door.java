

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:33
 */
public class Door implements FieldObject {

	private boolean open;
	
	public Door(){}

	public void Statechanged(){
		open = !open;
	}

	@Override
	public boolean IsMortal()
    {
        System.out.println("<<Door::IsMortal()");
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