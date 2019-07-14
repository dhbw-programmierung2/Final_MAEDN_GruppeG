package fourplayersgame;

import game.Felder;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;

import javafx.scene.control.SplitPane;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import game.Dice;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;

import javafx.scene.shape.Circle;
import launcher.LauncherController;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

/**
 * Dieser Controller ist fuer das Steuern und die Initialisierung des 4er Spielfeld zustaendig.
 * 
 * @author Lukas, Kim, Isabelle, Jonas
 * @version 1.0
 *
 */
public class GameBoardFourPlayersController {
	
	/*
	 * FXML Komponenten, die auf dem Spielfeld sichtbar sein werden.
	 */
	@FXML
	public SplitPane splitPane;
	public GridPane gridPaneLeft;
	public GridPane gridPaneRigth;
	
	/*
	 * Startfelder der verschiedenen Farben.
	 */
	public Circle crcBeginYellow001;
	public Circle crcBeginYellow002;
	public Circle crcBeginYellow003;
	public Circle crcBeginYellow004;
	public Circle crcBeginBlack003;
	public Circle crcBeginBlack001;
	public Circle crcBeginBlack004;
	public Circle crcBeginBlack002;
	public Circle crcBeginRed004;
	public Circle crcBeginRed003;
	public Circle crcBeginRed001;
	public Circle crcBeginRed002;
	public Circle crcBeginGreen001;
	public Circle crcBeginGreen002;
	public Circle crcBeginGreen003;
	public Circle crcBeginGreen004;
	
	/*
	 * Endfelder der verschiedenen Farben
	 */
	public Circle crcAimBlack001;
	public Circle crcAimBlack002;
	public Circle crcAimBlack003;
	public Circle crcAimBlack004;
	public Circle crcAimYellow001;
	public Circle crcAimYellow002;
	public Circle crcAimYellow003;
	public Circle crcAimYellow004;
	public Circle crcAimGreen001;
	public Circle crcAimGreen002;
	public Circle crcAimGreen003;
	public Circle crcAimGreen004;
	public Circle crcAimRed001;
	public Circle crcAimRed002;
	public Circle crcAimRed003;
	public Circle crcAimRed004;
	
	/*
	 * Lauffelder des Spielfelds.
	 */
	public Circle crcField031;
	public Circle crcField030;
	public Circle crcField029;
	public Circle crcField032;
	public Circle crcField028;
	public Circle crcField033;
	public Circle crcField027;
	public Circle crcField034;
	public Circle crcField026;
	public Circle crcField035;
	public Circle crcField025;
	public Circle crcField036;
	public Circle crcField037;
	public Circle crcField038;
	public Circle crcField039;
	public Circle crcField040;
	public Circle crcField001;
	public Circle crcField002;
	public Circle crcField003;
	public Circle crcField004;
	public Circle crcField005;
	public Circle crcField015;
	public Circle crcField006;
	public Circle crcField014;
	public Circle crcField007;
	public Circle crcField013;
	public Circle crcField008;
	public Circle crcField012;
	public Circle crcField009;
	public Circle crcField010;
	public Circle crcField011;
	public Circle crcField024;
	public Circle crcField023;
	public Circle crcField022;
	public Circle crcField021;
	public Circle crcField020;
	public Circle crcField016;
	public Circle crcField017;
	public Circle crcField018;
	public Circle crcField019;
	
	/*
	 * Button zum Wuerfeln und zum Beenden der Anwendung.
	 */
	public Button btnRollTheDice;
	public Button btnExitGame;
	
	/*
	 * Wuerfelbild, welches die gewuerfelte Augenzahl anzeigt.
	 */
	public ImageView imgDice;
	
	/*
	 * Textfelder, auf welchem die Namen der Spieler angezeigt werden.
	 */
	public TextField txtPlayer1;
	public TextField txtPlayer2;
	public TextField txtPlayer3;
	public TextField txtPlayer4;
	
	/*
	 * Zaehlt mit, wie oft der Wuerfel Button gedrueckt wurde.
	 */
	public int numberButtonPressed = 0;
	
