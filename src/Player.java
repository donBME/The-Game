

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-m�rc.-2016 12:28:33
 */
public class Player {

	private Box handfull;
	private CVector pos;
	private GrabHandler hand;
	private StepHandler leg;
	private ShotHandler gun;

	public Player(){
		
	}

	public void finalize() throws Throwable {

	}

	public ShotHandler getgun(){
		return gun;
	}

	public GrabHandler gethand(){
		return hand;
	}

	public StepHandler getleg(){
		return leg;
	}

	public CVector getpos(){
		return pos;
	}


	/**
	 * 
	 * @author Mate
	 * @param toDir: ir�ny
	 */
	public void Interact(Direction toDir){
		System.out.println(">>Player::Interact(Direction toDir)");
		hand.Put(null, handfull);
		System.out.println("<<Player::Interact(Direction toDir)");
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setgun(ShotHandler newVal){
		gun = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void sethand(GrabHandler newVal){
		hand = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setleg(StepHandler newVal){
		leg = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setpos(CVector newVal){
		pos = newVal;
	}

	/**
	 * 
	 * @param toDir: irány
	 * @param color: szín
	 */
	public void Shoot(Direction toDir, StarGateColor color){

	}

	/**
	 * mozgás iránnyal hívódik meg, tovobbátja a vezérlést a StepHandlernek, aki
	 * válaszul megadja melyik mezőn, milyen irányba nézve kell a játékosnak lennie
	 * 
	 * @param toDir: irány
	 */
	public void Step(Direction toDir){

	}

}