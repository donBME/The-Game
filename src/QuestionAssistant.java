import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Laszlo on 2016. 03. 27..
 */
public class QuestionAssistant {
    public boolean ask(String question){
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = null;
        do{
            System.out.println(question);
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }while(!(line.equals("y")|| line.equals("n")));
        return line.equals("y");
    }
}
