import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.layout.HBox;
import javafx.scene.control.ScrollBar;
import javafx.scene.text.Font;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Orientation;

import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

/**
* This is the music control player GUI
* @author tnguyen451
* @version 1.0
*/
public class MusicPlayer extends Application {

    // Initilize the variables
    Button clickPlay, clickPause, clickSearch, clickShow;
    MediaPlayer mediaplayer;
    Media musicFile;
    BorderPane pane;
    final HBox hb = new HBox();

    @Override
    public void start(Stage stage) {

        // Create a table view
        TableView table = new TableView();
        table.setEditable(true);
        table.setMinHeight(550);

        // Create columns for table
        TableColumn fileName = new TableColumn("File Name");
        TableColumn attri = new TableColumn("Attributes");
        TableColumn artist = new TableColumn("Artist");
        TableColumn title = new TableColumn("Title");
        TableColumn album = new TableColumn("Album");
                
        // Add the column to the table
        table.getColumns().addAll(fileName, attri);
        attri.getColumns().addAll(artist, title, album);

        // Set the size width of the column
        fileName.setMinWidth(400);
        attri.setMinWidth(600);
        artist.setMinWidth(200);
        title.setMinWidth(200);
        album.setMinWidth(200);

        // Set the column size can't editable
        fileName.setResizable(false);
        attri.setResizable(false);
        artist.setResizable(false);
        title.setResizable(false);
        album.setResizable(false);

        // Create Buttons
        clickPlay = new Button("Play");
        clickPause = new Button("Pause");
        clickSearch = new Button("Search Songs");
        clickShow = new Button("Show all Songs");
        hb.getChildren().addAll(clickPlay, clickPause, clickSearch, clickShow);
        hb.setSpacing(5);

        // Import music
        // Media musicFile = new Media("Bittersweet.mp3");
        // mediaplayer = new MediaPlayer(musicFile);

        // Functions for each Buttons
        clickPlay.setOnAction(event -> {
            System.out.println("Music is playing!!!");
        });

        // clickPlay.setOnAction(new EventHandler<ActionEvent>() {
        //     @Override
        //     public void handle(ActionEvent song) {
        //         // mediaplayer.play();
        //         System.out.println("Music is playing!!!");
        //     }
        // });

        // Create horizontal scrol bar
        ScrollBar scroll = new ScrollBar();
        scroll.setMin(0);
        scroll.setMax(100);
        scroll.setOrientation(Orientation.HORIZONTAL);

        // Vertical Box
        final VBox root = new VBox();
        root.getChildren().addAll(table, scroll, hb);

        //Creating a scene object 
        Scene scene = new Scene(new Group());
        stage.setWidth(1000);
        stage.setHeight(620);
        ((Group) scene.getRoot()).getChildren().addAll(root);

        // Main stage
        stage.setTitle("Music Player");
        stage.setScene(scene);
        stage.show();
    }

    /**
    * The main test for Application
    * @param args Take in an args
    */
    public static void main(String[] args) { launch(args); }
}