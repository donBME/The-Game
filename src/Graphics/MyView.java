package Graphics;

import Inventories.DataAccessPoint;
import Tools.Controller;

import javax.swing.*;

/**
 * @author Laszlo
 * @version 1.0
 */

public class MyView implements Notifiable{

    private DataAccessPoint data;

    public MyView(){
        JFrame jFrame = new JFrame();
        jFrame.setSize(600,600);
        jFrame.setVisible(true);
        jFrame.addKeyListener(new Controller());
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public MyView(DataAccessPoint data){
        this.data = data;
    }

    @Override
    public void notifyView() {

    }

    public void drawMenu(){

    }
}
