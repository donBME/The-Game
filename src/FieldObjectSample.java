import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Mate
 * @version 1.0
 * @created 23-03-2016 
 */
public class FieldObjectSample implements FieldObject{

	/**
	* Hence there is no specified object map, this sample-class is intended to simulate all structural behaviour.
	*/

    /**
     *  1 - true
     * -1 - false
     *  0 - undefined
    */
    private int mortality=0,shootability=0, stepability=0;
    private QuestionAssistant questionAssistant = new QuestionAssistant();


	@Override
	public boolean IsMortal() {
		System.out.println(">>FieldObject::IsMortal()");
        if (questionAssistant.ask("Is the FieldObject mortal? (y/n)"))
            mortality = 1;
        else
            mortality = -1;
		System.out.println("<<FieldObject::IsMortal()");
		return mortality == 1;
	}

	@Override
	public boolean Shootable() {
        System.out.println(">>FieldObject::Shootable()");
        if(questionAssistant.ask("Is the FieldObject shootable? (y/n)"))
            shootability = 1;
        else
            shootability = -1;
        System.out.println("<<FieldObject::Shootable()");
        return shootability == 1;
	}

	@Override
	public boolean Steppable() {
        System.out.println(">>FieldObject::Steppable()");
        if(questionAssistant.ask("Is the FieldObject steppable? (y/n)"))
            stepability = 1;
        else
            stepability = -1;
        System.out.println("<<FieldObject::Steppable()");
        return stepability == 1;
	}

}
