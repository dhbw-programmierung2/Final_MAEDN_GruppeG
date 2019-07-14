package launcher;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Der Launcher-Controller ist fuer die Funktionalitaet des Launchers und die Voreinstellungen zustaendig.
 * Dabei kann der Spieler vor Beginn des Spiels die Anzahl der Spieler, die Farben der Spieler, die Namen der Spieler 
 * und die Eigenschaft des Gegners auswaehlen.
 * 
 * @author Kim, Isabelle, Jonas
 * @version 1.0
 */
public class LauncherController {
	
	/*
	 * FXML Nodes, aus denen das Board aufgebaut ist. 
	 */
	
	@FXML
	public GridPane gridPane;
	
	/*
	 * RadioButtons zur Auswahl der Spieleranzahl.
	 */
	public RadioButton rbPlayer2;
	public RadioButton rbPlayer3;
	public RadioButton rbPlayer4;
	public RadioButton rbPlayer5;
	public RadioButton rbPlayer6;
		
	/*
	 * Textfelder in welche die Namen der Spieler eingetragen werden.
	 */
	public TextField txtName1;
	public TextField txtName2;
	public TextField txtName3;
	public TextField txtName4;
	public TextField txtName5;
	public TextField txtName6;
	
	/*
	 * ComboBoxen zur Farbauswahl.
	 */
	public ComboBox<String> cbColor1;
	public ComboBox<String> cbColor2;
	public ComboBox<String> cbColor3;
	public ComboBox<String> cbColor4;
	public ComboBox<String> cbColor5;
	public ComboBox<String> cbColor6;
	
	/*
	 * ComboBoxen zur Gegnerauswahl.
	 */
	public ComboBox<String> cbRival1;
	public ComboBox<String> cbRival2;
	public ComboBox<String> cbRival3;
	public ComboBox<String> cbRival4;
	public ComboBox<String> cbRival5;
	public ComboBox<String> cbRival6;
	
	/*
	 * Buttons zum Starten des Spiels, Beenden des Launchers, Auswahlueberpruefung und Auswahlaufhebung.
	 */
	public Button btnStartGame;
	public Button btnExitGame;
	public Button btnCheckSelection;
	public Button btnRepeatSelection;
	
	/*
	 * Variable enthaelt die Anzahl der Spieler.
	 */
	public static int numberOfPlayers;
	
	/*
	 * ArrayLists welche die Farbe und Eigenschaften der Spieler enthalten.
	 * Diese sind zum leichteren Befuellen der ComboBoxen vorgesehen.
	 */
	private ArrayList <ComboBox> cbColorList = new ArrayList<ComboBox>();
	private ArrayList <ComboBox> cbRivalList = new ArrayList<ComboBox>();
	
	/*
	 * ArrayLists zur Uebergabe der vom Spieler ausgewaehlten Eigenschaften an die Spiellogik.
	 * Hier wird der Spielername, die Spielerfarbe und der Gegnertyp uebergeben.
	 */
	public ArrayList <String> playerNameList = new ArrayList<String>();
	public ArrayList <String> colorList = new ArrayList<String>();
	public ArrayList <String> rivalList = new ArrayList<String>();
	
	/**
	 * Methode zum Befuellen der Comboboxen.
	 */
	public void initialize() {
		
		/*
		 * Hinzufuegen der Comboboxen in eine Color-Liste.
		 */
		cbColorList.add(cbColor1);
		cbColorList.add(cbColor2);
		cbColorList.add(cbColor3);
		cbColorList.add(cbColor4);
		cbColorList.add(cbColor5);
		cbColorList.add(cbColor6);
		
		/*
		 * Hinzufuegen der Comboboxen in eine Gegner-Liste.
		 */
		cbRivalList.add(cbRival1);
		cbRivalList.add(cbRival2);
		cbRivalList.add(cbRival3);
		cbRivalList.add(cbRival4);
		cbRivalList.add(cbRival5);
		cbRivalList.add(cbRival6);
		
		/*
		 * Die ComboBoxen Farbe werden zunaechst mit den 4 Farben des 4er Spielbrettes gefuellt und die Farbe Gelb als Vorauswahl getroffen.
		 */
		int i = 0,j = 0;
		while (i < cbColorList.size()) {
			cbColorList.get(i).getItems().add("Gelb");
			cbColorList.get(i).getItems().add("Rot");
			cbColorList.get(i).getItems().add("Gruen");
			cbColorList.get(i).getItems().add("Schwarz");
			cbColorList.get(i).setValue("Gelb");
			i++;
		}
		
		/*
		 * Die ComboBoxen fuer die Auswahl der Eigenschaften der Gegner werden befuellt und die Eigenschaft Mensch als Vorauswahl getroffen.
		 */
		while (j < cbRivalList.size()) {
			cbRivalList.get(j).getItems().add("Mensch");
			cbRivalList.get(j).getItems().add("Computer");
			cbRivalList.get(j).setValue("Mensch");
			j++;
		}				
	}
	
