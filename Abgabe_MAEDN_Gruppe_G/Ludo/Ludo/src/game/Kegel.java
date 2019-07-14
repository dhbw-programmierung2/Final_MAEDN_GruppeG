package game;

import java.io.PrintStream;
import java.util.HashMap;
import javafx.scene.image.Image;

public class Kegel
{
  public Image[] kegels = new Image[4];
  
  public HashMap<Image, Integer> position = new HashMap();
  

  public Kegel(String imagesource)
  {
    initialize(imagesource);
  }
  
  public void initialize(String imagesource) {
    for (int i = 0; i < 4; i++) {
      Image kegel = getImg(imagesource);
      kegels[i] = kegel;
      position.put(kegel, Integer.valueOf(-i - 1));
    }
  }
  
  public Image getImg(String source) {
    Image img = new Image(source, false);
    return img;
  }
  


  public int getPosition(int kegel1bis4)
  {
    if ((position.containsKey(kegels[(kegel1bis4 - 1)])) && (kegel1bis4 - 1 <= kegels.length))
    {
      return ((Integer)position.get(kegels[(kegel1bis4 - 1)])).intValue();
    }
    System.out.println("Kann Kegel nicht finden");
    return 999;
  }
  

  public void setPosition(int kegel1bis4, int positionneu)
  {
    if ((position.containsKey(kegels[(kegel1bis4 - 1)])) && (kegel1bis4 - 1 <= kegels.length))
    {
      position.remove(kegels[(kegel1bis4 - 1)]);
      position.put(kegels[(kegel1bis4 - 1)], Integer.valueOf(positionneu));
    } else { System.out.println("irgendwas geht nicht");
    }
  }
  
  public Image getKegel(int i)
  {
    if (i - 1 < kegels.length)
    {

      return kegels[(i - 1)];
    }
    
    System.out.println("Dieses Token existiert nicht");
    return null;
  }
}
