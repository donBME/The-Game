

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-m�rc.-2016 12:28:33
 */
public class Wall implements FieldObject {

	public Wall(){
		System.out.println("<<Wall::Create()");
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