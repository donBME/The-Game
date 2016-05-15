package Graphics;
 
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
 
     
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
            Image image = ImageIO.read(new File(path));
            g.drawImage(image, x, y, width, height, null);
             
        } catch (IOException ex) 
        {
            System.out.println("Hiba a kirajolas kozben!");
            }
 
        }
}
     
