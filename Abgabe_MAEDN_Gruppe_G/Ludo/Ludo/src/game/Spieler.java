package game;

public class Spieler {
  game.Kegel[] spieler;
  game.Kegel gelb;
  game.Kegel gruen;
  game.Kegel blau;
  game.Kegel schwarz;
  game.Kegel lila;
  game.Kegel rot;

  private String name;
  private String farbe;
  private String rival;

  
  public Spieler() {
    spieler = new game.Kegel[6];
    gelb = new game.Kegel("/pictures/Yellow.jpg");
    gruen = new Kegel("/pictures/Green.jpg");
    blau = new Kegel("/pictures/Blue.jpg");
    schwarz = new Kegel("/pictures/Black.jpg");
    lila = new Kegel("/pictures/Purple.jpg");
    rot = new Kegel("/pictures/Red.jpg");
  }
  
  void initSpieler(String name, String farbe, String rival){
    setName(name);
    setFarbe(farbe);
    setRival(rival);
  }



  /*public void setColor()
  {
    spieler[0] = gelb;
    spieler[1] = gruen;
    spieler[2] = blau;
    spieler[3] = schwarz;
    spieler[4] = lila;
    spieler[5] = rot;
  }*/
  

  public Kegel getSpieler1bis6(int i)
  {
    if (i <= spieler.length)
    {
      return spieler[(i - 1)];
    }
    System.out.println("Spieler " + (i - 1) + " existiert nicht.");
    return null;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFarbe() {
    return farbe;
  }

  public void setFarbe(String farbe) {
    this.farbe = farbe;
  }

  public String getRival() {
    return rival;
  }

  public void setRival(String rival) {
    this.rival = rival;
  }
}
