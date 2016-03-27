

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:33
 */
public class Wall implements FieldObject {

	public Wall(){
		System.out.println(">>Wall::Wall()");
		System.out.println("<<Wall::Wall()");
	}
	
	@Override
	public boolean IsMortal() {
        System.out.println(">>Wall::IsMortal()");
        System.out.println("<<Wall::IsMortal()");
		return false;
	}

	@Override
	public boolean Shootable() {
        System.out.println(">>Wall::Shootable()");
        System.out.println("<<Wall::Shootable()");
        return false;
	}

	@Override
	public boolean Steppable() {
        System.out.println(">>Wall::Steppable()");
        System.out.println("<<Wall::Steppable()");
        return false;
	}

}