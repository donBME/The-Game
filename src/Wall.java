

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:33
 */
public class Wall implements FieldObject {

	public Wall(){

	}

	public void finalize() throws Throwable {

	}

	@Override
	public boolean IsMortal() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Shootable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Steppable() {
		// TODO Auto-generated method stub
		return false;
	}

}