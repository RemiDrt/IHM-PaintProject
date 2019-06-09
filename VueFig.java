import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
public class VueFig extends JFrame implements FigCte{
	private Color couleur;
	private int mode;
	private JButton[] boutonsFigs;
	private JButton sauv;
	private JButton charg;
	private static Toolkit atk = Toolkit.getDefaultToolkit();
	private static Dimension dim = atk.getScreenSize();
	//C:\Users\Rémi\Desktop\IHM-projet-master\
	private static Image image = atk.getImage("C:\\Users\\Rémi\\Desktop\\IHM-projet-master\\gomme.png");
	private static Cursor c = atk.createCustomCursor(image , new Point(0, 0), "custom cursor");
	private EnsFig figs;
	private JPanel nord;
	private JPanel sud;
	private JPanel centre;
	private PanelFig panneau;
	private JTextArea text;
	public JTextArea getPanText() {
		return text;
	}
	private JTabbedPane onglets;


	public PanelFig getPanneau() {
		return panneau;
	}

	public void setPanneau(PanelFig panneau) {
		this.panneau = panneau;
	}

	public VueFig(String title, int w, int h){
		super(title);

		this.couleur = Color.BLACK;
		this.boutonsFigs = new JButton[FIGS_DISPO.length + 1];
		for(int i=0; i<FigCte.FIGS_DISPO.length; i++){
			boutonsFigs[i] = new JButton(FigCte.FIGS_DISPO[i]);
			boutonsFigs[i].addActionListener(new BoutonListener(i, this));
		}
		boutonsFigs[FIGS_DISPO.length] = new JButton("Gomme");
		boutonsFigs[FIGS_DISPO.length].addActionListener(new BoutonListener(FigCte.GOMME, this));
		sauv = new JButton("sauver");
		sauv.addActionListener(new BoutonListener(FigCte.SAUVER, this));
		charg = new JButton("charger");
		charg.addActionListener(new BoutonListener(FigCte.CHARGER, this));
		this.figs = new EnsFig();
		this.figs.ajouter(new Segment(this.getCouleur()));//direct en mode segment
		this.setBounds(dim.width/2 - w/2, dim.height/2 - h/2, w, h);
		this.init();
		this.setVisible(true);
		this.mode = 0;
		this.requestFocus();
		JOptionPane.showMessageDialog(null, "Bonjour , vous etes actuellement en mode segment (de base) \n Appuyez sur s,t,r,e,c pour passer en mode segment triangle rectangle elispse ou cercle \n ajouter la touche ctrl pour que la figure soit pleine", "WELCOME", JOptionPane.INFORMATION_MESSAGE);
	}

	public void customCursor() {

		this.getPanneau().setCursor(c);
	}
	public void defaultCursor() {
		this.getPanneau().setCursor(Cursor.getDefaultCursor());
	}
	public void init(){
		this.addKeyListener(new KeyListener(this));
		this.add(getPanneauCentre(), BorderLayout.CENTER);
		this.add(getPanneauNord(), BorderLayout.NORTH);
		this.add(getPanneauSud(), BorderLayout.SOUTH);
	}

	public class PanelFig extends JPanel{
		public void paintComponent(Graphics g){//on parcours tous les afficheurs et on les dessine
			super.paintComponent(g);
			for(int i=0; i<getFigs().getTaille(); i++) {
				getFigs().getFigs(i).getAff().dessinerFig(g);
			}
		}
	}
	public JPanel getPanneauCentre(){
		onglets = new JTabbedPane();
		panneau = new PanelFig();
		panneau.setBackground(Color.white);
		panneau.addMouseListener(new MouseListener(this));
		text = new JTextArea("", 37, 107);
		//text.setBounds(panneau.getBounds());
		onglets.add("Graphique", panneau);
		onglets.add("Saisi text", text);
		centre = new JPanel();
		centre.add(onglets);
		return centre;
	}
	public JPanel getPanneauNord(){
		this.nord = new JPanel();
		nord.setBackground(Color.LIGHT_GRAY);
		for(int i=0; i<boutonsFigs.length; i++){
			nord.add(boutonsFigs[i]);
		}
		return nord;
	}
	public JPanel getPanneauSud(){
		this.sud = new JPanel();
		sud.setBackground(Color.LIGHT_GRAY);
		sud.add(this.sauv);
		sud.add(this.charg);
		return sud;
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
	public void nettoyer() {//on enlève les figures non completes !
		ListIterator<Figure> ite = this.getFigs().getFigs().listIterator();//on fait un iterateur de la liste qui y dans EnsFigs
		while(ite.hasNext()) {
			Figure ff = ite.next();
			if(!ff.estComplet()) {
				ite.remove();
			}
		}
		this.notification();
		System.out.println(mesFigs());
	}
	private void notification() {
		this.getPanneau().repaint();
		
	}


	public String mesFigs() {
		return this.getFigs().toString();
	}
}