	@FXML
	/**
	 * Event Listener fuer den RadioButton, wenn die Anzahl der Spieler zwei ausgewaehlt wird.
	 * 
	 * @param event Aktionsausloesung einer interatkiven GUI-Komponente.
	 */
	public void rbOnActionPlayer2(ActionEvent event) {
		if(rbPlayer2.isSelected()) {
			
			numberOfPlayers = 2;
		
			/*
			 * Die Textfelder und ComboBoxen fuer den Spieler 1 und Spieler 2 werden aktiviert, ausser die ComboBox Farben fuer Spieler 2, da der Spieler 2 immer gegenueber der Farbe des Spielers 1 sein muss.
			 */
			txtName1.setDisable(false);
			cbColor1.setDisable(false);
			cbRival1.setDisable(false);
		
			txtName2.setDisable(false);
			cbRival2.setDisable(false);
		
			/*
		 	* Die Radiobuttons fuer die restlichen Anzahl an Spielern werden deaktiviert.
		 	*/
			rbPlayer3.setDisable(true);
			rbPlayer4.setDisable(true);
			rbPlayer5.setDisable(true);
			rbPlayer6.setDisable(true);
		
			/*
			 * Vorauswahl der ComboBox Farben des Spieler 1 auf Gelb gesetzt wird, wird die Farbe Rot fuer den Spieler 2 ausgewaehlt.
			 */
			cbColor2.setValue("Rot");
		}
	}
	
	@FXML
	/**
	 * Event Listener fuer den RadioButton, wenn die Anzahl der Spieler drei ausgewaehlt wird.
	 * 
	 * @param event Aktionsausloesung einer interatkiven GUI-Komponente.
	 */
	public void rbOnActionPlayer3(ActionEvent event) {
		if(rbPlayer3.isSelected()) {
			numberOfPlayers = 3;
			
			
			/*
			 * Hier werden die Farben Blau und Lila zur ComboBox Farben des Spielers 1 hinzugefuegt, da hier auf dem 6er Spielfeld gespielt wird.
			 * Da die Auswahl fuer Spieler 1 anfangs auf Gelb gesetzt wird und die direkte Nachbarfarbe bei 3 Spieler nicht ausgewaehlt werden darf, wird die Auswahl Farbe bei Spieler 2 auf Blau und Gruen beschraenkt
			 * Die Farbauswahl bei Spieler 3 wird erweitert mit Blau und Lila und die Vorauswahl auf Gruen gesetzt.
			 */
			cbColor1.getItems().add("Blau");
			cbColor1.getItems().add("Lila");
			cbColor1.setValue("Gelb");
			
			cbColor2.getItems().removeAll();
			cbColor2.getItems().add("Blau");
			cbColor2.getItems().add("Gruen");
			cbColor2.setValue("Blau");
			
			cbColor3.getItems().add("Blau");
			cbColor3.getItems().add("Lila");
			cbColor3.setValue("Gruen");
			
			/*
			 * Das Textfeld fuer die Namen und die ComboBoxen fuer die Gegnerauswahl werden fuer Spieler 1, Spieler 2 und Spieler 3 aktiviert.
			 */
			txtName1.setDisable(false);
			cbColor1.setDisable(false);
			cbRival1.setDisable(false);
			
			txtName2.setDisable(false);
			cbColor2.setDisable(false);
			cbRival2.setDisable(false);
			
			txtName3.setDisable(false);
			cbRival3.setDisable(false);
			
			/*
		 	* Die Radiobuttons fuer die restlichen Anzahl an Spielern werden deaktiviert.
		 	*/
			rbPlayer2.setDisable(true);
			rbPlayer4.setDisable(true);
			rbPlayer5.setDisable(true);
			rbPlayer6.setDisable(true);
		}
	}
	
