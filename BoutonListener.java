import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class BoutonListener implements FigCte, ActionListener{
  private int val;
  private VueFig vue;
	public BoutonListener(int i, VueFig vue){
		this.val = i;
    this.vue = vue;
	}
	 public void actionPerformed(ActionEvent e) {
    switch (val){
      case SEGMENT : {
    	  vue.defaultCursor();
        System.out.println("new seg");
        vue.getFigs().ajouter(new Segment(vue.getCouleur()));
        vue.setMode(SEGMENT);
      }
        break;
      case RECTANGLE : {
    	  vue.defaultCursor();
        System.out.println("new rect");
        vue.getFigs().ajouter(new Rectangle(false, vue.getCouleur()));
        vue.setMode(RECTANGLE);
      }
        break;
      case RECTANGLE_PL : {
    	  vue.defaultCursor();
        System.out.println("new rect");
        vue.getFigs().ajouter(new Rectangle(true, vue.getCouleur()));
        vue.setMode(RECTANGLE_PL);
      }
        break;
      case TRIANGLE : {
    	  vue.defaultCursor();
        System.out.println("new tri");
        vue.getFigs().ajouter(new Triangle(false, vue.getCouleur()));
        vue.setMode(TRIANGLE);
      }
        break;
      case TRIANGLE_PL : {
    	  vue.defaultCursor();
        System.out.println("new tri");
        vue.getFigs().ajouter(new Triangle(true, vue.getCouleur()));
        vue.setMode(TRIANGLE_PL);
      }
        break;
      case ELIPSE : {
    	  vue.defaultCursor();
        System.out.println("new elip");
        vue.getFigs().ajouter(new Elipse(false, vue.getCouleur()));
        vue.setMode(ELIPSE);
      }
        break;
      case ELIPSE_PL : {
    	  vue.defaultCursor();
        System.out.println("new elip");
        vue.getFigs().ajouter(new Elipse(true, vue.getCouleur()));
        vue.setMode(ELIPSE_PL);
      }
        break;
      case CERCLE : {
    	  vue.defaultCursor();
        System.out.println("new cerc");
        vue.getFigs().ajouter(new Cercle(false, vue.getCouleur()));
        vue.setMode(CERCLE);
      }
        break;
      case CERCLE_PL : {
    	  vue.defaultCursor();
        System.out.println("new cerc");
        vue.getFigs().ajouter(new Cercle(true, vue.getCouleur()));
        vue.setMode(CERCLE_PL);
        //JOptionPane.showMessageDialog(null,"lol","lol", JOptionPane.INFORMATION_MESSAGE);
      }
        break;
      case COULEUR : {
    	  vue.defaultCursor();
        System.out.println("couleur : bis " + this.vue.getCouleur());
        Color couleur = JColorChooser.showDialog(null, "couleur de la figure", Color.WHITE);
        vue.setCouleur(couleur);
        System.out.println("c : " + this.vue.getCouleur());
      }
        break;
      case TEXT : {
    	  System.out.println(vue.getMode() + " = mode");
    	  vue.defaultCursor();
        System.out.println("new text");
        vue.setMode(TEXT);
      }
      	break;
      case GOMME : {
    	  vue.customCursor();
    	  vue.getFigs().ajouter(new Cercle(true, Color.white));
          vue.setMode(GOMME);
          System.out.println(vue.mesFigs());
      }
      	break;
      case SAUVER : {
        vue.getFigs().sauver();
        System.out.println("ca sauvegarde !");
      }
        break;
      case CHARGER : {
        System.out.println("sa charge att");
        vue.getFigs().vider();
        vue.getFigs().charger();
        vue.getPanneau().repaint();
      }
        break;
    }
  }
}
