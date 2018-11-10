
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

public class gameCode extends JPanel implements MouseListener, KeyListener, ActionListener, FocusListener
{
   private boolean[] keysDown = new boolean[500];
   private ArrayList<Obstacle> obs = new ArrayList<Obstacle>();

   private int xPos = 50;
   private int yPos = 380;
   private int obPos = (int)(Math.random()*1000+ 4000);
   private boolean posCond = true;
   private boolean moveCond = false;
   private boolean obCond;
   
   public gameCode()
   {
      addKeyListener(this);
      addMouseListener(this);
      setFocusable(true);
      setFocusTraversalKeysEnabled(false);
   }
   
   public void paint(Graphics g)
   {
      generateObs();
      collision();
      right();
        
      addBackground(g);
      
      draw(g);
      g.setColor(Color.blue);
      g.fillRect(xPos,yPos,20,20);
   }
   
   public void collision()
   {
      for(Obstacle obj: obs)
      {
         for(int c = 0;c <= obj.getWidth();c++)
         {
            if(xPos == obj.getX() && yPos == obj.getY())
               break;
         }
      }
   }
   
   public void right()
   {
      for(Obstacle obj: obs)
      {
         obj.update();
         if(obj.getX() < 0)
            obs.remove(obj);
      }
   }
   
   public void generateObs()
   {
      int size = (int)(Math.random()*20+15);
      while(size > 0)
      {
         int binNum = (int)(Math.random()*2);
         
         obs.add(new Obstacle(binNum == 0, obPos));
         
         obPos+=(int)(Math.random()*150 + 200);
         size--;
      }  
   }
   
   public void draw(Graphics g)
   {
      for(Obstacle obj: obs)
         obj.drawOb(g);
   }
   
   public void addBackground(Graphics g)
   {
      g.setColor(Color.lightGray);
      g.fillRect(0,0,2000,2000);
      g.setColor(Color.darkGray);
      g.fillRect(0,0,2000,200);
      g.fillRect(0,400,2000,400);
   }
   
   public void flip()
   {
      posCond = !posCond;
      
      if(posCond == false)
         moveUp();
      
      if(posCond == true)
         moveDown();
   }
   public void moveUp()
   {
      moveCond = true;
      while(moveCond)
      {
         yPos-=1;
         if(yPos == 200)
         {
            moveCond = false; 
         }
      }
   }
   public void moveDown()
   {
      moveCond = true;
      while(moveCond)
      {
         yPos+=1;
         if(yPos == 380)
         {
            moveCond = false; 
         }
      }
   }
   
   
   @Override
   public void actionPerformed(ActionEvent e){ repaint();}
   
   @Override
   public void keyTyped(KeyEvent e){}
   
   @Override
   public void keyPressed(KeyEvent e)
   {
      int keyCode = e.getKeyCode();
      keysDown[keyCode] = true;
      if(keyCode ==  KeyEvent.VK_SPACE)
      {
         flip();
      }
   }
   
   @Override
   public void keyReleased(KeyEvent c)
   {
      int keyCode = c.getKeyCode();
      keysDown[keyCode] = false;
   }
   
   @Override
   public void mouseClicked(MouseEvent e)
   {
      if(e.getButton() == MouseEvent.BUTTON1)
         flip();
   }
   
   @Override
   public void mouseEntered(MouseEvent e){}
   
   @Override
   public void mouseExited(MouseEvent e){}
   
   @Override
   public void mousePressed(MouseEvent e){}
   
   @Override
   public void mouseReleased(MouseEvent e){}
   
   @Override
   public void focusGained(FocusEvent e){}
   
   @Override
   public void focusLost(FocusEvent e)
   {
      for (int counter = 0; counter < keysDown.length; counter++)
         keysDown[counter] = false;
   }
}
