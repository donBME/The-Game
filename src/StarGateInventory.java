import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:33
 */
public class StarGateInventory {

    private StarGate yellow,blue;
	private QuestionAssistant questionAssistant = new QuestionAssistant();

	
	public StarGateInventory(){
		System.out.println(">>StarGateInventory::StarGateInventory()");
		System.out.println("<<StarGateInventory::StarGateInventory()");
	}
	/**
	 * 
	 * @param portalpos: csillagkapu helye
	 * @param color: szín
	 */
	public void Create(CVector portalpos, StarGateColor color){
        System.out.println(">>StarGateInventory::Create(CVector portalpos, StarGateColor color)");
        System.out.println("<<StarGateInventory::Create(CVector portalpos, StarGateColor color)");
	}

	/**
	 * 
	 * @param color: szín
	 */
	public void Delete(StarGateColor color){
        System.out.println(">>StarGateInventory::Delete(StarGateColor color)");
        System.out.println("<<StarGateInventory::Delete(StarGateColor color)");
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
	 * @param from: irány
	 */
	public CVector StepIn(CVector from){
		System.out.println(">>StarGateInventory::StepIn(CVector from)");
		System.out.println("<<StarGateInventory::StepIn(CVector from)");
		return null;
	}

}