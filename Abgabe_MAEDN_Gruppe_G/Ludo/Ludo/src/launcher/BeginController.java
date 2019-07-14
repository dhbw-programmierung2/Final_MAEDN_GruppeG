package launcher;

import game.GameRules;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fourplayersgame.GameBoardFourPlayersController;
import game.Dice;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sixplayersgame.GameBoardSixPlayersController;

import javax.swing.*;

/**
 * Diese Klasse ist fuer die Funktionalitaet und die Logik des Beginfensters verantwortlich.
 * Hier wuerfeln die Spieler die Startreihenfolge aus.
 * 
 * @author Kim, Isabelle, Jonas
 * @version 1.0
 */
public class BeginController {
	
	@FXML
	/*
	 * Buttons zum Wuerfeln, Starten des Spiels und Beenden der Anwendung.
	 */
	public Button btnRollTheDice;
	public Button btnStartGame;
	public Button btnEndGame;
	
	/*
	 * ImageViews, in denen die Bilder des Wuerfels angezeigt werden.
	 */
	public ImageView imgDice1;
	public ImageView imgDice6;
	public ImageView imgDice5;
	public ImageView imgDice4;
	public ImageView imgDice3;
	public ImageView imgDice2;
	
	/*
	 * Textfelder in welche die Namen der Spieler eingetragen werden.
	 */
	public TextField txtPlayer1;
	public TextField txtPlayer2;
	public TextField txtPlayer3;
	public TextField txtPlayer4;
	public TextField txtPlayer5;
	public TextField txtPlayer6;
	
	/*
	 * ArrayList, welche die gewuerfelte Zahlen der Spieler enthaelt.
	 */
	private ArrayList<Integer> cubeNumberList = new ArrayList<Integer>();
	
	/*
	 * Variable wie oft der Wuerfelknopf gedrueckt wurde.
	 */
	private int clickCounter = 0;

	/*
	 * ArrayLists zur Uebergabe der vom Spieler ausgewaehlten Eigenschaften an die Spiellogik.
	 * Hier wird der Spielername, die Spielerfarbe und der Gegnertyp uebergeben.
	 */
	public ArrayList<String> playerNameList = new ArrayList<>();
	public ArrayList<String> colorList = new ArrayList<>();
	public ArrayList<String> rivalList = new ArrayList<>();
	
	/*
	 * Variable enthaelt die Anzahl der Spieler.
	 */
	public int numberOfPlayers = 0;
	
	/**
	 * Eigenschaften der Spieler, welche aus dem Launcher uebergeben werden.
	 * 
	 * @param playerName Name der Spieler
	 * @param color Farbe der Spieler
	 * @param rival Eigenschaft der Spieler
	 */
	public void initialize(ArrayList<String> playerName, ArrayList<String> color, ArrayList<String> rival, int numberOfPlayers) {
		this.playerNameList = playerName;
		this.colorList = color;
		this.rivalList = rival;
		this.numberOfPlayers = numberOfPlayers;

		/*
		 * Anzeigen der Spielernamen mit ihrer jeweiligen Farbe auf dem Spielfeld.
		 */
		txtPlayer1.setText(playerName.get(0) + " - " + color.get(0));
		txtPlayer2.setText(playerName.get(1) + " - " + color.get(1));
		
		if(numberOfPlayers == 3) {
			txtPlayer3.setText(playerName.get(2) + " - " + color.get(2));
		
		} else if(numberOfPlayers == 4) {
			txtPlayer3.setText(playerName.get(2) + " - " + color.get(2));
			txtPlayer4.setText(playerName.get(3) + " - " + color.get(3));
		
		}else if(numberOfPlayers == 5) {
			txtPlayer3.setText(playerName.get(2) + " - " + color.get(2));
			txtPlayer4.setText(playerName.get(3) + " - " + color.get(3));
			txtPlayer5.setText(playerName.get(4) + " - " + color.get(4));
		
		}else if(numberOfPlayers == 6) {
			txtPlayer3.setText(playerName.get(2) + " - " + color.get(2));
			txtPlayer4.setText(playerName.get(3) + " - " + color.get(3));
			txtPlayer5.setText(playerName.get(4) + " - " + color.get(4));
			txtPlayer6.setText(playerName.get(5) + " - " + color.get(5));
		}
		
		btnRollTheDice.setOnMouseClicked(mouseEvent -> btnOnActionRollTheDice(mouseEvent, numberOfPlayers));
		
	}

