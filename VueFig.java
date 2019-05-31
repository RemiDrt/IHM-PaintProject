import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Point;
public class VueFig extends JFrame implements FigCte{
	private Color couleur;
	private int mode;
	private JButton[] boutonsFigs;
	private static Toolkit atk = Toolkit.getDefaultToolkit();
	private static Dimension dim = atk.getScreenSize();
	private EnsFig figs;
	private ArrayList<Afficheur> affs;
	private JPanel nord;
	private PanelFig panneau;
	public PanelFig getPanneau() {
		return panneau;
	}

	public void setPanneau(PanelFig panneau) {
		this.panneau = panneau;
	}

	public ArrayList<Afficheur> getAffs() {
		return affs;
}


	public VueFig(String title, int w, int h){
		super(title);
		this.couleur = Color.BLACK;
		this.boutonsFigs = new JButton[10];
		for(int i=0; i<FigCte.FIGS_DISPO.length; i++){
			boutonsFigs[i] = new JButton(FigCte.FIGS_DISPO[i]);
			boutonsFigs[i].addActionListener(new BoutonListener(i, this));
		}
		this.figs = new EnsFig();
		this.figs.ajouter(new Segment(this.getCouleur()));//direct en mode segment
		this.affs = new ArrayList<Afficheur>();
		this.setBounds(dim.width/2 - w/2, dim.height/2 - h/2, w, h);
		this.init();
		this.setVisible(true);
		this.mode = 0;
		this.requestFocus();
		JOptionPane.showMessageDialog(null, "Bonjour , vous étes actuellement en mode segment (de base) \n Appuyez sur s,t,r,e,c pour passer en mode segment triangle rectangle elispse ou cercle \n ajouter la touche ctrl pour que la figure soit pleine", "WELCOME", JOptionPane.INFORMATION_MESSAGE);
	}

	public void init(){
		this.addKeyListener(new KeyListener(this));
		this.add(getPanneauCentre(), BorderLayout.CENTER);
		this.add(getPanneauNord(), BorderLayout.NORTH);
	}

	public class PanelFig extends JPanel{
		public void paintComponent(Graphics g){
			for(int i=0; i<getAffs().size(); i++) {
				getAffs().get(i).dessinerFig(g);
			}

		}
	}
	public PanelFig getPanneauCentre(){
		panneau = new PanelFig();
		panneau.setBackground(Color.WHITE);
		panneau.addMouseListener(new MouseListener(this));
		return panneau;
	}
	public JPanel getPanneauNord(){
		this.nord = new JPanel();
		nord.setBackground(Color.LIGHT_GRAY);
		for(int i=0; i<boutonsFigs.length; i++){
			nord.add(boutonsFigs[i]);
		}
		return nord;
	}
	public int getMode() {
	  /*
	   * 0 basic = segment
	   * 1 rectangle
	   * 2 rectangle plein
	   * 3 triangle
	   * 4 triangle plein
	   * 5 elipse
	   * 6 elipse plein
	   * 7 cercle
	   * 8 cercle plein
	   */
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}
	public EnsFig getFigs() {
		return figs;
	}
	public void setFigs(EnsFig figs) {
		this.figs = figs;
	}
	public Color getCouleur(){
		return this.couleur;
	}
	public void setCouleur(Color c){
		this.couleur = c;
	}
}
