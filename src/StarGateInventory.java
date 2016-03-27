import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-m�rc.-2016 12:28:33
 */
public class StarGateInventory {

    private List<StarGate> starGates;
	private QuestionAssistant questionAssistant = new QuestionAssistant();

	
	public StarGateInventory(){
		System.out.println("<<StarGateInventory::Create()");
	}
	/**
	 * 
	 * @param portalpos: csillagkapu helye
	 * @param color: sz�n
	 */
	public void Create(CVector portalpos, StarGateColor color){

	}

	/**
	 * 
	 * @param color: sz�n
	 */
	public void Delete(StarGateColor color){

	}

	/**
	 * @author Mate
	 * @param from: ir�ny
	 */
	public boolean IsThere(CVector from){
		System.out.println(">>StarGateInventoy::IsThere(CVectro from)");
        boolean thereIs = questionAssistant.ask("Is there a StarGate? (y/n)");
		System.out.println("<<StarGateInventoy::IsThere(CVectro from)");
		return thereIs;
	}

	/**
	 * 
	 * @param from: ir�ny
	 */
	public CVector StepIn(CVector from){
		System.out.println(">>StarGateInventory::StepIn(CVector from)");
		System.out.println("<<StarGateInventory::StepIn(CVector from)");
		return null;
	}

}