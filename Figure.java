import java.awt.Point;
import java.awt.Color;
import java.util.ArrayList;

public class Figure{
  private Color couleur;
  private boolean plein;
  private ArrayList<Point> points;

public Figure(boolean plein, Color couleur){
    this.couleur = couleur;
    this.plein = plein;
    this.points = new ArrayList<Point>();
  }
  public boolean estPlein(){
    return this.plein;
  }
  public void setPlein(boolean plein){
    this.plein = plein;
  }
  public Color getCouleur(){
    return this.couleur;
  }
  public void setColor(Color couleur){
    this.couleur = couleur;
  }
  public ArrayList<Point> getPoints() {
	return points;
}
  public void setPoints(ArrayList<Point> points) {
	this.points = points;
  }
  public void ajouter(Point p) {
	this.points.add(p);
  }
  public Point getI(int i) {
	 return this.points.get(i);
  }
  public int getTaille() {
	  return this.points.size();
  }
  public String toString(){
	String s = "";
	for(int i=0; i<this.points.size(); i++) {
		s = s + this.points.get(i).toString() + "|";
	}
    s = s + this.estPlein() + "]";
    return s;
  }
}
