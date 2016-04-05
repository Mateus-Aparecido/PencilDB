package models;

import events.EntityDragEvent;
import events.EntityExitEvent;
import events.EntityMoveEvent;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class LogicalModel {

	private final double size = 100;
	private StackPane panel;

	public LogicalModel(StackPane panel) {
		this.panel = panel;
	}

	public Polygon makeEntity(double x, double y){
		Polygon polygon = new Polygon();
		EntityDragEvent events = new EntityDragEvent(polygon);
		polygon.setCursor(Cursor.DEFAULT);
		polygon.setOnMouseDragged(events);
		polygon.setOnMouseMoved(new EntityMoveEvent(polygon));
		polygon.setOnMouseExited(new EntityExitEvent(panel));
		polygon.getPoints().addAll(new Double[]{0.0, 0.0,size, 0.0,size, size,0.0, size});
		polygon.setStroke(Color.BLACK);
		panel.setAlignment(polygon, Pos.TOP_LEFT);
		polygon.setTranslateX(x);
		polygon.setTranslateY(y);
		polygon.setFill(Color.WHITE);
		return polygon;
	}
}
