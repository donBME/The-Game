

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:33
 */
public class Way implements FieldObject {
	
	public Way(){
		System.out.println(">>Way::Way()");
		System.out.println("<<Way::Way()");
	}
	
	@Override
	public boolean IsMortal() {
        System.out.println(">>Way::IsMortal()");
        System.out.println("<<Way::IsMortal()");
        return false;
	}

	@Override
	public boolean Shootable() {
        System.out.println(">>Way::Shootable()");
        System.out.println("<<Way::Shootable()");
        return false;
	}

	@Override
	public boolean Steppable() {
        System.out.println(">>Way::Steppable()");
        System.out.println("<<Way::Steppable()");
        return true;
	}

}