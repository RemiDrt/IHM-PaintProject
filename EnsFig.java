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
  public void vider() {
	  ListIterator<Figure> ite = this.getFigs().listIterator();
	  while(ite.hasNext()) {
		  Figure f = ite.next();
		  ite.remove();
	  }
  }
}
