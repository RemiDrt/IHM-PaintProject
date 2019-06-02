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
  public boolean equals(Object o) {
	  if(o == null || !(o instanceof Figure)) {
		  return false;
	  }
	  else {
		  Figure f = (Figure) o;
		  boolean test = f.getTaille()==this.getTaille() && this.getCouleur().equals(f.getCouleur()) && this.estPlein()==f.estPlein();//meme taille de liste,meme couleur, meme plein
		  if(test) {
			  for(int i = 0; i<this.getTaille(); i++) {//dans la liste tous les points sont les memes
				  if(!(this.getI(i).equals(f.getI(i)))) {//si un point est different on return false
					  return false;
				  }
			  }
		  }
		  return test;
	  }
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
