import java.awt.*;
public class AffGomme implements Afficheur {
	private Point centre;

	public AffGomme(Point centre) {
		super();
		this.centre = centre;
	}
	public void dessinerFig(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval((int)centre.getX() - 50, (int)centre.getY() - 50, 100, 100);
	}
}