	/*
	 * Diese ArrayLists enthalten die Felder.
	 * Unterscheidung in Kategorien: Lauffelder, Hausfeldern/Beginfeldern und Zielfeldern.
	 * Der HashMap wird die ID der Circles sowie ein interner Name als Wert uebergeben.
	 */
	public ArrayList<Circle> fieldsGuiList = new ArrayList<Circle>();
	public ArrayList<Circle> beginnFieldsBlackGuiList = new ArrayList<Circle>();
	public ArrayList<Circle> aimFieldsBlackGuiList = new ArrayList<Circle>();
	public ArrayList<Circle> beginFieldsRedGuiList = new ArrayList<Circle>();
	public ArrayList<Circle> aimFieldsRedGuiList = new ArrayList<Circle>();
	public ArrayList<Circle> beginFieldsYellowGuiList = new ArrayList<Circle>();
	public ArrayList<Circle> aimFieldsYellowGuiList = new ArrayList<Circle>();
	public ArrayList<Circle> beginFieldsGreenGuiList = new ArrayList<Circle>();
	public ArrayList<Circle> aimFieldsGreenGuiList = new ArrayList<Circle>();

	public HashMap<String, String> tokenID = new HashMap<String, String>();
	private ArrayList<String> colorList;

	/**
	 * Methode, die das Spielfeld initialisiert.
	 * 
	 * @param playerName Enthaelt die Namen der Spieler
	 * @param colorList Enthaelt die Farben der jeweiligen Spieler
	 * @param rival Enthaelt ob es sich um einen Computer oder Mensch handelt
	 * @param numberOfPlayers Enthaelt die Anzahl der Spieler
	 * @param startPlayer Spieler welcher die hoechste Zahl gewuerfelt hat
	 */
	public void initialize(ArrayList<String> playerName, ArrayList<String> colorList, ArrayList<String> rival, int numberOfPlayers, Integer startPlayer) {
		this.colorList = colorList;
		ObservableList<Node> l_circleList = gridPaneLeft.getChildren();
		for (Node l_node : l_circleList) {
			Circle l_circle = (Circle) l_node;
			if (l_circle.getId().startsWith("crcField")) {
				fieldsGuiList.add(l_circle);
			} else if (l_circle.getId().startsWith("crcAimBlack")) {
				aimFieldsBlackGuiList.add(l_circle);
			} else if (l_circle.getId().startsWith("crcBeginBlack")) {
				beginnFieldsBlackGuiList.add(l_circle);
			}else if (l_circle.getId().startsWith("crcAimRed")) {
				aimFieldsRedGuiList.add(l_circle);
			}else if (l_circle.getId().startsWith("crcBeginRed")) {
				beginFieldsRedGuiList.add(l_circle);
			}else if (l_circle.getId().startsWith("crcAimYellow")) {
				aimFieldsYellowGuiList.add(l_circle);
			}else if (l_circle.getId().startsWith("crcBeginYellow")) {
				beginFieldsYellowGuiList.add(l_circle);
			}else if (l_circle.getId().startsWith("crcAimGreen")) {
				aimFieldsGreenGuiList.add(l_circle);
			}else if (l_circle.getId().startsWith("crcBeginGreen")) {
				beginFieldsGreenGuiList.add(l_circle);
			}
		}
		
		/*
		 * Sortieren der Listen nach ihren Feldern.
		 */
		fieldsGuiList.sort(Comparator.comparing(circle -> circle.getId()));
		aimFieldsBlackGuiList.sort(Comparator.comparing(circle -> circle.getId()));
		beginnFieldsBlackGuiList.sort(Comparator.comparing(circle -> circle.getId()));
		aimFieldsRedGuiList.sort(Comparator.comparing(circle -> circle.getId()));
		beginFieldsRedGuiList.sort(Comparator.comparing(circle -> circle.getId()));
		aimFieldsYellowGuiList.sort(Comparator.comparing(circle -> circle.getId()));
		beginFieldsYellowGuiList.sort(Comparator.comparing(circle -> circle.getId()));
		aimFieldsGreenGuiList.sort(Comparator.comparing(circle -> circle.getId()));
		beginFieldsGreenGuiList.sort(Comparator.comparing(circle -> circle.getId()));

		/*
		 * Zur internen Ueberpruefung.
		 */
		System.out.println(fieldsGuiList);
		System.out.println(playerName);
		System.out.println(colorList);
		System.out.println(rival);
		System.out.println(numberOfPlayers);
		
		/*
		 * Anzeigen der Spielernamen und ihrer jeweiligen Farbe auf dem Spielfeld.
		 */
		txtPlayer1.setText(playerName.get(0) + " - " + colorList.get(0));
		txtPlayer2.setText(playerName.get(1) + " - " + colorList.get(1));
		if(numberOfPlayers == 4) {
			txtPlayer3.setText(playerName.get(2) + " - " + colorList.get(2));
			txtPlayer4.setText(playerName.get(3) + " - " + colorList.get(3));
		}		
		
		/*
		 * Check, ob Farbe Gruen ausgewaehlt wurde.
		 * Setzen eines Effekts um die jeweiligen Basisfelder.
		 */
		if(colorList.contains("Gruen")) {
			
			crcBeginGreen001.setEffect(new DropShadow(+25d, 0d, +2d, Color.GREEN));
			crcBeginGreen002.setEffect(new DropShadow(+25d, 0d, +2d, Color.GREEN));
			crcBeginGreen003.setEffect(new DropShadow(+25d, 0d, +2d, Color.GREEN));
			crcField011.setEffect(new DropShadow(+25d, 0d, +2d, Color.GREEN));
			
			populateGreen();
			
			tokenID.put("crcBeginGreen1", "green1");
			tokenID.put("crcBeginGreen2", "green2");
			tokenID.put("crcBeginGreen3", "green3");
			tokenID.put("crcField11", "green4");
		}
		
		/*
		 * Check, ob Farbe Gelb ausgewaehlt wurde.
		 * Setzen eines Effekts um die jeweiligen Basisfelder.
		 */
		if(colorList.contains("Gelb")) {
			
			crcBeginYellow001.setEffect(new DropShadow(+25d, 0d, +2d, Color.YELLOW));
			crcBeginYellow002.setEffect(new DropShadow(+25d, 0d, +2d, Color.YELLOW));
			crcBeginYellow003.setEffect(new DropShadow(+25d, 0d, +2d, Color.YELLOW));
			crcField001.setEffect(new DropShadow(+25d, 0d, +2d, Color.YELLOW));
			
			populateYellow();
			
			tokenID.put("crcBeginYellow1", "yellow1");
			tokenID.put("crcBeginYellow2", "yellow2");
			tokenID.put("crcBeginYellow3", "yellow3");
			tokenID.put("crcField1", "yellow4");
		}
		
		/*
		 * Check, ob Farbe Schwarz ausgewaehlt wurde.
		 * Setzen eines Effekts um die jeweiligen Basisfelder.
		 */
		if(colorList.contains("Schwarz")) {
			
			crcBeginBlack001.setEffect(new DropShadow(+25d, 0d, +2d, Color.BLACK));
			crcBeginBlack002.setEffect(new DropShadow(+25d, 0d, +2d, Color.BLACK));
			crcBeginBlack003.setEffect(new DropShadow(+25d, 0d, +2d, Color.BLACK));
			crcField031.setEffect(new DropShadow(+25d, 0d, +2d, Color.BLACK));
			
			populateBlack();
			
			tokenID.put("crcBeginBlack1", "black1");
			tokenID.put("crcBeginBlack2", "black2");
			tokenID.put("crcBeginBlack3", "black3");
			tokenID.put("crcField31", "black4");
		}
		
		/*
		 * Check, ob Farbe Rot ausgewaehlt wurde.
		 * Setzen eines Effekts um die jeweiligen Basisfelder.
		 */
		if(colorList.contains("Rot")) {
			
			crcBeginRed001.setEffect(new DropShadow(+25d, 0d, +2d, Color.RED));
			crcBeginRed002.setEffect(new DropShadow(+25d, 0d, +2d, Color.RED));
			crcBeginRed003.setEffect(new DropShadow(+25d, 0d, +2d, Color.RED));
			crcField021.setEffect(new DropShadow(+25d, 0d, +2d, Color.RED));
			
			populateRed();
			
			tokenID.put("crcBeginRed1", "red1");
			tokenID.put("crcBeginRed2", "red2");
			tokenID.put("crcBeginRed3", "red3");
			tokenID.put("crcField21", "red4");
		}
	}
	
