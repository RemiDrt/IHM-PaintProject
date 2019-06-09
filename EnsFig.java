import java.awt.Color;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
public class EnsFig{
  private ArrayList<Figure> figs;
  public EnsFig(){
    this.figs = new ArrayList<Figure>();
  }
  public void ajouter(Figure f){
    this.figs.add(f);
  }
  public ArrayList<Figure> getFigs(){
    return this.figs;
  }
  public Figure getFigs(int i){
    return this.figs.get(i);
  }
  public int getTaille(){
    return this.figs.size();
  }
  public void setFigs(int i, Figure f){
    this.figs.set(i, f);
  }
  public String toString(){
    String s = "[" + "\n";
    for(int i = 0; i < this.getTaille(); i++){
      s = s + this.figs.get(i).toString() + "\n";
    }
    s = s + "]";
    return s;
  }
  
	public void sauver() {
		String path=new File("").getAbsolutePath();
		JOptionPane.showMessageDialog(null, "Saisir nom du fichier a sauvegarder !", "sauvegarde", JOptionPane.INFORMATION_MESSAGE);
		Scanner sc = new Scanner(System.in);
		String nom = sc.nextLine();
		new File(path+"\\" + nom +".txt");
		String s = "";
		for(int i=0; i<getTaille(); i++) {
			s = s + getFigs(i).sauv() + "\n" ;
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
					this.ajouter(f);
					line = br.readLine();
			}
		    br.close();
		}

		catch(IOException e) {
			System.out.println(e);
		}
  }
  
  public void vider() {
	  ListIterator<Figure> ite = this.getFigs().listIterator();
	  while(ite.hasNext()) {
		  Figure f = ite.next();
		  ite.remove();
	  }
  }
}
