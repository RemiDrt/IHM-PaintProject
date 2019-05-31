import java.awt.*;
import javax.swing.*;
public class AffTri  extends JPanel implements Afficheur {
  private Triangle tri;

  public AffTri(Figure tri){
    this.tri = (Triangle)tri;
  }
  public void dessinerFig(Graphics g){
    g.setColor(tri.getCouleur());
	  this.tri.initXY();
	  if (this.tri.estPlein()){
		  g.fillPolygon(tri.getLesX(), tri.getLesY(), 3);
	  }
	  else {
		  g.drawPolygon(tri.getLesX(), tri.getLesY(), 3);
	  }
  }

}
