package panels;

import events.DrawingEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class Drawing extends StackPane{
	
	public Drawing(){
		
		this.setId("background");
		this.setCursor(Cursor.DEFAULT);
		this.setOnMouseClicked(new DrawingEvent(this));
	}
}
