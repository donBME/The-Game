import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-mï¿½rc.-2016 12:28:32
 */
public class BoxInventory {

	private Box m_Box;

	public BoxInventory(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * @author Mate
	 * @param coord: koordináták
	 */
	public void Delete(Coordinate coord){
		System.out.println(">>BoxInventory::Delete(Coordinate coord)");
		System.out.println("<<BoxInventory::Delete(Coordinate coord)");
	}

	/**
	 * 
	 * @param coord: koordinÃ¡tÃ¡k
	 */
	public Box GetBox(Coordinate coord){
		return null;
	}

	public Box getBox(){
		return m_Box;
	}

	/**
	 * @author Mate
	 * @param coord: koordináták
	 */
	public boolean IsThere(Coordinate coord){
		System.out.println(">>BoxInventory::IsThere(Coordinate coord)");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		do{
			System.out.println("Is there a box? (y/n)");
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
		System.out.println("<<BoxInventory::IsThere(Coordinate coord)");
		return line.equals("y");
	}

	/**
	 * @author Mate
	 * @param coord: koordináták
	 * @param carriedobject: doboz
	 */
	public void PutBox(Coordinate coord, Box carriedobject){
		System.out.println(">>BoxInventory::PutBox(Coordinate coord, Box carriedobject)");
		System.out.println("<<BoxInventory::PutBox(Coordinate coord, Box carriedobject)");
	}

	/**
	 * 
	 * @param newVal: doboz
	 */
	public void setBox(Box newVal){
		m_Box = newVal;
	}

}