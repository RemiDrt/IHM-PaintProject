import java.awt.*;
import javax.swing.*;
public class AffCerc  extends JPanel implements Afficheur {
  private Cercle cer;
  public AffCerc(Figure cer){
    this.cer = (Cercle)cer;
  }
  public Cercle getFigure() {
	return cer;
}
public void dessinerFig(Graphics g){
    g.setColor(cer.getCouleur());
	  this.cer.initWH();
	  if(this.cer.estPlein()) {
		  g.fillOval(((int)cer.getI(0).getX()) - cer.getRay(), ((int)cer.getI(0).getY()) - cer.getRay(), cer.getRay()*2, cer.getRay()*2);
	  }
	  else {
		  g.drawOval(((int)cer.getI(0).getX()) - cer.getRay(), ((int)cer.getI(0).getY()) - cer.getRay(), cer.getRay()*2, cer.getRay()*2);
	  }
  }
}
