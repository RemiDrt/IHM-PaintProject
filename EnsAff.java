import java.util.ArrayList;

public class EnsAff {
	 private ArrayList<Afficheur> affs;
	  public EnsAff(){
	    this.affs = new ArrayList<Afficheur>();
	  }
	  public void ajouter(Afficheur f){
	    this.affs.add(f);
	  }
	  public ArrayList<Afficheur> getAffs(){
	    return this.affs;
	  }
	  public Afficheur getAffs(int i){
	    return this.affs.get(i);
	  }
	  public int getTaille(){
	    return this.affs.size();
	  }
	  public void setAffs(int i, Afficheur f){
	    this.affs.set(i, f);
	  }
}