	/**
	 * Methode setzt die roten Spielfiguren in die rote Basis.
	 * Setzen einer Spielfiguren auf das Lauffeld vor der Basis.
	 */
	public void populateRed() {
		Image im4 = new Image("/pictures/Red.jpg", false);
		crcBeginRed001.setFill(new ImagePattern(im4));
		crcBeginRed002.setFill(new ImagePattern(im4));
		crcBeginRed003.setFill(new ImagePattern(im4));
		crcField021.setFill(new ImagePattern(im4));
	}
	
	/**
	 * Methode setzt die schwarzen Spielfiguren in die schwarze Basis.
	 * Setzen einer Spielfiguren auf das Lauffeld vor der Basis.
	 */
	public void populateBlack() {
		Image im3 = new Image("/pictures/Black.jpg", false);
		crcBeginBlack001.setFill(new ImagePattern(im3));
		crcBeginBlack002.setFill(new ImagePattern(im3));
		crcBeginBlack003.setFill(new ImagePattern(im3));
		crcField031.setFill(new ImagePattern(im3));
	}
	
	/**
	 * Methode setzt die gelben Spielfiguren in die gelbe Basis.
	 * Setzen einer Spielfiguren auf das Lauffeld vor der Basis.
	 */
	public void populateYellow() {
		Image im2 = new Image("/pictures/Yellow.jpg", false);
		crcBeginYellow001.setFill(new ImagePattern(im2));
		crcBeginYellow002.setFill(new ImagePattern(im2));
		crcBeginYellow003.setFill(new ImagePattern(im2));
		crcField001.setFill(new ImagePattern(im2));
	}
	
