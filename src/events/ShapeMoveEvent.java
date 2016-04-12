package events;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class ShapeMoveEvent implements EventHandler<MouseEvent>{

	private Shape shape;

	public ShapeMoveEvent(Shape shape) {
		this.shape = shape;
	}

	@Override
	public void handle(MouseEvent event) {
		double width = shape.getLayoutBounds().getWidth()/2;
		double height = shape.getLayoutBounds().getWidth()/2;
		double mouseX = event.getX();
		double mouseY = event.getY();
		if(-width-mouseX >= -10 && (mouseY >= -5 && mouseY <= 5)){
			shape.setCursor(Cursor.NW_RESIZE);
		}else if(width-mouseX <= 10 && (mouseY >= -5 && mouseY <= 5)){
			shape.setCursor(Cursor.NE_RESIZE);
		}else{
			shape.setCursor(Cursor.DEFAULT);
		}
	}
}
