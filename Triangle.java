import java.awt.Color;
public class Triangle extends Figure{
  private int[] lesX;
  private int[] lesY;
  public Triangle(boolean plein, Color c){
    super(plein, c);
   this.lesX = new int[3];
   this.lesY = new int[3];
  }
  public int[] getLesX() {
	  return this.lesX;
  }
  public int[] getLesY() {
	  return this.lesY;
  }
  public void initXY() {
	  if(this.getPoints().size() >= 3) {
		  this.lesX[0] = (int) this.getI(0).getX();
		  this.lesY[0] = (int) this.getI(0).getY();
		  this.lesX[1] = (int) this.getI(1).getX();
		  this.lesY[1] = (int) this.getI(1).getY();
		  this.lesX[2] = (int) this.getI(2).getX();
		  this.lesY[2] = (int) this.getI(2).getY();
	  }
	  else {
		  System.out.println("Liste trop courte");
	  }
  }
  public String toString(){
    String s = "[Tri : " + super.toString();
    return s;
  }
  public boolean equals(Object o) {
	  if(o==null || !(o instanceof Triangle)) {
		  return false;
	  }
	  return super.equals(o);
  }
}
