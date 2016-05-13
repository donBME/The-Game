package Tools;

import Graphics.MyView;
import Graphics.Notifiable;
import Handlers.GameHandler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Laszlo
 * @version 1.0
 */

public class Controller implements KeyListener {
    private GameHandler gameHandler;

    // 0   1   2   3   4   5   6
    private final char[] colonelKeys = {'w','a','s','d','q','e','f'};
    private final char[] jaffaKeys =   {'8','4','5','6','7','9','2'};

    private final int[] menuKeys = {10, 37, 38, 39, 40};

    public static void main(String[] args) {
        MyView view  = new MyView();
    }

    public Controller(Notifiable currentView){
        gameHandler = new GameHandler(new LoadField(), currentView);
    }

    private void handleColonel(char command){
        String executableCommand = "Colonel ";

        int id = 0;
        while (command != colonelKeys[id]) {
            id++;
        }

        continueExecute(executableCommand, id);
    }

    private void handleJaffa(char command){
        String executableCommand = "Jaffa ";

        int id = 0;
        while (command != jaffaKeys[id]) {
            id++;
        }

        continueExecute(executableCommand, id);
    }

    private void continueExecute(String command, int id) {
        switch (id){
            case 0:
                command += "Step North";
                break;
            case 1:
                command += "Step West";
                break;
            case 2:
                command += "Step South";
                break;
            case 3:
                command += "Step East";
                break;
            case 4:
                switch (command){
                    case "Colonel ":
                        command += "Shoot Yellow";
                        break;
                    case "Jaffa ":
                        command += "Shoot Red";
                        break;
                }
                break;
            case 5:
                switch (command){
                    case "Colonel ":
                        command += "Shoot Blue";
                        break;
                    case "Jaffa ":
                        command += "Shoot Green";
                        break;
                }
                break;
            case 6:
                command += "Interact";
                break;
        }

        gameHandler.executeCommand(command);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    /**
     * Felengedéskor adjuk ki az utasítást.
     * @param e Lenyomott gomb esemény
     */
    @Override
    public void keyReleased(KeyEvent e) {

        for (char colonelKey : colonelKeys) {
            if (e.getKeyChar() == colonelKey){
                handleColonel(e.getKeyChar());
                break;
            }
        }

        for (char jaffaKey : jaffaKeys) {
            if (e.getKeyChar() == jaffaKey){
                handleJaffa(e.getKeyChar());
                break;
            }
        }
    }

    public void loadMap(int mapID) {
        gameHandler.runMap(mapID);
    }

}
