import java.awt.Color;
import java.awt.Point;
public class Text extends Figure {
	private String str;
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public Text(Color c, String str){
	    super(false, c);
	    this.str = str;
	    this.setAff(new AffText(this));
	  }
	  public String toString(){
	    String s = "[Str : " + "|"+ str + "|";
	    s = s + super.toString();
	    return s;
	  }
	  public boolean equals(Object o) {
		  if(o==null || !(o instanceof Text)) {
			  return false;
		  }
		  boolean test = super.equals(o);
		  Text t = (Text)o;
		  test = test && this.getStr().equals(t.getStr());
		  return test;
	  }
		public String sauv(){
			String s = super.sauv();
			StringBuffer stB = new StringBuffer(s);
			stB.insert(12,getStr() + "/");
			return "te" + "/" + stB;
		}
		public boolean estComplet() {
			return this.getTaille() >= 1;
		}
}
