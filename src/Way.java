

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:33
 */
public class Way implements FieldObject {
	
	public Way(){}
	
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
        return true;
	}

}