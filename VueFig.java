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

	public void sauver() {
		String path=new File("").getAbsolutePath();
		JOptionPane.showMessageDialog(null, "Saisir nom du fichier a sauvegarder !", "sauvegarde", JOptionPane.INFORMATION_MESSAGE);
		Scanner sc = new Scanner(System.in);
		String nom = sc.nextLine();
		new File(path+"\\" + nom +".txt");
		String s = "";
		for(int i=0; i<getFigs().getTaille(); i++) {
			s = s + getFigs().getFigs(i).sauv() + "\n" ;
		}
		try{
					PrintWriter sortie = new PrintWriter(new BufferedWriter(new FileWriter(nom + ".txt")));
					sortie.print(s);//toutes les infos
					sortie.close();
			}

			catch(IOException e) {
					System.out.println(e);
		}
	}
	public void charger() {
		String nom;
		JFileChooser choix = new JFileChooser();
		try {
			choix.showOpenDialog(null);
			nom = choix.getSelectedFile().getAbsolutePath();
			BufferedReader br = new BufferedReader(new FileReader(nom));
		    String line;
		    line = br.readLine();
		    while (line != null) {
					Figure f = null;
					StringTokenizer st = new StringTokenizer(line, "/");
					System.out.println("d1 " + st.toString());
					String type = (String)st.nextElement();
					System.out.println("d2 " + type);
					String red = (String)st.nextElement();
					System.out.println("d3 " + red);
					String green = (String)st.nextElement();
					System.out.println("d4 " + green);
					String blue = (String)st.nextElement();
					System.out.println("d5 " + blue);
					String plein = (String)st.nextElement();
					System.out.println("d6 " + plein);
					float r = Float.parseFloat(red);
					float g = Float.parseFloat(green);
					float b = Float.parseFloat(blue);
					boolean p = Boolean.parseBoolean(plein);
					if(type.equals("r")){
						f = new Rectangle(p, new Color(r,g,b));
					}
					else if(type.equals("tri")){
						f = new Triangle(p, new Color(r,g,b));
					}
					else if(type.equals("te")){
						String str = (String)st.nextElement();
						f = new Text(new Color(r,g,b), str);
					}
					else if(type.equals("g")){
						f = new Gomme();
					}
					else if(type.equals("e")){
						f = new Elipse(p, new Color(r,g,b));
					}
					else if(type.equals("c")){
						f = new Cercle(p, new Color(r,g,b));
					}
					else if(type.equals("s")){
						f = new Segment(new Color(r,g,b));;
					}
					while (st.hasMoreElements()){
						String xi = (String)st.nextElement();
						System.out.println("d7 " + xi);
						String yi = (String)st.nextElement();
						System.out.println("d7 " + yi);
						int x = Integer.parseInt(xi);
						int y = Integer.parseInt(yi);
						f.ajouter(new Point(x, y));
					}
					this.getFigs().ajouter(f);
					line = br.readLine();
			}
		    br.close();
		}

		catch(IOException e) {
			System.out.println(e);
		}
  }
	public String mesFigs() {
		return this.getFigs().toString();
	}
}
