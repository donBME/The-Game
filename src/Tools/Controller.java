package Tools;

import Graphics.Basic2DView;
import Graphics.Notifiable;
import Handlers.GameHandler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Controller osztály a billentyűzetről történő vezérléshez
 */
public class Controller implements KeyListener {
    private final GameHandler gameHandler;

    //                                   0   1   2   3   4   5   6
    private final char[] colonelKeys = {'w', 'a', 's', 'd', 'q', 'e', 'f'};
    private final char[] jaffaKeys = {'8', '4', '5', '6', '7', '9', '2'};

    /**
     * Konstruktor
     *
     * @param currentView nézet referencia
     */
    public Controller(Notifiable currentView) {
        gameHandler = new GameHandler(new LoadField(), currentView);
    }

    /**
     * Az alkalmazás belépési pontja, létrehoz egy nézetet, ami példányosít mindent a működéshez.
     *
     * @param args main agrumentumok
     */
    public static void main(String[] args) {
        new Basic2DView();
    }

    /**
     * Colonel utasítások végrehajtása
     *
     * @param command kapott utasítás
     */
    private void handleColonel(char command) {
        String executableCommand = "Colonel ";

        int id = 0;
        while (command != colonelKeys[id]) {
            id++;
        }

        continueExecute(executableCommand, id);
    }

    /**
     * Jaffa utasítások végrehajtása
     *
     * @param command kapott parancs
     */
    private void handleJaffa(char command) {
        String executableCommand = "Jaffa ";

        int id = 0;
        while (command != jaffaKeys[id]) {
            id++;
        }

        continueExecute(executableCommand, id);
    }

    /**
     * Végrehajtás folytatása
     *
     * @param command eredeti parancs
     * @param id      értelmezett utasítás kódja
     */
    private void continueExecute(String command, int id) {
        switch (id) {
            case 0:
                command += "step North";
                break;
            case 1:
                command += "step West";
                break;
            case 2:
                command += "step South";
                break;
            case 3:
                command += "step East";
                break;
            case 4:
                switch (command) {
                    case "Colonel ":
                        command += "shoot Yellow";
                        break;
                    case "Jaffa ":
                        command += "shoot Red";
                        break;
                }
                break;
            case 5:
                switch (command) {
                    case "Colonel ":
                        command += "shoot Blue";
                        break;
                    case "Jaffa ":
                        command += "shoot Green";
                        break;
                }
                break;
            case 6:
                command += "interact";
                break;
        }

        gameHandler.executeCommand(command);

    }

    /**
     * Billentyű lenyomásakor lefutó függvény
     *
     * @param e a lenyomott billenytű eseménye
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Billenytű nyomvatartásakor lafutó függvény
     *
     * @param e a lenyomott billentyű eseménye
     */
    @Override
    public void keyPressed(KeyEvent e) {
    }

    /**
     * Felengedéskor adjuk ki az utasítást.
     *
     * @param e Lenyomott gomb esemény
     */
    @Override
    public void keyReleased(KeyEvent e) {

        for (char colonelKey : colonelKeys) {
            if (e.getKeyChar() == colonelKey) {
                handleColonel(e.getKeyChar());
                break;
            }
        }

        for (char jaffaKey : jaffaKeys) {
            if (e.getKeyChar() == jaffaKey) {
                handleJaffa(e.getKeyChar());
                break;
            }
        }
    }

    /**
     * Pálya betöltési utasítás a nézet felől a Model felé
     *
     * @param mapID betöltendő pálya sorszáma
     */
    public void loadMap(int mapID) {
        gameHandler.runMap(mapID);
    }

}
