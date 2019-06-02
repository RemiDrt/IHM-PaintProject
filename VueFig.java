import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.ListIterator;
public class VueFig extends JFrame implements FigCte{
	private Color couleur;
	private int mode;
	private JButton[] boutonsFigs;
	private static Toolkit atk = Toolkit.getDefaultToolkit();
	private static Dimension dim = atk.getScreenSize();
	private static Image image = atk.getImage("C:\\Users\\Rémi\\Desktop\\IHM\\src\\gomme.png");
	private static Cursor c = atk.createCustomCursor(image , new Point(0, 0), "custom cursor");
	private EnsFig figs;
	private EnsAff affs;
	private JPanel nord;
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

	public EnsAff getAffs() {
		return affs;
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
		this.figs = new EnsFig();
		this.figs.ajouter(new Segment(this.getCouleur()));//direct en mode segment
		this.affs = new EnsAff();
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
	}

	public class PanelFig extends JPanel{
		public void paintComponent(Graphics g){//on parcours tous les afficheurs et on les dessine
			super.paintComponent(g);
			for(int i=0; i<getAffs().getTaille(); i++) {
				getAffs().getAffs(i).dessinerFig(g);
			}
			System.out.println(mesFigs());
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
	public void nettoyer() {
	/*on va mettre toutes les figures dans afficheur dans une liste de reference 
	et les figures de la liste des figures de la vue qui seront pas dans la liste de reference seront retirées de la liste des figures de la vue
	*/
		ArrayList<Figure> reference = new ArrayList<Figure>();
		for(int i=0; i<affs.getTaille(); i++) {
			Figure f = affs.getAffs(i).getFigure();//on prends la figure de l'afficheur qu'on regarde dans la liste
			reference.add(f);//on rajoute la figure dans la liste de reference des figures
		}
		ListIterator<Figure> ite = this.getFigs().getFigs().listIterator();//on fait un iterateur de la liste qui y dans EnsFigs
		while(ite.hasNext()) {
			Figure ff = ite.next();
			boolean test = false;//on instanci un test pour savoir si la figure est dans la liste de reference
			for(int i=0; i<reference.size() && !test;i++) {//on va comparer avec toutes les figures de reference tant qu'on a pas fini ou qu'on a pas trouvé une pareil
				if(ff.equals(reference.get(i))) {//si on trouve une pareil on passe le test a vrai et ca sort de la boucle
					test = true;
				}
			}
			if(!test) {//si le test est faux on a pas trouvé donc on enleve la figure de la liste des figures de la vue
				ite.remove();
			}
		}
	}
	public String mesFigs() {
		this.nettoyer();
		return this.getFigs().toString();
	}
}
