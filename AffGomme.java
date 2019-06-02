import java.awt.*;
public class AffGomme implements Afficheur {
	private Gomme gomme;

	public AffGomme(Gomme gomme) {
		super();
		this.gomme = gomme;
	}
	public void dessinerFig(Graphics g) {
		g.setColor(gomme.getCouleur());
		g.fillOval((int)gomme.getI(0).getX() - 50, (int)gomme.getI(0).getY() - 50, 100, 100);
	}
	public Gomme getFigure() {
		return gomme;
	}
}