	/**
	 * Diese Methode wuerfelt fuer jeden Spieler ein mal.
	 * 
	 * @param numberOfPlayers Anzahl der Spieler
	 */
	public void beginningRollTheDice(int numberOfPlayers) {
		if(clickCounter > numberOfPlayers){
			btnRollTheDice.setDisable(true);
			btnStartGame.setDisable(false);
			return;
		}

		Dice rtd = new Dice();
		int value = rtd.rollTheDice();

		cubeNumberList.add(value);

		/*
		 * Bilder der sechs Wuerfel.
		 */
		Image dice1 = new Image("/pictures/Dice1.png", false);
		Image dice2 = new Image("/pictures/Dice2.png", false);
		Image dice3 = new Image("/pictures/Dice3.png", false);
		Image dice4 = new Image("/pictures/Dice4.png", false);
		Image dice5 = new Image("/pictures/Dice5.png", false);
		Image dice6 = new Image("/pictures/Dice6.png", false);

		ImageView imgDice = getDiceView();

		/*
		 * Aendern des Wuerfelbildes zu der gewuerfelten Zahl.
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
	}
	
	/**
	 * Diese Methode holt sich die Bilder, je nach gewuerfelter Zahl.
	 * 
	 * @return imgDice Rueckgabe des jeweiligen Bildes, passend zur gewuerfelten Zahl.
	 */
	private ImageView getDiceView() {
		ImageView imgDice = new ImageView();
		switch (clickCounter) {
			case 1:
				imgDice = imgDice1;
				break;
			case 2:
				imgDice = imgDice2;
				break;
			case 3:
				imgDice = imgDice3;
				break;
			case 4:
				imgDice = imgDice4;
				break;
			case 5:
				imgDice = imgDice5;
				break;
			case 6:
				imgDice = imgDice6;
				break;
		}
		return imgDice;
	}
	
	/**
	 * Methode, welche den Anfangsspieler bestimmt.
	 * 
	 * @return groesste gewuerfelte Zahl gibt dies groesste gewuerfelte Zahl und somit den Spieler, der anfangen darf zurueck
	 */
	private int determinedStartingPlayer() {
		int max = cubeNumberList.stream().max((o1, o2) -> o1.compareTo(o2)).get();

		List<Integer> maxList = new ArrayList<>();
		for (Integer value : cubeNumberList) {
			if (value == max){
				maxList.add(cubeNumberList.indexOf(value +1 ));
			}
		}
		if (maxList.size() > 1){
			JOptionPane.showMessageDialog(null, "Spieler " + maxList.get(new Random().nextInt(maxList.size())) + " beginnen. Viel Spass","Spielbeginn", JOptionPane.INFORMATION_MESSAGE);
			return maxList.get(new Random().nextInt(maxList.size()));
		} else {
			int ausgabe = cubeNumberList.indexOf(max) +1 ;
			JOptionPane.showMessageDialog(null, "Spieler " + ausgabe + " beginnen. Viel Spass","Spielbeginn", JOptionPane.INFORMATION_MESSAGE);
			return cubeNumberList.indexOf(max);
			
		}
	}
	
	/**
	 * Methode, welche die Wuerfel Methode fuer jeden Spieler aufruft.
	 * 
	 * @param event Aktionsausloesung einer interatkiven GUI-Komponente
	 * @param numberOfPlayers Anzahl der Spieler
	 */
	@FXML
	public void btnOnActionRollTheDice(MouseEvent event, int numberOfPlayers) {
		clickCounter++;
		beginningRollTheDice(numberOfPlayers);
	}
	
	/**
	 * Methode, welche das Spielbrett startet.
	 * 
	 * @param event Aktionsausloesung einer interatkiven GUI-Komponente
	 */
	@FXML
	public void btnOnActionStartGame(ActionEvent event) {
		
		/*
		 * Schliessen des Launcher Fensters
		 */
		Stage currentStage = (Stage)btnRollTheDice.getScene().getWindow();
		currentStage.close();

		Integer startPlayer = determinedStartingPlayer();
		
		/*
		 * Bei drei, fuenf oder sechs Spielern wird das 6er Brett aufgerufen.
		 */
		if((LauncherController.numberOfPlayers == 3) || (LauncherController.numberOfPlayers == 5) || (LauncherController.numberOfPlayers == 6)) {

			GameRules gl = new GameRules();
			gl.erstelleSpieler(playerNameList, colorList, rivalList);
			
			
			try {
				FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/sixplayersgame/GameBoardSixPlayers.fxml"));
				Parent root = fxmlloader.load();
				GameBoardSixPlayersController gbsp = fxmlloader.getController(); 
				gbsp.initialize(playerNameList, colorList, rivalList, numberOfPlayers, startPlayer);
				Stage secondaryStage = new Stage();
				secondaryStage.setTitle("Sechser Spielbrett");
				secondaryStage.setScene(new Scene(root, 600, 450)); 
				secondaryStage.show();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else {
						
			/*
			 * Bei zwei oder vier Spielern wird das 4er Brett aufgerufen.
			 */			
			try {
				FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/fourplayersgame/GameBoardFourPlayers.fxml"));
				Parent root = fxmlloader.load();
				GameBoardFourPlayersController gbfp = fxmlloader.getController(); 
				gbfp.initialize(playerNameList, colorList, rivalList, numberOfPlayers, startPlayer);
				Stage secondaryStage = new Stage();
				secondaryStage.setTitle("Vierer Spielbrett");
				secondaryStage.setScene(new Scene(root, 600, 450)); 
				secondaryStage.show();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
	}
	
	/**
	 * Diese Methode beendet die Anwendung.
	 * 
	 * @param event Aktionsausloesung einer interatkiven GUI-Komponente
	 */
	@FXML
	public void btnOnActionEndGame(ActionEvent event) {
		System.exit(0);
	}
}
