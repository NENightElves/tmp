import java.awt.*;
import javax.swing.*;

public class wuziqi 
{
	public static void main(String[] args) 
	{
        JFrame f=new JFrame("Îå×ÓÆå");
        f.setSize(340,360);
        Mypanl p=new Mypanl();
        p.setBackground(Color.BLACK);
        f.add(p);
        f.setVisible(true);
    }
    static class Mypanl extends JPanel
    {
    	public void paint(Graphics g) 
    	{
    		g.setColor(Color.lightGray);
    		g.fill3DRect(10, 10, 300, 300, true);
    		g.setColor(Color.black);
    		for (int i = 1; i < 16; i++) 
    		{
    			g.drawLine(20, 20 * i, 300, 20 * i);
    			g.drawLine(20 * i, 20, 20 * i, 300);
    		}
    	}
    }

}