	/**
	 * Methode setzt die gruenen Spielfiguren in die gruene Basis.
	 * Setzen einer Spielfiguren auf das Lauffeld vor der Basis.
	 */
	public void populateGreen() {
		Image im1 = new Image("/pictures/Green.jpg", false);
		crcBeginGreen001.setFill(new ImagePattern(im1));
		crcBeginGreen002.setFill(new ImagePattern(im1));
		crcBeginGreen003.setFill(new ImagePattern(im1));
		crcField011.setFill(new ImagePattern(im1));
	}
	
	/**
	 * EventListener für das druecken eines Nodes der GUI.
	 * 
	 * @param event Klicken des Nodes mit der Maus 
	 */
	@FXML
	public void circleOnActionM(MouseEvent event) {
		String tempCircle = event.getPickResult().getIntersectedNode().getId();
		
		if(tokenID.containsKey(tempCircle)) {
			System.out.println("Ja");
		} else {
			JOptionPane.showMessageDialog(null, "Auf diesem Feld steht keine Spielfigur.","Achtung", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	
	/**
	 * Diese Methode wuerfelt eine Zahl zwischen eins und sechs.
	 * 
	 * @param event Aktionsausloesung einer interatkiven GUI-Komponente
	 */
	@FXML
	public void buttonRollTheDiceOnAction(ActionEvent event) {
		
		/*
		 * Nach jedem mal Wuerfeln wird die Anzahl der runden/gewuerfelten male um eins erhoeht.
		 */
		numberButtonPressed++;
		
		if(numberButtonPressed == 1) {
			for(int i = 0; i <= LauncherController.numberOfPlayers; i++) {
				Dice rtd = new Dice();
				//rtd.anfangsRunde();
			}
		}
		
		Dice rtd = new Dice();
		int value = rtd.rollTheDice();

		/*
		 * Bilder der sechs Wuerfel.
		 */
		Image dice1 = new Image("/pictures/Dice1.png", false);
		Image dice2 = new Image("/pictures/Dice2.png", false);
		Image dice3 = new Image("/pictures/Dice3.png", false);
		Image dice4 = new Image("/pictures/Dice4.png", false);
		Image dice5 = new Image("/pictures/Dice5.png", false);
		Image dice6 = new Image("/pictures/Dice6.png", false);
		
		/*
		 * Aendern des Wuerfel bildes zu der gewuerfelten Zahl.
		 */
		switch (value) {
		case 1:
			imgDice.setImage(dice1);
			break;
		case 2:
			imgDice.setImage(dice2);
			break;
		case 3:
			imgDice.setImage(dice3);
			break;
		case 4:
			imgDice.setImage(dice4);
			break;
		case 5:
			imgDice.setImage(dice5);
			break;
		case 6:
			imgDice.setImage(dice6);
			break;
		default: imgDice.setImage(dice1);
			break;
		}
		
		/*
		 * Man darf nur einmal Wuerfeln und muss danach ziehen.
		 */
		if (event.getSource()==btnRollTheDice) {
			
				btnRollTheDice.setDisable(true);
				if (/*spieler hat gezogen*/ 
						//circleOnActionM(event);
						true) {
					
					btnRollTheDice.setDisable(false);
			}
		}
	}
	
	/**
	 * Methode, welche die Anwendung beendet.
	 * 
	 * @param event Aktionsausloesung einer interatkiven GUI-Komponente
	 */
	@FXML
	public void buttonExitGameOnAction(ActionEvent event) {

		System.exit(0);
	}

	/**
	 * Diese Methode ruft die Spiellogik auf 
	 */
	public void erstelleLogikFeld(){
		List<Felder> felderListe = new ArrayList<>();
		//Start with the section on the left side to the top.
		int x = 0;
		int y = 4;
		//Movement after every field in a certain direction.
		int l_moveX;
		int l_moveY;
		//Special position for the assembly fields of the player.
		int l_houseY = 2;
		int sector = 1;
		//Loop through every row (section).
		for (int l_row = 0; l_row < 11; l_row++){
			//Loop through the columns (indexes).
			for (int l_column = 0; l_column < 11; l_column++){
				Circle circle = fieldsGuiList.get(l_column * sector);
				Felder freiFeld = new Felder();
				freiFeld.initFreiFeld(l_column, colorList.get(sector - 1), circle);
				felderListe.add(freiFeld);
				//First four indexes are assigned to the assembly fields.
				/*if (l_column < 4){
					placeAssembly(l_fieldArray[l_row][l_column], l_playerList, l_houseY);
					//After every finished assembly point the Y-Coordinate of the house is updated. The X-Coordinates
					//are always the same.
					if (l_column == 3){
						l_houseY = l_houseY + 2;
					}
				}*/
				//Field on the section of a player.
				//else {
					//Movement after each field is differentiated in section (row) and current index (column).
					if (l_row == 0) {
						l_moveX = decideXMovement(l_column, 1, 0, 0, 1);
						l_moveY = decideYMovement(l_column, 0, -1, 1, -4);
					} else if (l_row == 1) {
						l_moveX = decideXMovement(l_column, 0, 1, -1, 4);
						l_moveY = decideYMovement(l_column, 1, 0, 0, 1);
					} else if (l_row == 2) {
						l_moveX = decideXMovement(l_column, -1, 0, 0, -1);
						l_moveY = decideYMovement(l_column, 0, 1, -1, 4);
					} else {
						l_moveX = decideXMovement(l_column, 0, -1, 1, -4);
						l_moveY = decideYMovement(l_column, -1, 0, 0, -1);
					}
					//New X- and Y-Coordinate for the next field in the array.
					x = x + l_moveX;
					y = y + l_moveY;
				//}
			}
			sector++;
		}
	}

	/**
	 * @param moveX1 X-Movement after the first four fields and the ninth field.
	 * @param moveX2 X-Movement after the fifth, sixth, seventh and eighth field.
	 * @param moveX3 X-Movement after every field in the finish line, except the last one.
	 * @param moveX4 X-Movement after the last field in the finish line.
	 * @return Returns the movement in X-direction for every field.
	 */
	private int decideXMovement(int l_column, int moveX1, int moveX2, int moveX3, int moveX4){
		if (l_column < 8 || l_column == 12){
			return moveX1;
		} else if (l_column < 12){
			return moveX2;
		} else if (l_column < 17){
			return moveX3;
		} else {
			return moveX4;
		}
	}

	/**
	 * @param moveY1 Y-Movement after the first four fields and the ninth field.
	 * @param moveY2 Y-Movement after the fifth, sixth, seventh and eighth field.
	 * @param moveY3 Y-Movement after every field in the finish line, except the last one.
	 * @param moveY4 Y-Movement after the last field in the finish line.
	 * @return Returns the movement in Y-direction for every field.
	 */
	private int decideYMovement(int l_column, int moveY1, int moveY2, int moveY3, int moveY4){
		if (l_column < 8 || l_column == 12){
			return moveY1;
		} else if (l_column < 12){
			return moveY2;
		} else if (l_column < 17){
			return moveY3;
		} else {
			return moveY4;
		}
	}


}

