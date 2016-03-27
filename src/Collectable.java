

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:32
 */
public class Collectable {

	public Collectable(){
		System.out.println(">>Collectable::Collectable()");
		System.out.println("<<Collectable::Collectable()");
	}

	public void Collect(){
		System.out.println(">>Collectable::Collect()");
		System.out.println("<<Collectable::Collect()");
	}

	public int HowMany(){
        System.out.println(">>Collectable::HowMany()");
        System.out.println("<<Collectable::HowMany()");
		return 0;
	}

}