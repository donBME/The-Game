package draw;
 
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
 
/**
 *
 * @web http://java-buddy.blogspot.com/
 */
public class JavaTestSwing {
     
    static JFrameWin jFrameWindow;
     
    public static class Kep extends JComponent
    {
    	String path;
    	int  x, y, width, height;
    	public Kep(String path, int x, int y, int width, int height)
    	{
    		this.path=path;
    		this.x=x;
    		this.y=y;
    		this.width=width;
    		this.height=height;
    	}
        @Override
        protected void paintComponent(Graphics g) 
        {
            try 
            {
                Image image = ImageIO.read(this.getClass().getResource(path));
                g.drawImage(image, x, y, width, height, null);
                 
            } catch (IOException ex) 
            {
                Logger.getLogger(JavaTestSwing.class.getName()).log(Level.SEVERE, null, ex);
            }
 
        }
    }
     
    public static class JFrameWin extends JFrame
    {
        public JFrameWin()
        {
            this.setTitle("java-buddy.blogspot.com");
            this.setSize(300, 300);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
            Kep myComponent = new Kep("Ok.png",40,0,50,50);
            this.add(myComponent);
        }
    }
 
    public static void main(String[] args){
        Runnable doSwingLater = new Runnable()
        {
             
            @Override
            public void run() {
                jFrameWindow = new JFrameWin();
                jFrameWindow.setVisible(true);
            }
        };
         
        SwingUtilities.invokeLater(doSwingLater);
         
    }
 
}
