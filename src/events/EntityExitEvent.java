package events;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class EntityExitEvent implements EventHandler<MouseEvent>{

	private StackPane panel;
	
	public EntityExitEvent(StackPane panel) {
		this.panel = panel;
	}
	
	@Override
	public void handle(MouseEvent event) {
		panel.setCursor(Cursor.DEFAULT);
		
	}

	
}