	@FXML
	/**
	 * Event Listener fuer den RadioButton, wenn die Anzahl der Spieler vier ausgewaehlt wird.
	 * 
	 * @param event Aktionsausloesung einer interatkiven GUI-Komponente.
	 */
	public void rbOnActionPlayer4(ActionEvent event) {
		if(rbPlayer4.isSelected()) {
			numberOfPlayers = 4;
			
			/*
			 * Das Textfeld fuer die Namen und die ComboBoxen fuer die Gegnerauswahl werden fuer Spieler 1, Spieler 2, Spieler 3 und Spieler 4 aktiviert.
			 */
			txtName1.setDisable(false);
			cbColor1.setDisable(false);
			cbRival1.setDisable(false);
			
			txtName2.setDisable(false);
			cbColor2.setDisable(false);
			cbRival2.setDisable(false); 
			
			txtName3.setDisable(false);
			cbColor3.setDisable(false);
			cbRival3.setDisable(false);
			
			txtName4.setDisable(false);
			cbColor4.setDisable(false);
			cbRival4.setDisable(false);
			
			/*
		 	* Die Radiobuttons fuer die restlichen Anzahl an Spielern werden deaktiviert.
		 	*/
			rbPlayer2.setDisable(true);
			rbPlayer3.setDisable(true);
			rbPlayer5.setDisable(true);
			rbPlayer6.setDisable(true);
		}
	}
	
	@FXML
	/**
	 * Event Listener fuer den RadioButton, wenn die Anzahl der Spieler fuenf ausgewaehlt wird.
	 * 
	 * @param event Aktionsausloesung einer interatkiven GUI-Komponente.
	 */
	public void rbOnActionPlayer5(ActionEvent event) {
		if(rbPlayer5.isSelected()) {
			numberOfPlayers = 5;
			
			/*
			 * Hier werden die Farben Blau und Lila zur ComboBox Farben aller Spieler hinzugefuegt, da hier auf dem 6er Spielfeld gespielt wird.
			 * Und jeweils eine Vorauswahl der Farben getroffen.
			 */
			int i = 0,j = 0;
			while (i < cbColorList.size()) {
				cbColorList.get(i).getItems().add("Blau");
				cbColorList.get(i).getItems().add("Lila");
				cbColorList.get(i).setValue("Gelb");
				i++;
			}
			
			/*
			 * Das Textfeld fuer die Namen und die ComboBoxen fuer die Gegnerauswahl werden fuer Spieler 1, Spieler 2, Spieler 3, Spieler 4 und Spieler 5 aktiviert.
			 */
			txtName1.setDisable(false);
			cbColor1.setDisable(false);
			cbRival1.setDisable(false);
			
			txtName2.setDisable(false);
			cbColor2.setDisable(false);
			cbRival2.setDisable(false);
			
			txtName3.setDisable(false);
			cbColor3.setDisable(false);
			cbRival3.setDisable(false);
			
			txtName4.setDisable(false);
			cbColor4.setDisable(false);
			cbRival4.setDisable(false);
			
			txtName5.setDisable(false);
			cbColor5.setDisable(false);
			cbRival5.setDisable(false);
			
			/*
		 	* Die Radiobuttons fuer die restlichen Anzahl an Spielern werden deaktiviert.
		 	*/
			rbPlayer2.setDisable(true);
			rbPlayer3.setDisable(true);
			rbPlayer4.setDisable(true);
			rbPlayer6.setDisable(true);
		}
	}
	
