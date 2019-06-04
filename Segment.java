import java.awt.Color;
public class Segment extends Figure {
  public Segment(Color c){
    super(true, c);
  }
  public String toString(){
    String s = "[Seg : ";
    s = s + super.toString();
    return s;
  }
  public boolean equals(Object o) {
	  if(o==null || !(o instanceof Segment)) {
		  return false;
	  }
	  return super.equals(o);
  }
  public String sauv(){
    return "s" + "/" + super.sauv();
  }
}
