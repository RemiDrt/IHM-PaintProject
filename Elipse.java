import java.awt.Color;
public class Elipse extends Figure{
	private int width;
	private int height;
	public Elipse(boolean plein, Color c){
    super(plein, c);
    this.width = 0;
    this.height = 0;
    this.setAff(new AffElip(this));
  }
  public int getWidth(){
    return this.width;
  }
  public int getHeight(){
    return this.height;
  }
  public void setWidth(int w){
    this.width = w;
  }
  public void initWH() {
	  if(this.getPoints().size() >=2) {
	  	int w = Math.abs(((int)this.getI(1).getX() - (int)this.getI(0).getX())*2);
	  	int h = Math.abs(((int)this.getI(1).getY() - (int)this.getI(0).getY())*2);
	  	this.setHeight(h);
	  	this.setWidth(w);
	  }
	  else {
		  System.out.println("liste trop courte");
	  }
  }
  public void setHeight(int h){
    this.height = h;
  }
  public String toString(){
    String s = "[Eli : w:" + this.getWidth() + "|h:" + this.getHeight() + "|" + super.toString();
    return s;
  }
  public boolean equals(Object o) {
	  if(o==null || !(o instanceof Elipse)) {
		  return false;
	  }
	  return super.equals(o);
  }
	public String sauv(){
		return "e" + "/" + super.sauv();
	}
	public boolean estComplet() {
		  return super.estComplet();
	  }
}
