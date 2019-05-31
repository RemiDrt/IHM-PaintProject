import java.awt.*;
import javax.swing.*;
public class AffRect  extends JPanel implements Afficheur {
  private Rectangle rec;

  public AffRect(Figure rec){
    this.rec = (Rectangle) rec;
  }
  public void dessinerFig(Graphics g){
    g.setColor(rec.getCouleur());
    int h = Math.abs((int)rec.getI(1).getY() - (int)rec.getI(0).getY());
    int w = Math.abs((int)rec.getI(1).getX() - (int)rec.getI(0).getX());
    if (this.rec.estPlein()) {
    	if((int)rec.getI(0).getX() < (int)rec.getI(1).getX()  &&  (int)rec.getI(0).getY() < (int)rec.getI(1).getY()) {
    		g.fillRect((int)rec.getI(0).getX(), (int)rec.getI(0).getY(), w, h);
    	}
    	else if((int)rec.getI(0).getX() > (int)rec.getI(1).getX()  &&  (int)rec.getI(0).getY() < (int)rec.getI(1).getY()){
    		g.fillRect((int)rec.getI(1).getX(), (int)rec.getI(0).getY(), w, h);
    	}
    	else if((int)rec.getI(0).getX() < (int)rec.getI(1).getX()  &&  (int)rec.getI(0).getY() > (int)rec.getI(1).getY()) {
    		g.fillRect((int)rec.getI(0).getX(), (int)rec.getI(1).getY(), w, h);
    	}
    	else {
    		g.fillRect((int)rec.getI(1).getX(), (int)rec.getI(1).getY(), w, h);
    	}
    }
    else {
    	if((int)rec.getI(0).getX() < (int)rec.getI(1).getX()  &&  (int)rec.getI(0).getY() < (int)rec.getI(1).getY()) {
    		g.drawRect((int)rec.getI(0).getX(), (int)rec.getI(0).getY(), w, h);
    	}
    	else if((int)rec.getI(0).getX() > (int)rec.getI(1).getX()  &&  (int)rec.getI(0).getY() < (int)rec.getI(1).getY()){
    		g.drawRect((int)rec.getI(1).getX(), (int)rec.getI(0).getY(), w, h);
    	}
    	else if((int)rec.getI(0).getX() < (int)rec.getI(1).getX()  &&  (int)rec.getI(0).getY() > (int)rec.getI(1).getY()) {
    		g.drawRect((int)rec.getI(0).getX(), (int)rec.getI(1).getY(), w, h);
    	}
    	else {
    		g.drawRect((int)rec.getI(1).getX(), (int)rec.getI(1).getY(), w, h);
    	}
    }
  }
}
