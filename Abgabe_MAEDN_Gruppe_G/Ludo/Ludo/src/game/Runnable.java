package game;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Runnable extends Application
{ FourPlayerField fpf = new FourPlayerField();
  RollTheDice rtd = new RollTheDice();
  Spieler spieler = new Spieler();
  
  public Runnable() {}
  
  public static void main(String[] args)
  {
    Runnable r = new Runnable();
    
    int zahl = r.rtd.rollTheDice();
    
//    System.out.println(r.getKegelPositionSpieler(1, 1));
//    r.move2(1, 1, zahl);
//    System.out.println("Die WÃ¼rfelzahl war " + zahl + "Die neue Position ist " + r.getKegelPositionSpieler(1, 1));
//    zahl = r.rtd.rollTheDice();
//    r.move2(1, 1, zahl);
//    System.out.println("Die Würfelzahl war " + zahl + "Die neue Position ist " + r.getKegelPositionSpieler(1, 1));
    
    r.move2(1, 1, 2);
    r.move2(1, 1, 4);
    System.out.println("Die neue Position ist " + r.getKegelPositionSpieler(1, 1));
    r.fpf.info(5);
    
    
    
    
  }
  



  public boolean pruefObBesetzt(int i, Runnable x) {
	  for(int s = 1; s<=6 ; s++) {
		  for(int k =1; k<=4;k++) {
			 int positionVonKegel = x.getKegelPositionSpieler(s, k);
			  if(i == positionVonKegel) {
				  
				 			  
				  
				  
			  }
			  
			  
			  
		  }
		  
		  
		  
		  
	  }
	return false;
	  
	  
  }

  
  
  
  
  public int getKegelPositionSpieler(int spieler, int kegel) {
	  return this.spieler.getSpieler1bis6(spieler).getPosition(kegel); }
  
  
  
  
  
  
  
  
  public void move2(int spieler, int kegel, int wuerfelzahl) {
    int neueposition = getKegelPositionSpieler(spieler, kegel) + wuerfelzahl;
    
    this.spieler.getSpieler1bis6(spieler).setPosition(kegel, neueposition);
    
    fpf.documentMove(getKegelPositionSpieler(spieler, kegel), neueposition, this.spieler.getSpieler1bis6(spieler).getKegel(kegel));
  }
  
  public void start(Stage arg0)
    throws Exception
  {}
  
  
  public Image[] getFIeld() {	  
	  return this.fpf.getThisFIeld();
  }
  
  
  
  
}

























