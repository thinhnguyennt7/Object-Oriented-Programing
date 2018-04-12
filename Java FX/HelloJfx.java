import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloJfx extends Application {
	public void start(Stage stage) {
		Label message = new Label("Hello, JavaFX");
		message.setFont(new Font(100));
		
		stage.setScene(new Scene(message));
		stage.setTitle("Hello");
		stage.show();
	}
}