package game;

import java.util.HashMap;
import javafx.scene.image.Image;

public class FourPlayerField
{
  public Image[] feld = new Image[40];
  public HashMap<Integer, Image> hm = new HashMap();
  



  public FourPlayerField()
  {
  //  feld = fillArray(feld);
    initializeMap();
  }
  
  public void initializeMap() {
    for (int i = 0; i < feld.length; i++) {
      hm.put(Integer.valueOf(i), null);
    }
  }
  
  public void documentMove(int alteStelle, int neuestelle, Image kegel) {
	  hm.remove(alteStelle);
	  hm.put(neuestelle, kegel);
	  feld[alteStelle]= null;
	  feld[neuestelle]=kegel;
	 
  }
  public void info(int feld) {
	  if(hm.containsKey(feld) && hm.get(feld)!= null) {
		  
		  System.out.println("Da steht was");
	  }
	  else System.out.println("Digger isch kaputt");
	  
  }
  public Image[] getThisFIeld() {	  
	  return this.feld;
  }
  
  
//  private Image[] fillArray(Image[] x)
//  {
//    for (int i = 0; i < x.length; i++)
//    {
//      x[i] = i;
//    }
//    
//    return x;
//  }
}