	@FXML
	/**
	 * Event Listener fuer den RadioButton, wenn die Anzahl der Spieler sechs ausgewaehlt wird.
	 * 
	 * @param event Aktionsausloesung einer interatkiven GUI-Komponente.
	 */
	public void rbOnActionPlayer6(ActionEvent event) {
		if(rbPlayer6.isSelected()) {
			numberOfPlayers = 6;
			
			/*
			 * Hier werden die Farben Blau und Lila zur ComboBox Farben aller Spieler hinzugefuegt, da hier auf dem 6er Spielfeld gespielt wird.
			 * Und jeweils eine Vorauswahl der Farben getroffen.
			 */
			int i = 0,j = 0;
			while (i < cbColorList.size()) {
				cbColorList.get(i).getItems().add("Blau");
				cbColorList.get(i).getItems().add("Lila");
				cbColorList.get(i).setValue("Gelb");
				i++;
			}
			
			/*
			 * Das Textfeld fuer die Namen und die ComboBoxen fuer die Gegnerauswahl werden fuer alle Spieler aktiviert.
			 */
			txtName1.setDisable(false);
			cbColor1.setDisable(false);
			cbRival1.setDisable(false);
			
			txtName2.setDisable(false);
			cbColor2.setDisable(false);
			cbRival2.setDisable(false);
			
			txtName3.setDisable(false);
			cbColor3.setDisable(false);
			cbRival3.setDisable(false);
			
			txtName4.setDisable(false);
			cbColor4.setDisable(false);
			cbRival4.setDisable(false);
				
			txtName5.setDisable(false);
			cbColor5.setDisable(false);
			cbRival5.setDisable(false);
			
			txtName6.setDisable(false);
			cbColor6.setDisable(false);
			cbRival6.setDisable(false);
			
			/*
		 	* Die Radiobuttons fuer die restlichen Anzahl an Spielern werden deaktiviert.
		 	*/
			rbPlayer2.setDisable(true);
			rbPlayer3.setDisable(true);
			rbPlayer4.setDisable(true);
			rbPlayer5.setDisable(true);
		}
	}
	
	@FXML
	/**
	 * Event Listener fuer die ComboBox Farben1.
	 * 
	 * @param event Aktionsausloesung einer interatkiven GUI-Komponente.
	 */
	public void cbOnActionColor1(ActionEvent event) {
	
		/*
		 * Wenn die Anzahl der Spieler gleich zwei ist, wird die Methode setcbColor2Player2() ausgefuehrt.
		 */
		if(rbPlayer2.isSelected()){
			setcbColor2Player2();
		}
		
		/*
		 * Hinzufuegen aller Farben in die Combobox von Spieler zwei, ansonsten kann es zu Fehlern bei der Farbauswahl kommen.
		 * Wenn die Anzahl der Spieler gleich 3 ist, wird die Methode setcbColor2Player3() ausgefuehrt.
		 */
		else if(rbPlayer3.isSelected()) {
			
			cbColor2.getItems().removeAll();
			cbColor2.getItems().add("Gelb");
			cbColor2.getItems().add("Rot");
			cbColor2.getItems().add("Gruen");
			cbColor2.getItems().add("Schwarz");
			cbColor2.getItems().add("Blau");
			cbColor2.getItems().add("Lila");
			
			setcbColor2Player3();
		}
	}
	
	/*
	 * Wenn die Anzahl der Spieler gleich 2 ist, duerfen nur die gegenueberliegenden Farben verwendet werden. 
	 * Es wird zunaechst die Auswahl fuer die erste Farbe ueberprueft und die Farbe fuer Spieler zwei automatisch ausgewaehlt.
	 * Die zweite Farbe kann nicht veraendert werden.
	 */
	private void setcbColor2Player2() {		
		if(cbColor1.getValue().equals("Gelb")) {
			cbColor2.setValue("Rot");
			cbColor2.setDisable(true);
		} else if(cbColor1.getValue().equals("Gruen")) {
			cbColor2.setValue("Schwarz");
			cbColor2.setDisable(true);
		} else if(cbColor1.getValue().equals("Rot")) {
			cbColor2.setValue("Gelb");
			cbColor2.setDisable(true);
		} else if(cbColor1.getValue().equals("Schwarz")) {
			cbColor2.setValue("Gruen");
			cbColor2.setDisable(true);
		}
	}
	
