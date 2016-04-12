package events;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import models.ConceitualModel;

public class DrawingEvent implements EventHandler<MouseEvent>{

	public static int type_model;
	
	private StackPane panel;
	private ConceitualModel logical;
	
	public DrawingEvent(StackPane panel){
		this.panel = panel;
		logical = new ConceitualModel(panel);
	}
	public void handle(MouseEvent event) {
		switch(type_model){
		
		case 1://entity
			Polygon polygon = logical.makeEntity(event.getX(), event.getY());
			panel.getChildren().add(polygon);
			break;
		case 2://Attribute
			Ellipse circle = logical.makeAttribute(event.getX(), event.getY());
			panel.getChildren().add(circle);
		default:
			break;
		}

		
	}
	
}
