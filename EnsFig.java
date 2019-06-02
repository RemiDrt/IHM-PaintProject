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
				line = br.readLine();
			}
		    br.close();
		}
		
		catch(IOException e) {
			System.out.println(e);
		}
  }
  public void sauver() {
		String path=new File("").getAbsolutePath(); 
		JOptionPane.showMessageDialog(null, "Saisir nom du fichier a sauvegarder !", "sauvegarde", JOptionPane.INFORMATION_MESSAGE);
		Scanner sc = new Scanner(System.in);
		String nom = sc.nextLine();
		new File(path+"\\" + nom +".txt");
		String s = "";
		for(int i=0; i<getTaille(); i++) {
			s = s + this.getFigs(i).getCouleur().getRed() + "\t" + this.getFigs(i).getCouleur().getGreen() + "\t" + this.getFigs(i).getCouleur().getBlue() + "\n" ;
			s = s + this.getFigs(i).estPlein() + "\n";
			for(int y=0; y<this.getFigs(i).getTaille(); y++) {
				s = s + this.getFigs(i).getI(y).getX() + "\t" + this.getFigs(i).getI(y).getY() + "\n";
			}
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
  public String toString(){
    String s = "[" + "\n";
    for(int i = 0; i < this.getTaille(); i++){
      s = s + this.figs.get(i).toString() + "\n";
    }
    s = s + "]";
    return s;
  }
  public void vider() {
	  ListIterator<Figure> ite = this.getFigs().listIterator();
	  while(ite.hasNext()) {		  
		  Figure f = ite.next();
		  ite.remove();
	  }
  }
}
