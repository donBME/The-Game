

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:32
 */
public class Abyss implements FieldObject {

	public Abyss(){
		System.out.println("<<Abyss::Create()");
	}

	@Override
	public boolean IsMortal() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean Shootable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Steppable() {
		// TODO Auto-generated method stub
		return true;
	}

}