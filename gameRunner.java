
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.Point;

public class gameRunner
{
   public static void main(String[] args)
   {
      BufferedImage cursorImage = new BufferedImage(16,16,BufferedImage.TYPE_INT_ARGB);
      Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage, new Point(0, 0),"blank cursor");
      JFrame frame = new JFrame();
      frame.setBounds(150,50,800,600);
      frame.setTitle("Magnet Man");
      frame.setResizable(true);
      gameCode game = new gameCode();
      frame.add(game);
      frame.getContentPane().setCursor(blankCursor);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      while(true)
      {
         game.repaint();
      }
   }
}
