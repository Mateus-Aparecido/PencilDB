package events;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polygon;

public class EntityDragEvent implements EventHandler<MouseEvent>{

	private Polygon polygon;

	public EntityDragEvent(Polygon polygon){
		this.polygon = polygon;
	}

	@Override
	public void handle(MouseEvent event) {
		double sizeX = polygon.getPoints().get(2);
		double sizeY = polygon.getPoints().get(5);

		if(polygon.getCursor().equals(Cursor.NW_RESIZE)){
			
			double incrementX = -event.getX();
			double incrementY = -event.getY();
			Double[] newSize = new Double[]{0.0, 0.0,sizeX+incrementX, 0.0,sizeX+incrementX, sizeY+incrementY,0.0, sizeY+incrementY};
			polygon.getPoints().setAll(newSize);
			polygon.setTranslateX(polygon.getTranslateX()-incrementX);
			polygon.setTranslateY(polygon.getTranslateY()-incrementY);
		}else if(polygon.getCursor().equals(Cursor.NE_RESIZE)){
			double incrementX = -event.getX();
			double incrementY = event.getY()-sizeY;
			Double[] newSize = new Double[]{0.0, 0.0,sizeX+incrementX, 0.0,sizeX+incrementX, sizeY+incrementY,0.0, sizeY+incrementY};
			polygon.getPoints().setAll(newSize);
			polygon.setTranslateX(polygon.getTranslateX()-incrementX);
		}else if(polygon.getCursor().equals(Cursor.SE_RESIZE)){
			double incrementX = event.getX()-sizeX;
			double incrementY = event.getY()-sizeY;
			Double[] newSize = new Double[]{0.0, 0.0,sizeX+incrementX, 0.0,sizeX+incrementX, sizeY+incrementY,0.0, sizeY+incrementY};
			polygon.getPoints().setAll(newSize);
		}else if(polygon.getCursor().equals(Cursor.SW_RESIZE)){
			double incrementX = event.getX()-sizeX;
			double incrementY = -event.getY();
			Double[] newSize = new Double[]{0.0, 0.0,sizeX+incrementX, 0.0,sizeX+incrementX, sizeY+incrementY,0.0, sizeY+incrementY};
			polygon.getPoints().setAll(newSize);
			polygon.setTranslateY(polygon.getTranslateY()-incrementY);
		}else{
			polygon.setTranslateX(polygon.getTranslateX()+event.getX()-sizeX/2);
			polygon.setTranslateY(polygon.getTranslateY()+event.getY()-sizeY/2);
		}
	}
}
