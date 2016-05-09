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
    private Controller controller;

    private int OBJECT_WIDTH, OBJECT_HEIGHT;

    public MyView(){
        JFrame jFrame = new JFrame();
        jFrame.setSize(600,600);
        jFrame.setVisible(true);
        controller = new Controller(this);
        controller.loadMap(10);

        jFrame.addKeyListener(controller);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void notifyView() {
        System.out.println("This view has been notified!");
    }

    @Override
    public void setData(DataAccessPoint data) {
        this.data = data;
    }

    public void drawMenu(){

    }
}
