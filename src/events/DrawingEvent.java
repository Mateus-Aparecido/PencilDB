package events;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Polygon;
import models.LogicalModel;

public class DrawingEvent implements EventHandler<MouseEvent>{

	public static int type_model;
	
	private StackPane panel;
	private LogicalModel logical;
	
	public DrawingEvent(StackPane panel){
		this.panel = panel;
		logical = new LogicalModel(panel);
	}
	public void handle(MouseEvent event) {
		switch(type_model){
		
		case 1://entity
			Polygon polygon = logical.makeEntity(event.getX(), event.getY());
			panel.getChildren().add(polygon);
			break;
			
		default:
			break;
		}

		
	}
	
}
