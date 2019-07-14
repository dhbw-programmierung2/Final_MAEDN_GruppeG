package game;

import javafx.scene.paint.Color;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Board {

    public List<Field> getFelderListe() {
        return felderListe;
    }

    public void setFelderListe(List<Field> felderListe) {
        this.felderListe = felderListe;
    }

    List<Field> felderListe = new ArrayList<>();

}
