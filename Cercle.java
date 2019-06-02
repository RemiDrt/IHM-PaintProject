import java.awt.Color;
public class Cercle extends Elipse{
  private int ray;
  public Cercle(boolean plein, Color c){
    super(plein, c);
    this.ray = 0;
  }
  public int getRay(){
    return this.ray;
  }
  public void setRay(int r){
    this.ray = r;
  }
  public void initWH() {
	  if(this.getPoints().size() >= 2) {
		  int rx = Math.abs(((int)this.getI(1).getX() - (int)this.getI(0).getX()));
		  int ry = Math.abs(((int)this.getI(1).getY() - (int)this.getI(0).getY()));
		  if(rx > ry) {
			  this.setRay(rx);
			  this.setHeight(rx*2);
			  this.setWidth(rx*2);
		  }
		  else {
			  this.setRay(ry);
			  this.setHeight(ry*2);
			  this.setWidth(ry*2);
		  }
	  }
	  else {
		  System.out.println("liste trop courte");
	  }
  }
  public String toString(){
    String s = "[Cerc : |r:" + this.getRay() + "|" + super.toString();
    return s;
  }
  public boolean equals(Object o) {
	  if(o==null || !(o instanceof Cercle)) {
		  return false;
	  }
	  return super.equals(o);
  }
}
