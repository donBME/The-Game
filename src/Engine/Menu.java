package Engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * Created by Laszlo on 2016. 02. 29..
 */
public class Menu {
    private ArrayList<String> mPoints;
    Menu(){
        mPoints = new ArrayList<>();
        generateMenus();
    }

    private void generateMenus() {
        mPoints.add("Új Játék");   //0
        mPoints.add("Kilépés");    //1
    }

    public int getCommand(){
        int input;
        do {
            printText();
            input = commandHandler();
        }
        while((input < 0) || (input > mPoints.size()));
        return input;
    }
    private void printText(){
        System.out.println("Kérem válasszon menüpontot!");
        for (String name : mPoints) {
            System.out.println(name);
        }
    }
    /**
     Menü irányítás kezelése
     **/
    private int commandHandler(){
        BufferedReader stringReader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        Integer inputToInt;
        try {
            input = stringReader.readLine();
            inputToInt = Integer.parseInt(input);
            return inputToInt;
        } catch (IOException e) {
            System.out.println("Hibás input");
        }
        return 0;
    }
}
