

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:32
 */
public class Box implements FieldObject {

	public Box(){
		System.out.println(">>Box::Box()");
		System.out.println("<<Box::Box()");
	}
	
	@Override
	public boolean IsMortal() {
        System.out.println(">>Box::IsMortal()");
        System.out.println("<<Box::IsMortal()");
        return false;
	}

	@Override
	public boolean Shootable() {
        System.out.println(">>Box::Shootable()");
        System.out.println("<<Box::Shootable()");
        return false;
	}

	@Override
	public boolean Steppable() {
        System.out.println(">>Box::Steppable()");
        System.out.println("<<Box::Steppable()");
        return false;
	}

}