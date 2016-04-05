package Dialogs;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceDialog;

public class AlertMessages{

	private List<String> idioms = new ArrayList<>();
	
	public AlertMessages() {	
		
	}

	public ChoiceDialog<String> selectIdiom(){
		loadIdioms();
		ChoiceDialog<String> alert = new ChoiceDialog<>("English", idioms);
		alert.setTitle("language");
		alert.setHeaderText("Please, select a languages:");
		alert.setContentText("languages:");
		
		return alert;
	}

	private void loadIdioms() {
		idioms.add("English");
		idioms.add("Portugues");
	}
	
}