	/*
	 * Wenn die Anzahl der Spieler gleich 3 ist, duerfen nur die Farben verwendet werden, die nicht direkte Nachbarn sind. 
	 * Es wird zunaechst die Auswahl fuer die erste Farbe ueberprueft und die Farbauswahl fuer die zweite Farbe neu festgelegt, also die Combobox mit neuen Items besetzt.
	 */
	private void setcbColor2Player3() {
		if(cbColor1.getValue().equals("Gelb")) {
			cbColor2.getItems().clear();
			cbColor2.getItems().add("Blau");
			cbColor2.getItems().add("Gruen");
			cbColor2.setValue("Blau");
			cbColor3.setValue("Gruen");
				
		} else if(cbColor1.getValue().equals("Gruen")) {
			cbColor2.getItems().clear();
			cbColor2.getItems().add("Gelb");
			cbColor2.getItems().add("Blau");
			cbColor2.setValue("Gelb");
			cbColor3.setValue("Blau");
				
		} else if(cbColor1.getValue().equals("Blau")) {
			cbColor2.getItems().clear();
			cbColor2.getItems().add("Gelb");
			cbColor2.getItems().add("Gruen");
			cbColor2.setValue("Gelb");
			cbColor3.setValue("Gruen");
		
		} else if(cbColor1.getValue().equals("Lila")) {
			cbColor2.getItems().clear();
			cbColor2.getItems().add("Rot");
			cbColor2.getItems().add("Schwarz");
			cbColor2.setValue("Rot");
			cbColor3.setValue("Schwarz");
				
		} else if(cbColor1.getValue().equals("Rot")) {
			cbColor2.getItems().clear();
			cbColor2.getItems().add("Lila");
			cbColor2.getItems().add("Schwarz");
			cbColor2.setValue("Lila");
			cbColor3.setValue("Schwarz");
				
		} else if(cbColor1.getValue().equals("Schwarz")) {
			cbColor2.getItems().clear();
			cbColor2.getItems().add("Rot");
			cbColor2.getItems().add("Lila");
			cbColor2.setValue("Rot");
			cbColor3.setValue("Lila");
		}
	}

	@FXML
	/**
	 * Event Listener fuer die ComboBox Farben2.
	 * 
	 * @param event Aktionsausloesung einer interatkiven GUI-Komponente.
	 */
	public void cbOnActionColor2(ActionEvent event) {
		
		/*
		 * Wenn die Anzahl der Spieler gleich 3 ist, wird die Methode setcbColor3() ausgefuehrt.
		 */
		if(rbPlayer3.isSelected()){
			setcbColor3();
		}
	}

	/*
	 * Anschliessend wird die Auswahl fuer die erste und zweite Farbe ueberprueft und die Farbe fuer Spieler drei automatisch ausgewaehlt.
	 * Die dritte Farbe kann nicht veraendert werden.
	 */
	public void setcbColor3() {
		if(cbColor1.getValue().equals("Gelb")) {
			if(cbColor2.getValue().equals("Gruen")) {
				cbColor3.setValue("Blau");
			} else if (cbColor2.getValue().equals("Blau")){
				cbColor3.setValue("Gruen");
			}	
		} else if(cbColor1.getValue().equals("Gruen")) {
			if(cbColor2.getValue().equals("Blau")) {
				cbColor3.setValue("Gelb");
			} else if(cbColor2.getValue().equals("Gelb")){
				cbColor3.setValue("Blau");
			}	
		} else if(cbColor1.getValue().equals("Blau")) {
			if(cbColor2.getValue().equals("Gruen")) {
				cbColor3.setValue("Gelb");
			} else if(cbColor2.getValue().equals("Gelb")){
				cbColor3.setValue("Gruen");
			}		
		} else if(cbColor1.getValue().equals("Lila")) {
			if(cbColor2.getValue().equals("Rot")) {
				cbColor3.setValue("Schwarz");
			} else if (cbColor2.getValue().equals("Schwarz")){
				cbColor3.setValue("Rot");
			}				
		} else if(cbColor1.getValue().equals("Rot")) {
			if(cbColor2.getValue().equals("Lila")) {
				cbColor3.setValue("Schwarz");
			} else if (cbColor2.getValue().equals("Schwarz")){
				cbColor3.setValue("Lila");
			}	
				
		} else if(cbColor1.getValue().equals("Schwarz")) {
			if(cbColor2.getValue().equals("Rot")) {
				cbColor3.setValue("Lila");
			} else if (cbColor2.getValue().equals("Lila")){
				cbColor3.setValue("Rot");
			}	
		}
	}

