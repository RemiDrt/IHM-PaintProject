import java.awt.Color;
import java.awt.Point;

public class Gomme extends Figure {
	public Gomme() {
		super(true, Color.white);
		this.setAff(new AffGomme(this));
	}
	public String toString() {
		String s = "[Gomme : |" + super.toString() + "]";
		return s;
	}
	public boolean equals(Object o) {
	  if(o==null || !(o instanceof Gomme)) {
		  return false;
	  }
	  return super.equals(o);
	}
	public String sauv(){
		return "g" + "/" + super.sauv();
	}
	public boolean estComplet() {
		  return this.getTaille() >= 1;
	  }
}
