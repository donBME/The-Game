import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	 * @author Mate
	 * @param from: ir�ny
	 */
	public boolean IsThere(CVector from){
		System.out.println(">>StarGateInventoy::IsThere(CVectro from)");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		do{
			System.out.println("Is there a StarGate? (y/n)");
			try {
				line = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(!(line.equals("y")|| line.equals("n")));
		/*try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("<<StarGateInventoy::IsThere(CVectro from)");
		return line.equals("y");
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
		System.out.println(">>StarGateInventory::StepIn(CVector from)");
		System.out.println("<<StarGateInventory::StepIn(CVector from)");
		return null;
	}

}