package panels;

import java.util.ResourceBundle;

import events.DrawingEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ToolsPanel extends ScrollPane{

	private Insets padding;
	private ResourceBundle messages;
	
	public ToolsPanel(ResourceBundle messages){
		this.messages = messages;
		GridPane grid = new GridPane();
		padding = new Insets(5,30,5,30);
		
		Button logical_model = new Button();
		logical_model.setText(messages.getString("conceptual_model"));
		logical_model.setPadding(padding);
		logical_model.setMaxWidth(Double.MAX_VALUE);
		logical_model.getStyleClass().add("menu-tools");
		grid.add(logical_model, 0, 0);
		
		VBox flow_logical = getLogicalModel();
		
		
		logical_model.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				if(grid.getChildren().contains(flow_logical)){
					grid.getChildren().remove(flow_logical);
				}else{
					flow_logical.setPrefWidth(grid.getWidth());
					grid.add(flow_logical, 0, 1);
				}
			}
		});
		
		Button relational_model = new Button();
		relational_model.setText(messages.getString("relational_model"));
		relational_model.getStyleClass().add("menu-tools");
		relational_model.setPadding(padding);
		relational_model.setMaxWidth(Double.MAX_VALUE);
		grid.add(relational_model, 0, 2);

		this.setContent(grid);
	}
	
	private VBox getLogicalModel(){
		VBox container = new VBox();
		
		Button select = new Button();
		select.setText(messages.getString("select"));
		select.setMaxWidth(Double.MAX_VALUE);
		select.setPadding(padding);
		select.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				DrawingEvent.type_model = 0;
				
			}
		});
		
		Button entity = new Button();
		entity.setText(messages.getString("entity"));
		entity.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				DrawingEvent.type_model = 1;
				
			}
		});
		entity.setMaxWidth(Double.MAX_VALUE);
		entity.setPadding(padding);
		
		Button attribute = new Button();
		attribute.setText(messages.getString("attribute"));
		attribute.setMaxWidth(Double.MAX_VALUE);
		attribute.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				DrawingEvent.type_model = 2;
				
			}
		});
		attribute.setPadding(padding);
		
		Button specialization = new Button();
		specialization.setText(messages.getString("specialization"));
		specialization.setMaxWidth(Double.MAX_VALUE);
		specialization.setPadding(padding);
		
		Button relationship = new Button();
		relationship.setText(messages.getString("relationship"));
		relationship.setMaxWidth(Double.MAX_VALUE);
		relationship.setPadding(padding);
		
		
		container.getChildren().addAll(select,entity,attribute,specialization,relationship);

		return container;
	}
}
