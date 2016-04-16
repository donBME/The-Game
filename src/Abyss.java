

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:32
 */
public class Abyss implements FieldObject {

	@Override
	public boolean IsMortal() {
		return true;
	}

	@Override
	public boolean Shootable() {
		return false;
	}

	@Override
	public boolean Steppable() {
		return true;
	}

}