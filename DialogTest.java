import java.time.LocalDate;
import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @see http://stackoverflow.com/q/44147595/230513
 * @see http://www.javaworld.com/article/2991463/
 */
public class DialogTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        Dialog<Results> dialog = new Dialog<>();
        dialog.setTitle("Dialog Test");
        dialog.setHeaderText("Please specify…");
        DialogPane dialogPane = dialog.getDialogPane();
        dialogPane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        TextField textField = new TextField("Name");
        DatePicker datePicker = new DatePicker(LocalDate.now());
        ObservableList<Venue> options =
            FXCollections.observableArrayList(Venue.values());
        ComboBox<Venue> comboBox = new ComboBox<>(options);
        comboBox.getSelectionModel().selectFirst();
        dialogPane.setContent(new VBox(8, textField, datePicker, comboBox));
        Platform.runLater(textField::requestFocus);
        dialog.setResultConverter((ButtonType button) -> {
            if (button == ButtonType.OK) {
                return new Results(textField.getText(),
                    datePicker.getValue(), comboBox.getValue());
            }
            return null;
        });
        Optional<Results> optionalResult = dialog.showAndWait();
        optionalResult.ifPresent((Results results) -> {
            System.out.println(
                results.text + " " + results.date + " " + results.venue);
        });
    }

    private static enum Venue {Here, There, Elsewhere}

    private static class Results {

        String text;
        LocalDate date;
        Venue venue;

        public Results(String name, LocalDate date, Venue venue) {
            this.text = name;
            this.date = date;
            this.venue = venue;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}