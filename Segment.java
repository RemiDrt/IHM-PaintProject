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

}
