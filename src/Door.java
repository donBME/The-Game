

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:33
 */
public class Door implements FieldObject {

	private boolean open;
	
	public Door(){
		System.out.println(">>Door::Door()");
		System.out.println("<<Door::Door()");
	}

	public void Statechanged(){
		System.out.println(">>Door::Statechanged()");
		open = !open;
		System.out.println("<<Door::Statechanged()");
	}

	@Override
	public boolean IsMortal()
    {
        System.out.println(">>Door::IsMortal()");
        System.out.println("<<Door::IsMortal()");
        return false;
	}

	@Override
	public boolean Shootable() {
        System.out.println(">>Door::Shootable()");
        System.out.println("<<Door::Shootable()");
        return false;
	}

	@Override
	public boolean Steppable() {
        System.out.println(">>Door::Steppable()");
        System.out.println("<<Door::Steppable()");
        return open;
	}

}