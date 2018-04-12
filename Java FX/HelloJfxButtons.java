import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
class Button {
	EventHandler<ActionEvent> listenter;
	public void setOnAction(EventHandler<ActionEvent> handler) {
		listener = handler;
	}
	public void iGotClicked(ActionEvent evt) {
		listener.handle(evt); // Callback function
	}

}
*/

public class HelloJfxButtons extends Application {
	int count = 0;

	@Override 
	public void start(Stage stage) {
		Label counterLabel = new Label("Count: 0"); // just for display
		Button incButton = new Button("Increment count");
		Label reset = new Label("Click to reset");
		Button resetButton= new Button("Reset");

		// Lambda expression
		incButton.setOnAction(event -> {
			counterLabel.setText("Count: " + (++count)); // If we want to change the label display we have to call setText
		});

		// OR Anonymous inner class
		// incButton.setOnAction(new EventHandler<ActionEvent>() {
		// 	public void handle(ActionEvent e) {
		// 		counterLabel.setText("Count: " + (++count));
		// 	}
		// });

		VBox root = new VBox(); //Vertical box
		root.getChildren().addAll(incButton, counterLabel); // incButton will be ontop and counterLabel will be bottom
		Scene scene = new Scene(root);

		stage.setScene(scene); //set stage
		stage.setTitle("Hello");
		stage.show();
	}
}

