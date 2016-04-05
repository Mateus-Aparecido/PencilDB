package events;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polygon;

public class EntityMoveEvent implements EventHandler<MouseEvent>{

	private Polygon polygon;

	public EntityMoveEvent(Polygon polygon) {
		this.polygon = polygon;
	}

	@Override
	public void handle(MouseEvent event) {
		double width = polygon.getPoints().get(2);
		double height = polygon.getPoints().get(5);
		double mouseX = event.getX();
		double mouseY = event.getY();
		if(width-mouseX+5 >= width && height-mouseY+5 >= height){
			polygon.setCursor(Cursor.NW_RESIZE);
		}else if(width-mouseX+5 >= width && height-mouseY <= 5){
			polygon.setCursor(Cursor.NE_RESIZE);
		}else if(width - mouseX <= 5 && height-mouseY <= 5){
			polygon.setCursor(Cursor.SE_RESIZE);
		}else if(width - mouseX <= 5 && height-mouseY+5 >= height){
			polygon.setCursor(Cursor.SW_RESIZE);
		}else{
			polygon.setCursor(Cursor.DEFAULT);
		}
	}
}
