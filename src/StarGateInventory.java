

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-m�rc.-2016 12:28:33
 */
public class StarGateInventory {

	private StarGate m_StarGate;

	public StarGateInventory(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param portalpos: csillagkapu helye
	 * @param color: szín
	 */
	public void Create(CVector portalpos, StarGateColor color){

	}

	/**
	 * 
	 * @param color: szín
	 */
	public void Delete(StarGateColor color){

	}

	public StarGate getStarGate(){
		return m_StarGate;
	}

	/**
	 * 
	 * @param from: irány
	 */
	public boolean IsThere(CVector from){
		return false;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStarGate(StarGate newVal){
		m_StarGate = newVal;
	}

	/**
	 * 
	 * @param from: irány
	 */
	public CVector StepIn(CVector from){
		return null;
	}

}