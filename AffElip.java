import java.awt.*;
import javax.swing.*;
public class AffElip  extends JPanel implements Afficheur {
  private Elipse el;

  public Elipse getFigure() {
	return el;
}
public AffElip(Figure el){
    this.el = (Elipse)el;
  }
  public void dessinerFig(Graphics g){
	  if(el.estComplet()) {
		  g.setColor(el.getCouleur());
		    System.out.println(g.getColor() + "oui");
			  this.el.initWH();
			  if (this.el.estPlein()) {
				  g.fillOval(((int)el.getI(0).getX()) - (el.getWidth()/2), ((int)el.getI(0).getY()) - (el.getHeight()/2), el.getWidth(), el.getHeight());
			  }
			  else {
				  g.drawOval(((int)el.getI(0).getX()) - (el.getWidth()/2), ((int)el.getI(0).getY()) - (el.getHeight()/2), el.getWidth(), el.getHeight());
			  }
	  } 
  }
}
