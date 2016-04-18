

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:33
 */
public class Door implements FieldObject {

	// Nyitottságot jelzö belsö változó.
	private boolean open;

	/**
	 * Üres konstruktor, alaphelyzetben az ajtó zárt állapotban van.
	 */
	public Door(){ open = false;
	}

	/**
	 * Nyitottság megváltoztatása
	 */
	public void Statechanged() {

		// Negálja a nyitottság változó értékét.
		open = !open;
		if (open){
			System.out.println("door opened");
		}
		else {
			System.out.println("door closed");
		}
	}

	/**
	 *
	 * @return Hamis, az ajtóba lépés nem halálos.
	 */
	@Override
	public boolean IsMortal() { return false;
	}

	/**
	 *
	 * @return Hamis, az ajtóra nem löhetö csillagkapu.
	 */
	@Override
	public boolean Shootable() {
        return false;
	}

	/**
	 *
	 * @return Attól függöen igaz/hamis, hogy az ajto nyitott vagy zárt állapotban van.
	 */
	@Override
	public boolean Steppable() {
        return open;
	}

}