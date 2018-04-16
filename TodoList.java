import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TodoList extends Application {

	@Override 
	public void start(Stage stage) {

		ObservableList<String> todos = FXCollections.observableArrayList();


		ListView<String> listView = new ListView<String>(todos);

		Button addButton = new Button("Add");

		TextField inputField = new TextField();

		// Button function
		addButton.setOnAction(event -> {
			todos.add(inputField.getText());
			inputField.setText("");
			inputField.requestFocus(); // We can countinue to type in the input file
			System.out.println("Add new Todo");
		});

		HBox entryBox = new HBox();
		entryBox.getChildren().addAll(inputField, addButton);

		VBox vbox = new VBox(); // As the root node
		vbox.getChildren().addAll(listView, entryBox);

		// Main windows
		Scene scene = new Scene(vbox);
		stage.setTitle("Todos");
		stage.setScene(scene);
		stage.show();
	}

}