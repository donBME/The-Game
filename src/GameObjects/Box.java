package GameObjects;

/**
 * @author Laszlo
 * @version 1.0
 */
public class Box implements FieldObject {

    /**
     *
	 * @return Hamissal tér vissza. A doboz nem öl meg.
	 */
	@Override
	public boolean IsMortal() {
        return false;
	}

    /**
     *
	 * @return Hamissal tér vissza. A dobozra nem löhetö csillagkapu.
	 */
	@Override
	public boolean Shootable() {
        return false;
	}

    /**
     *
	 * @return Hamissal tér vissza. A dobozra nem is lehet rálépni.
	 */
	@Override
	public boolean Steppable() {
        return false;
	}

}