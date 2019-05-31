import java.awt.Color;
public class Rectangle extends Figure {
  public Rectangle(boolean plein, Color c){
    super(plein, c);
  }
  public String toString(){
    String s = "[Rec : ";
    s = s + super.toString();
    return s;
  }
}
