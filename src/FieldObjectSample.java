import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Mate
 * @version 1.0
 * @created 23-03-2016 
 */
public class FieldObjectSample implements FieldObject{

	@Override
	public boolean IsMortal() {
		System.out.println(">>FieldObject::IsMortal()");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		do{
			System.out.println("Is the FieldObject mortal? (y/n)");
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
		System.out.println("<<FieldObject::IsMortal()");
		return line.equals("y");
	}

	@Override
	public boolean Shootable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Steppable() {
		System.out.println(">>FieldObject::Steppable()");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		do{
			System.out.println("Is the FieldObject steppable? (y/n)");
			try {
				line = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(!(line.equals("y")|| line.equals("n")));
		System.out.println("<<FieldObject::Steppable()");
		/*try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return line.equals("y");
	}

}
