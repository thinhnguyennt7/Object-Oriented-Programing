import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class TodoList extends Application {

	@Override 
	public void start(Stage stage) {
		ListView<String> listView = new ListView<String>();

		Button addButton = new Button("Add");

		TextField inputField = new TextField();

		HBox entryBox = new HBox();
		entryBox.getChildren().addAll(inputField, addButton);

		VBox vbox = new VBox();
		vbox.getChildren().addAll(listView, entryBox);

		// Main windows
		Scene scene = new Scene(vbox);
		stage.setTitle("Todo");
		stage.setScene(scene);
		stage.show();
	}
}