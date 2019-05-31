import java.util.*;
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
}
