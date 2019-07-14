package game;

import javafx.scene.shape.Circle;

public class Felder {

    private int freiPos = 0;
    private int zielPos = 0;
    private int hausPos = 0;
    private String colorCode = "";
    private Circle circle;


    public void initFreiFeld(int freiPos, String colorCode, Circle circle){
        setColorCode(colorCode);
        setFreiPos(freiPos);
        setCircle(circle);
    }

    public void initHausFeld(int hausPos, String colorCode, Circle circle){
        setColorCode(colorCode);
        setHausPos(hausPos);
        setCircle(circle);
    }

    public void initZielFeld(int zielPos, String colorCode, Circle circle){
        setColorCode(colorCode);
        setZielPos(zielPos);
        setCircle(circle);
    }


    public int getFreiPos() {
        return freiPos;
    }

    private void setFreiPos(int freiPos) {
        this.freiPos = freiPos;
    }

    public int getZielPos() {
        return zielPos;
    }

    private void setZielPos(int zielPos) {
        this.zielPos = zielPos;
    }

    public int getHausPos() {
        return hausPos;
    }

    private void setHausPos(int hausPos) {
        this.hausPos = hausPos;
    }

    public String getColorCode() {
        return colorCode;
    }

    private void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }
}
