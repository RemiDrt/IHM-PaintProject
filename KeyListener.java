import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
	private VueFig vue;
	public KeyListener(VueFig vue) {
		super();
		this.vue = vue;
	}
	public void keyReleased(KeyEvent e) {
		System.out.println("ctrl : " + e.isControlDown() + " touche : " + e.getKeyCode() + " relache");
		if(e.getKeyCode() == 83) {
			System.out.println("new seg");
			vue.setMode(0);
			vue.getFigs().ajouter(new Segment(vue.getCouleur()));
		}
		else if(e.getKeyCode() == 82) {
			System.out.println("new rec");
			if(e.isControlDown()) {
				vue.setMode(2);
				vue.getFigs().ajouter(new Rectangle(true, vue.getCouleur()));
			}
			else {
				vue.setMode(1);
				vue.getFigs().ajouter(new Rectangle(false, vue.getCouleur()));
			}
		}
		else if(e.getKeyCode() == 84) {
			System.out.println("new tri");
			if(e.isControlDown()) {
				vue.setMode(4);
				vue.getFigs().ajouter(new Triangle(true, vue.getCouleur()));
			}
			else {
				vue.setMode(3);
				vue.getFigs().ajouter(new Triangle(false, vue.getCouleur()));
			}
		}
		else if(e.getKeyCode() == 69) {
			System.out.println("new eli");
			if(e.isControlDown()) {
				vue.setMode(6);
				vue.getFigs().ajouter(new Elipse(true, vue.getCouleur()));
			}
			else {
				vue.setMode(5);
				vue.getFigs().ajouter(new Elipse(false, vue.getCouleur()));
			}
		}
		else if(e.getKeyCode() == 67) {
			System.out.println("new cerc");
			if(e.isControlDown()) {
				vue.setMode(8);
				vue.getFigs().ajouter(new Cercle(true, vue.getCouleur()));
			}
			else {
				vue.setMode(7);
				vue.getFigs().ajouter(new Cercle(false, vue.getCouleur()));
			}
		}
		else System.out.println("elle sert a rien celle-le !");
	}
}
