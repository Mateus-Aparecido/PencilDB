package application;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import Dialogs.AlertMessages;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import panels.Drawing;
import panels.ToolsPanel;

public class Main extends Application {

	private ResourceBundle messages;

	@Override
	public void start(Stage primaryStage) {
		try {
			ChoiceDialog<String> selectIdiom = new AlertMessages().selectIdiom();
			Optional<String> choice = selectIdiom.showAndWait();
			if(choice.isPresent()){
				Locale locale = getLocation(choice.get());
				messages = ResourceBundle.getBundle("Messages",locale);		
				init(primaryStage,messages);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void init(Stage primaryStage,ResourceBundle messages){
		MenuBar menu = new MenuBar();
		Drawing drawing = new Drawing();
		BorderPane root = new BorderPane();
		ToolBar toolBar = new ToolBar();
		VBox container = new VBox();
		Menu file = new Menu(messages.getString("file"));
		Menu edit = new Menu(messages.getString("edit"));
		Menu window = new Menu(messages.getString("window"));
		Menu help = new Menu(messages.getString("help"));
		
		MenuItem export = new MenuItem("export");
		export.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Open Resource File");
				File file = fileChooser.showSaveDialog(primaryStage);
				if(fileChooser != null){
					WritableImage image = drawing.snapshot(new SnapshotParameters(), null);

				    try {
				        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
				    } catch (IOException e) {
				        // TODO: handle exception here
				    }
				}
			}
		});
		file.getItems().add(export);
		
		menu.getMenus().addAll(file,edit,window,help);
		
		container.getChildren().add(menu);
		container.getChildren().add(toolBar);
		
		Button newFile = new Button();
		Button openFile = new Button();
		
		//newFile.setGraphic(new ImageView("/new_file.png"));
		//openFile.setGraphic(new ImageView("/open_file.png"));
		
		toolBar.getItems().addAll(newFile,openFile);
		
		
		root.setTop(container);
		
		
		root.setCenter(drawing);
		ToolsPanel tools = new ToolsPanel(messages);
		root.setLeft(tools);
		Scene scene = new Scene(root,800,500);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("PaintDB");
		primaryStage.show();
	}

	private Locale getLocation(String name){
		Locale locale = null;
		switch(name){
		case "English":
			locale = new Locale("en","US");
			break;
		case "Portugues":
			locale = new Locale("pt","BR");
			break;
		}
		return locale;
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
