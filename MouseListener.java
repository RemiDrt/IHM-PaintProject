import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

public class MouseListener extends MouseAdapter {
	private VueFig vue;
	public MouseListener(VueFig v) {
		super();
		this.vue = v;
	}
	public void mouseClicked(MouseEvent e) {
		if (vue.getMode() == 0) {
			System.out.println(vue.getMode());
			if(vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).getTaille() <= 1) {
				System.out.println("nb point:"+vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).getTaille());
				vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).ajouter(new Point(e.getX(), e.getY()));//la derniére figure de la liste
				System.out.println(new Point(e.getX(), e.getY()).toString());
				System.out.println("nb point:"+ vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).getTaille());
				if(vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).getTaille() == 2) {
					AffSeg aff = new AffSeg(vue.getFigs().getFigs(vue.getFigs().getTaille() - 1));
					System.out.println("new aff");
					this.vue.getAffs().add(aff);
					this.vue.getPanneau().repaint();
				}
			}
			else {
				//JOptionPane.showMessageDialog(null, "Nouveau segment", "NOUVELLE FIGURE", JOptionPane.INFORMATION_MESSAGE);
				vue.getFigs().ajouter(new Segment(vue.getCouleur()));
				System.out.println("new Seg");
				vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).ajouter(new Point(e.getX(), e.getY()));//la derniére figure de la liste
				System.out.println(new Point(e.getX(), e.getY()).toString());
				System.out.println("nb point:"+ vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).getTaille());
			}
		}

		else if (vue.getMode() == 1 || vue.getMode() == 2) {
			System.out.println(vue.getMode());
			if(vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).getTaille() <= 1) {
				System.out.println("nb point:"+ vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).getTaille());
				vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).ajouter(new Point(e.getX(), e.getY()));//la derniére figure de la liste
				System.out.println(new Point(e.getX(), e.getY()).toString());
				System.out.println("nb point:"+ vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).getTaille());
				if(vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).getTaille() == 2) {
					AffRect aff = new AffRect(vue.getFigs().getFigs(vue.getFigs().getTaille() - 1));
					System.out.println("new aff");
					this.vue.getAffs().add(aff);
					this.vue.getPanneau().repaint();
				}
			}
			else {
				//JOptionPane.showMessageDialog(null, "Nouveau Rectangle", "NOUVELLE FIGURE", JOptionPane.INFORMATION_MESSAGE);
				if(vue.getMode() == 1) {
					vue.getFigs().ajouter(new Rectangle(false, vue.getCouleur()));
					System.out.println("new rect");
					vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).ajouter(new Point(e.getX(), e.getY()));//la derniére figure de la liste
					System.out.println(new Point(e.getX(), e.getY()).toString());
					System.out.println("nb point:"+ vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).getTaille());
				}
				else {
					vue.getFigs().ajouter(new Rectangle(true, vue.getCouleur()));
					System.out.println("new rect");
					vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).ajouter(new Point(e.getX(), e.getY()));//la derniére figure de la liste
					System.out.println(new Point(e.getX(), e.getY()).toString());
					System.out.println("nb point:"+ vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).getTaille());
				}

			}
		}

		else if (vue.getMode() == 3 || vue.getMode() == 4) {
			System.out.println(vue.getMode());
			if(vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).getTaille() <= 2) {
				System.out.println("nb point:"+ vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).getTaille());
				vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).ajouter(new Point(e.getX(), e.getY()));//la derniére figure de la liste
				System.out.println(new Point(e.getX(), e.getY()).toString());
				System.out.println("nb point:"+ vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).getTaille());
				if(vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).getTaille() == 3) {
					AffTri aff = new AffTri(vue.getFigs().getFigs(vue.getFigs().getTaille() - 1));
					System.out.println("new aff");
					this.vue.getAffs().add(aff);
					this.vue.getPanneau().repaint();
				}
			}
			else {
				//JOptionPane.showMessageDialog(null, "Nouveau triangle", "NOUVELLE FIGURE", JOptionPane.INFORMATION_MESSAGE);
				if(vue.getMode() == 3) {
					vue.getFigs().ajouter(new Triangle(false, vue.getCouleur()));
					System.out.println("new tri");
					vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).ajouter(new Point(e.getX(), e.getY()));//la derniére figure de la liste
					System.out.println(new Point(e.getX(), e.getY()).toString());
					System.out.println("nb point:"+ vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).getTaille());
				}
				else {
					vue.getFigs().ajouter(new Triangle(true, vue.getCouleur()));
					vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).ajouter(new Point(e.getX(), e.getY()));//la derniére figure de la liste
					System.out.println("new tri");
					System.out.println(new Point(e.getX(), e.getY()).toString());
					System.out.println("nb point:"+ vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).getTaille());
				}
			}
		}

		else if (vue.getMode() == 5 || vue.getMode() == 6) {
			System.out.println(vue.getMode());
			if(vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).getTaille() <= 1) {
				System.out.println("nb point:"+ vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).getTaille());
				vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).ajouter(new Point(e.getX(), e.getY()));//la derniére figure de la liste
				System.out.println(new Point(e.getX(), e.getY()).toString());
				System.out.println("nb point:"+ vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).getTaille());
				if(vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).getTaille() == 2) {
					AffElip aff = new AffElip(vue.getFigs().getFigs(vue.getFigs().getTaille() - 1));
					System.out.println("new aff");
					this.vue.getAffs().add(aff);
					this.vue.getPanneau().repaint();
				}
			}
			else {
				//JOptionPane.showMessageDialog(null, "Nouveau Rectangle", "NOUVELLE FIGURE", JOptionPane.INFORMATION_MESSAGE);
				if(vue.getMode() == 5) {
					vue.getFigs().ajouter(new Elipse(false, vue.getCouleur()));
					System.out.println("new elip");
					vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).ajouter(new Point(e.getX(), e.getY()));//la derniére figure de la liste
					System.out.println(new Point(e.getX(), e.getY()).toString());
					System.out.println("nb point:"+ vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).getTaille());
				}
				else {
					vue.getFigs().ajouter(new Elipse(true, vue.getCouleur()));
					System.out.println("new elip");
					vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).ajouter(new Point(e.getX(), e.getY()));//la derniére figure de la liste
					System.out.println(new Point(e.getX(), e.getY()).toString());
					System.out.println("nb point:"+ vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).getTaille());
				}

			}
		}

		else if (vue.getMode() == 7 || vue.getMode() == 8) {
			System.out.println(vue.getMode());
			if(vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).getTaille() <= 1) {
				System.out.println("nb point:"+ vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).getTaille());
				vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).ajouter(new Point(e.getX(), e.getY()));//la derniére figure de la liste
				System.out.println(new Point(e.getX(), e.getY()).toString());
				System.out.println("nb point:"+ vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).getTaille());
				if(vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).getTaille() == 2) {
					AffCerc aff = new AffCerc(vue.getFigs().getFigs(vue.getFigs().getTaille() - 1));
					System.out.println("new aff");
					this.vue.getAffs().add(aff);
					this.vue.getPanneau().repaint();
				}
			}
			else {
				//JOptionPane.showMessageDialog(null, "Nouveau Rectangle", "NOUVELLE FIGURE", JOptionPane.INFORMATION_MESSAGE);
				if(vue.getMode() == 7) {
					vue.getFigs().ajouter(new Cercle(false, vue.getCouleur()));
					System.out.println("new cerc");
					vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).ajouter(new Point(e.getX(), e.getY()));//la derniére figure de la liste
					System.out.println(new Point(e.getX(), e.getY()).toString());
					System.out.println("nb point:"+ vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).getTaille());
				}
				else {
					vue.getFigs().ajouter(new Cercle(true, vue.getCouleur()));
					System.out.println("new cerc");
					vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).ajouter(new Point(e.getX(), e.getY()));//la derniére figure de la liste
					System.out.println(new Point(e.getX(), e.getY()).toString());
					System.out.println("nb point:"+ vue.getFigs().getFigs(vue.getFigs().getTaille() - 1).getTaille());
				}

			}
		}
		vue.requestFocus();
	}
}