	@FXML
	/**
	 * Event Listener fuer den Button Auswahl ueberpruefen.
	 * 
	 * @param event Aktionsausloesung einer interatkiven GUI-Komponente.
	 */
	public void buttonOnActionCheckSelection(ActionEvent event) {
		
		/*
		 * Zunaechst muss ein RadioButton fuer die Anzahl an Spielern ausgewaehlt sein, sonst tritt ein Fehler bei der Ueberpruefung auf.
		 */
		if((!rbPlayer2.isSelected()) && (!rbPlayer3.isSelected()) && (!rbPlayer4.isSelected()) && (!rbPlayer5.isSelected()) && (!rbPlayer6.isSelected())) {
			JOptionPane.showMessageDialog(null, "Bitte waehlen Sie eine Anzahl an Spielern aus.","Achtung", JOptionPane.ERROR_MESSAGE);
		}
		else {
			
			/*
			 * Ueberpruefung ob die Anzahl der Spieler gleich zwei ist.
			 */
			if(numberOfPlayers == 2) {
				
				/*
				 * Es wird die Methode checkSelection1and2() ausgefuehrt, wenn diese false zurueckggibt wird eine Fehlermeldung gesendet.
				 */
				if(checkSelection1and2() == true) {
					btnStartGame.setDisable(false);
				} else {
					JOptionPane.showMessageDialog(null, "Bitte Ueberpruefen Sie Ihre Eingaben.","Achtung", JOptionPane.ERROR_MESSAGE);
				}
				
			/*
			 * Ueberpruefung ob die Anzahl der Spieler gleich drei ist.
			 */
			}else if(numberOfPlayers == 3) {
				
				/*
				 * Es werden die Methoden checkSelection1and2() und checkSelection3() ausgefuehrt, sind diese false, wird eine Fehlermeldung zurueckgegeben.
				 */
				if((checkSelection1and2() == true) && (checkSelection3() == true)) {
						btnStartGame.setDisable(false);
				} else {
					JOptionPane.showMessageDialog(null, "Bitte Ueberpruefen Sie Ihre Eingaben.","Achtung", JOptionPane.ERROR_MESSAGE);
				}
			
			/*
			 * Ueberpruefung ob die Anzahl der Spieler gleich vier ist.
			 */
			} else if (numberOfPlayers == 4) {
				
				/*
				 * Es werden die Methoden checkSelection1and2(), checkSelection3() und checkSelection4() ausgefuehrt, sind diese false, wird eine Fehlermeldung zurueckgegeben.
				 */
				if((checkSelection1and2() == true) && (checkSelection3() == true) && (checkSelection4() == true)) {
					btnStartGame.setDisable(false);
				} else {
					JOptionPane.showMessageDialog(null, "Bitte Ueberpruefen Sie Ihre Eingaben.","Achtung", JOptionPane.ERROR_MESSAGE);
				}
			
				/*
				 * Ueberpruefung ob die Anzahl der Spieler gleich fuenf ist.
				 */
			} else if (numberOfPlayers == 5) {
				
				/*
				 * Es werden die Methoden checkSelection1and2(), checkSelection3(), checkSelection4() und checkSelection5() ausgefuehrt, sind diese false, wird eine Fehlermeldung zurueckgegeben.
				 */
				if((checkSelection1and2() == true) && (checkSelection3() == true) && (checkSelection4() == true) && (checkSelection5()) == true) {
					btnStartGame.setDisable(false);
				} else {
					JOptionPane.showMessageDialog(null, "Bitte Ueberpruefen Sie Ihre Eingaben.","Achtung", JOptionPane.ERROR_MESSAGE);
				}
			
			/*
			 * Ueberpruefung ob die Anzahl der Spieler gleich sechs ist.
			 */
			} else if (numberOfPlayers == 6) {
				/*
				 * Es werden die Methoden checkSelection1and2(), checkSelection3(), checkSelection4(), checkSelection5() und checkSelection6() ausgefuehrt, sind diese false, wird eine Fehlermeldung zurueckgegeben.
				 */
				if((checkSelection1and2() == true) && (checkSelection3() == true) && (checkSelection4() == true) && (checkSelection5() == true) && (checkSelection6() == true)) {
					btnStartGame.setDisable(false);
				} else {
					JOptionPane.showMessageDialog(null, "Bitte Ueberpruefen Sie Ihre Eingaben.","Achtung", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
		/*
		 * Interne Testzwecke
		 */
		System.out.println(playerNameList);
		System.out.println(colorList);
		System.out.println(rivalList);
	}
	
	/**
	 * Die Eingaben beim Spieler eins und Spieler zwei werden auf Vollstaendigkeit und Richtigkeit ueberprueft.
	 * 
	 * @return true / false Es wird true zurueckgegeben, wenn kein Fehler bei der Auswahl auftritt. Es gibt false aus, wenn die Auswahl fehlerhaft ist.
	 */
	public boolean checkSelection1and2 () {
		
		/*
		 * Beschreiben der moeglichen Fehlerfaelle.
		 */
		if((txtName1.getText().isEmpty()) || (txtName2.getText().isEmpty()) || (txtName2.getText().equals(txtName1.getText())) || (!txtName1.getText().matches("\\w+")) || (!txtName2.getText().matches("\\w+")) || (txtName1.getText().length() > 40) || (txtName1.getText().length() <= 1) || (txtName2.getText().length() > 40) || (txtName2.getText().length() <= 1)){
			playerNameList.clear();
			colorList.clear();
			rivalList.clear();
			return false;
		}	
		if((cbColor1.getValue().isEmpty()) || (cbColor2.getValue().isEmpty()) || (cbColor2.getValue().equals(cbColor1.getValue()))) {
			playerNameList.clear();
			colorList.clear();
			rivalList.clear();
			return false;
		}
		
		else {	
			playerNameList.add(txtName1.getText());
			colorList.add(cbColor1.getValue());
			rivalList.add(cbRival1.getValue());	
		
			playerNameList.add(txtName2.getText());
			colorList.add(cbColor2.getValue());
			rivalList.add(cbRival2.getValue());	
			return true;	
		}
	}
	
	/**
	 * Die Eingaben des Spielers drei auf Vollstaendigkeit und Richtigkeit ueberprueft.
	 * 
	 * @return true / false Es wird true zurueckgegeben, wenn kein Fehler bei der Auswahl auftritt. Es gibt false aus, wenn die Auswahl fehlerhaft ist.
	 */
	public boolean checkSelection3 () {
		
		/*
		 * Beschreiben der moeglichen Fehlerfaelle.
		 */
		if((playerNameList.contains(txtName3.getText())) || (txtName3.getText().isEmpty()) || (!txtName3.getText().matches("\\w+")) || (txtName3.getText().length() > 40) || (txtName3.getText().length() <= 1)){
			playerNameList.clear();
			colorList.clear();
			rivalList.clear();
			return false;
		}
		
		if((cbColor3.getValue().isEmpty()) || (cbColor3.getValue().equals(cbColor1.getValue())) || (cbColor3.getValue().equals(cbColor2.getValue()))){
			playerNameList.clear();
			colorList.clear();
			rivalList.clear();
			return false;
		}
		else { 
			playerNameList.add(txtName3.getText());
			colorList.add(cbColor3.getValue());
			rivalList.add(cbRival3.getValue());	
			
			return true;
		} 	
	}
	
	/**
	 * Die Eingaben des Spielers vier auf Vollstaendigkeit und Richtigkeit ueberprueft.
	 * 
	 * @return true / false Es wird true zurueckgegeben, wenn kein Fehler bei der Auswahl auftritt. Es gibt false aus, wenn die Auswahl fehlerhaft ist.
	 */
	public boolean checkSelection4 () {
		
		/*
		 * Beschreiben der moeglichen Fehlerfaelle.
		 */
		if((playerNameList.contains(txtName4.getText())) || (txtName4.getText().isEmpty()) || (!txtName4.getText().matches("\\w+")) || (txtName4.getText().length() > 40) || (txtName4.getText().length() <= 1)) {
			playerNameList.clear();
			colorList.clear();
			rivalList.clear();
			return false;
		}	
		
		if((cbColor4.getValue().isEmpty()) || (cbColor4.getValue().equals(cbColor1.getValue())) || (cbColor4.getValue().equals(cbColor2.getValue())) || (cbColor4.getValue().equals(cbColor3.getValue()))){
			playerNameList.clear();
			colorList.clear();
			rivalList.clear();
			return false;			
		} 
		
		else { 
			playerNameList.add(txtName4.getText());
			colorList.add(cbColor4.getValue());	
			rivalList.add(cbRival4.getValue());
			
			return true;
		}	
	}
		
	/**
	 * Die Eingaben des Spielers fuenf auf Vollstaendigkeit und Richtigkeit ueberprueft.
	 * 
	 * @return true / false Es wird true zurueckgegeben, wenn kein Fehler bei der Auswahl auftritt. Es gibt false aus, wenn die Auswahl fehlerhaft ist.
	 */
	public boolean checkSelection5 () {
		
		/*
		 * Beschreiben der moeglichen Fehlerfaelle.
		 */
		if((playerNameList.contains(txtName5.getText())) || (txtName5.getText().isEmpty()) || (!txtName5.getText().matches("\\w+")) || (txtName5.getText().length() > 40) || (txtName5.getText().length() <= 1)) {
			playerNameList.clear();
			colorList.clear();
			rivalList.clear();
			return false;
		}	
		
		if((cbColor5.getValue().isEmpty()) || (cbColor5.getValue().equals(cbColor1.getValue())) || (cbColor5.getValue().equals(cbColor2.getValue())) || (cbColor5.getValue().equals(cbColor3.getValue())) || (cbColor5.getValue().equals(cbColor4.getValue()))){
			playerNameList.clear();
			colorList.clear();
			rivalList.clear();
			return false;
		}	
		
		else { 
			playerNameList.add(txtName5.getText());
			colorList.add(cbColor5.getValue());	
			rivalList.add(cbRival5.getValue());
			
			return true;
		}
	}
		
	/**
	 * Die Eingaben des Spielers sechs auf Vollstaendigkeit und Richtigkeit ueberprueft.
	 * 
	 * @return true / false Es wird true zurueckgegeben, wenn kein Fehler bei der Auswahl auftritt. Es gibt false aus, wenn die Auswahl fehlerhaft ist.
	 */
	public boolean checkSelection6 () {
		
		/*
		 * Beschreiben der moeglichen Fehlerfaelle.
		 */
		if((playerNameList.contains(txtName6.getText())) || (txtName6.getText().isEmpty()) || (!txtName6.getText().matches("\\w+")) || (txtName6.getText().length() > 40) || (txtName6.getText().length() <= 1)) {
			playerNameList.clear();
			colorList.clear();
			rivalList.clear();
			return false;
		} 
		
		if((cbColor6.getValue().isEmpty()) || (cbColor6.getValue().equals(cbColor1.getValue())) || (cbColor6.getValue().equals(cbColor2.getValue())) || (cbColor6.getValue().equals(cbColor3.getValue())) || (cbColor6.getValue().equals(cbColor4.getValue())) || (cbColor6.getValue().equals(cbColor5.getValue()))){
			playerNameList.clear();
			colorList.clear();
			rivalList.clear();
			return false;
		}
		
		else { 
			playerNameList.add(txtName6.getText());
			colorList.add(cbColor6.getValue());
			rivalList.add(cbRival6.getValue());	
			
			return true;
		} 
	}
	
	@FXML
	/**
	 * Event Listener fuer den Button Auswahl aufheben.
	 * 
	 * @param event Aktionsausloesung einer interatkiven GUI-Komponente.
	 */
	public void buttonOnActionRepeatSelection(ActionEvent event) {
		/*
		 * Das Fenster des Launchers wird geschlossen.
		 */
		Stage currentStage = (Stage)btnStartGame.getScene().getWindow();
		currentStage.close();
		
		/*
		 * Oeffnen eines neues Launcherfenster.
		 */
		try {
			FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/launcher/Launcher.fxml"));
			Parent root = fxmlloader.load();
			Stage secondaryStage = new Stage();
			secondaryStage.setTitle("Game Selection");
			secondaryStage.setScene(new Scene(root, 750, 450)); 
			secondaryStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	@FXML		
	/**
	 * Event Listener fuer den Start Button.
	 * 
	 * @param event Aktionsausloesung einer interatkiven GUI-Komponente.
	 */
	public void buttonOnActionStart(ActionEvent event) {
		
		/*
		 * Schliessen des Launcher Fensters.
		 */
		Stage currentStage = (Stage)btnStartGame.getScene().getWindow();
		currentStage.close();
		
		/*
		 * Oeffnen des Beginfensters, in welchen die Startfolge bestimmt wird.
		 */
		try {
			FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("Begin.fxml"));
			Parent root = fxmlloader.load();
			BeginController bc = fxmlloader.getController(); 
			bc.initialize(playerNameList, colorList, rivalList, numberOfPlayers);
			Stage secondaryStage = new Stage();
			secondaryStage.setTitle("Wer darf anfangen?");
			secondaryStage.setScene(new Scene(root, 600, 450)); 
			secondaryStage.show();
				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	/**
	 *  Event Listener fuer den Button Spiel beenden.
	 *  Dieser schliesst das Programm.
	 *  
	 * @param event Aktionsausloesung einer interatkiven GUI-Komponente.
	 */
	public void buttonOnActionExit(ActionEvent event) {
		
		System.exit(0);
	}
}