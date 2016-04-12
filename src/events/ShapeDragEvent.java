package events;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;

public class ShapeDragEvent implements EventHandler<MouseEvent>{

	private Ellipse shape;

	public ShapeDragEvent(Shape shape){
		this.shape = (Ellipse)shape;
	}
 
	@Override
	public void handle(MouseEvent event) {

		double sizeX = shape.getLayoutBounds().getWidth();
		double sizeY = shape.getLayoutBounds().getHeight();

		if(shape.getCursor().equals(Cursor.NW_RESIZE)){
			double t = (sizeX/2+event.getX())/10;
			shape.setRadiusX(shape.getRadiusX()-t);
			shape.setTranslateX(shape.getTranslateX()+t);
			if(event.getY() < 0){
				double t2 = (sizeY/2+event.getY())/10;
				shape.setRadiusY(shape.getRadiusY()-t2);
				shape.setTranslateY(shape.getTranslateY()+t2);
			}
		}else{
			shape.setTranslateX(shape.getTranslateX()+event.getX());
			shape.setTranslateY(shape.getTranslateY()+event.getY());
		}
	}
}
