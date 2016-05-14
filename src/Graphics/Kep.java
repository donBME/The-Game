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
 
     
public class Kep extends JComponent
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
            System.out.println("Hiba a kirajolas kozben!");
            }
 
        }
}
     
