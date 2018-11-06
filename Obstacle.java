import java.awt.Graphics;
import java.awt.Color;

public class Obstacle
{
   private boolean cond;
   private int obPos, obY, obWidth;
   
   public Obstacle(boolean cond, int obPos)
   {
      this.cond = cond;
      this.obPos = obPos;
      obWidth = (int)(Math.random()*40+30);
      if(cond == true)
         obY = 380;
      if(cond == false)
         obY = 200;
   }
   
   public void drawOb(Graphics g)
   {
      g.setColor(Color.black);
      
      if(cond == true)
         g.fillRect(obPos,0,obWidth,200);
      else
         g.fillRect(obPos,400,obWidth,200);     
   }
   
   public void update(){obPos-=5;}
   
   public int getX(){
      return obPos;}
   public int getY(){
      return obY;}
   public int getWidth(){
      return obWidth;}
}