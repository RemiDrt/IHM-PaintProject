import java.awt.Color;
public class Rectangle extends Figure {
  public Rectangle(boolean plein, Color c){
    super(plein, c);
    this.setAff(new AffRect(this));
  }
  public String toString(){
    String s = "[Rec : ";
    s = s + super.toString();
    return s;
  }
  public boolean equals(Object o) {
	  if(o==null || !(o instanceof Rectangle)) {
		  return false;
	  }
	  return super.equals(o);
  }
  public String sauv(){
		return "r" + "/" + super.sauv();
	}
  public boolean estComplet() {
	  return super.estComplet();
  }
}
