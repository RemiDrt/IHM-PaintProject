import java.awt.Color;
import java.awt.Point;

public class Gomme extends Figure {
	public Gomme(Point centre) {
		super(true, Color.white);
		this.ajouter(centre);
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
}
