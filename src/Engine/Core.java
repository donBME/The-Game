package Engine;

import Graphics.GUI;

/*
 * Created by Laszlo on 2016. 02. 29..
 */
public class Core {
    GUI gui;
    Menu menu;

    Core(){
        loadMenu();
    }

    public static void main(String[] args)
    {
        new Core();
    }

    private void loadMenu(){
        menu = new Menu();
        int input = menu.getCommand();
        switch (input){
            case 0:break;
            case 1: break;
            default:break;
        }
    }

}
