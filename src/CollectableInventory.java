import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-mï¿½rc.-2016 12:28:32
 */
public class CollectableInventory {

	private Collectable m_Collectable;

	public CollectableInventory(){

	}

	public void finalize() throws Throwable {

	}

	public Collectable getCollectable(){
		return m_Collectable;
	}

	/**
	 * 
	 * @param coord: koordinÃ¡tÃ¡k
	 */
	public Collectable GetCollectableAt(Coordinate coord){
		return null;
	}

	/**
	 * @author Mate
	 * @param coord: koordináták
	 */
	public boolean IsThere(Coordinate coord){
		System.out.println(">>CollectableInventory::IsThere(Coordinate coord)");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		do{
			System.out.println("Is there a collectable item? (y/n)");
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
		System.out.println("<<CollectableInventory::IsThere(Coordinate coord)");
		return line.equals("y");
	}

	/**
	 * 
	 * @param newVal: collectable
	 */
	public void setCollectable(Collectable newVal){
		m_Collectable = newVal;
	}

}