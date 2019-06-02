import java.awt.Graphics;

public class AffText implements Afficheur {
	private Text t;
	public AffText(Text t) {
		this.t = t;
	}
	@Override
	public Text getFigure() {
		// TODO Auto-generated method stub
		return t;
	}

	@Override
	public void dessinerFig(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(t.getCouleur());
	    g.drawString(t.getStr(), (int)t.getI(0).getX(), (int)t.getI(0).getY());
	}
	public Text getText() {
		return t;
	}
	public void setText(Text t) {
		this.t = t;
	}

}
