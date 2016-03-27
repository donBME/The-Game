

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:32
 */
public class Abyss implements FieldObject {

	public Abyss(){
		System.out.println(">>Abyss::Abyss()");
		System.out.println("<<Abyss::Abyss()");
	}

	@Override
	public boolean IsMortal() {
        System.out.println(">>Abyss::IsMortal()");
        System.out.println("<<Abyss::IsMortal()");
		return true;
	}

	@Override
	public boolean Shootable() {
        System.out.println(">>Abyss::Shootable()");
        System.out.println("<<Abyss::Shootable()");
		return false;
	}

	@Override
	public boolean Steppable() {
        System.out.println(">>Abyss::Steppable()");
        System.out.println("<<Abyss::Steppable()");
		return true;
	}

}