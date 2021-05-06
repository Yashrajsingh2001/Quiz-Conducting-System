package qna;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JWindow;

public class Splash extends JWindow
{
   Image splashScreen;
   ImageIcon imageIcon;
   
   public Splash(String img) 
   {
	  splashScreen = Toolkit.getDefaultToolkit().getImage(img);
      imageIcon = new ImageIcon(splashScreen);
      setSize(imageIcon.getIconWidth(),imageIcon.getIconHeight());
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      int x = (screenSize.width-getSize().width)/2;
      int y = (screenSize.height-getSize().height)/2;
      setLocation(x,y);
      setVisible(true);
   }
   
   public void paint(Graphics g)
   {
      super.paint(g);
      g.drawImage(splashScreen, 0, 0, this);
   }
   
   public static void main(String[]args) {}
   
}
