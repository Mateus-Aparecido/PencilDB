package models;

import events.EntityDragEvent;
import events.EntityExitEvent;
import events.EntityMoveEvent;
import events.ShapeDragEvent;
import events.ShapeMoveEvent;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.EllipseBuilder;
import javafx.scene.shape.Polygon;

public class ConceitualModel {

	private final double size = 100;
	private StackPane panel;

	public ConceitualModel(StackPane panel) {
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
		polygon.setTranslateX(x);
		polygon.setTranslateY(y);
		polygon.setFill(Color.WHITE);
		StackPane.setAlignment(polygon, Pos.TOP_LEFT);
		return polygon;
	}
	
	public Ellipse makeAttribute(double x, double y){
		
		Ellipse circle = new Ellipse();
		circle.setRadiusX(60);
		circle.setRadiusY(30);
		circle.setStrokeWidth(1);
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.WHITE);
		circle.setOnMouseDragged(new ShapeDragEvent(circle));
		circle.setOnMouseMoved(new ShapeMoveEvent(circle));
		circle.setOnMouseExited(new EntityExitEvent(panel));
		circle.setTranslateX(x);
		circle.setTranslateY(y);
		StackPane.setAlignment(circle, Pos.TOP_LEFT);
		return circle;
	}
}
