import java.awt.*;
import javax.swing.*;
public class AffSeg  extends JPanel implements Afficheur {
  private Segment seg;
  public AffSeg(Figure seg){
    this.seg = (Segment)seg;
  }
  public void dessinerFig(Graphics g){
    g.setColor(seg.getCouleur());
    g.drawLine((int)seg.getI(0).getX(), (int)seg.getI(0).getY(), (int)seg.getI(1).getX(), (int)seg.getI(1).getY());
  }
}
