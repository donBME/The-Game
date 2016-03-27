import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:33
 */
public class StarGateInventory {

	private StarGate m_StarGate;
    private List<StarGate> starGates;
	private QuestionAssistant questionAssistant = new QuestionAssistant();

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
	 * @param from: irány
	 */
	public boolean IsThere(CVector from){
		System.out.println(">>StarGateInventoy::IsThere(CVectro from)");
        boolean thereIs = questionAssistant.ask("Is there a StarGate? (y/n)");
		System.out.println("<<StarGateInventoy::IsThere(CVectro from)");
		return thereIs;
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