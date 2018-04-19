import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.scene.control.cell.PropertyValueFactory;
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
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ChoiceDialog;

import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.util.Optional;

/**
* This is the music control player GUI
* @author tnguyen451
* @version 1.0
*/
public class MusicPlayer extends Application {

    /**
    * The main test for Application
    * @param args Take in an args
    */
    public static void main(String[] args) { launch(args); }

    // Initilize the variables
    Button clickPlay, clickPause, clickSearch, clickShow;
    MediaPlayer mediaplayer;
    Media musicFile;
    String theCurrentSong;
    BorderPane pane;
    final HBox hb = new HBox();
    boolean isPlaying = false;
    ObservableList<Song> songSearch = FXCollections.observableArrayList();

    // for (File file:fList) {
    // for (int i = 0; i < 1: i++) {

    // }
        // if (file.getName().contains("mp3")) {
    // System.out.println(fList);
        // } 
    // }
    private void getFile() {
        File directory = new File("/Users/thinhnguyen/Dropbox/Spring 2018 - GA Tech/CS1331/Object-Oriented-Programing/HW7");
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.getName().contains("mp3")) {
                System.out.println(file.getName());
            }
        }
    }

    private final ObservableList<Song> data =
        FXCollections.observableArrayList(
            new Song("Bittersweet.mp3", "Kevin MacLeod", "Bittersweet", ""),
            new Song("BossaBossa.mp3", "Kevin MacLeod", "BossaBossa", ""),
            new Song("JoshWoodward-Ashes-07-AlreadyThere.mp3", "Josh Woodward", "Already There", "Ashes"),
            new Song("JoshWoodward-AttS-01-Release.mp3", "Josh Woodward", "Release", "Addressed to the Stars"),
            new Song("Overworld.mp3", "Kevin MacLeod", "Overworld", ""),
            new Song("Airplanes.mp3", "Hayley Williams", "Airplanes", "Top 40 USA - 2010")
        );

    // Create a table view
    private TableView<Song> table = new TableView<Song>();

    @SuppressWarnings("unchecked")
    @Override
    public void start(Stage stage) {
        table.setEditable(true);
        table.setMinHeight(550);

        // Create columns for table
        TableColumn fileName = new TableColumn("File Name");
        fileName.setCellValueFactory(new PropertyValueFactory<Song,String>("filename"));
        TableColumn attri = new TableColumn("Attributes");
        TableColumn artist = new TableColumn("Artist");
        artist.setCellValueFactory(new PropertyValueFactory<Song,String>("artist"));
        TableColumn title = new TableColumn("Title");
        title.setCellValueFactory(new PropertyValueFactory<Song,String>("title"));
        TableColumn album = new TableColumn("Album");
        album.setCellValueFactory(new PropertyValueFactory<Song,String>("album"));
                
        table.setItems(data);
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
        clickPause.setDisable(true);
        clickSearch = new Button("Search Songs");
        clickShow = new Button("Show all Songs");

        // Disable button functionalites
        if (data.size() == 0) {
            clickPlay.setDisable(true);
            clickSearch.setDisable(true);
            clickShow.setDisable(true);
        }

        hb.getChildren().addAll(clickPlay, clickPause, clickSearch, clickShow);
        hb.setSpacing(5);

        // Get data when click on row
        table.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                clickPlay.setDisable(false);
                if (table.getSelectionModel().getSelectedItem() != null) {
                    Song selectedSong = table.getSelectionModel().getSelectedItem();
                    theCurrentSong = (String) selectedSong.getFilename();
                    if (theCurrentSong != null) {
                        musicFile = new Media(getClass().getResource(theCurrentSong).toExternalForm());
                        mediaplayer = new MediaPlayer(musicFile);
                    }
                    System.out.println("The Current Song: " + theCurrentSong);
                }
            } else if (event.getClickCount() == 2) {
                if (isPlaying == true || isPlaying == false) {
                    mediaplayer.stop();
                    if (table.getSelectionModel().getSelectedItem() != null) {
                        Song selectedSong = table.getSelectionModel().getSelectedItem();
                        theCurrentSong = (String) selectedSong.getFilename();
                        if (theCurrentSong != null) {
                            musicFile = new Media(getClass().getResource(theCurrentSong).toExternalForm());
                            mediaplayer = new MediaPlayer(musicFile);
                            mediaplayer.play();
                            clickPause.setDisable(false);
                            isPlaying = true;
                        }
                        System.out.println("The Current Song: " + theCurrentSong);
                    } 
                }
            }
        });

        // Get metadata for the song
        // mediaplayer.setOnReady(() -> {
        //     ObservableMap<String, Object> ol = musicFile.getMetadata();
        //     // Object value = ol.get("Composer"); 
        //     // System.out.println(ol);
        // });

        if (!isPlaying) {
            clickPause.setDisable(true);
        }

        // Functions for each Buttons
        clickPlay.setOnAction(event -> {
            isPlaying = true;
            mediaplayer.play();
            clickPause.setDisable(false);
            System.out.println("Music is playing!!!");
        });

        clickPause.setOnAction(event -> {
            isPlaying = false;
            clickPause.setDisable(true);
            mediaplayer.pause();
            System.out.println("Music is pausing!!!");
        });

        clickSearch.setOnAction(event -> {

            // String [] arrayData = {"Title", "Artist", "Album"};
            // List<String> dialogData;
            // dialogData = Arrays.asList(arrayData);

            // Dialog box
            TextInputDialog dialog = new TextInputDialog("Type some thing...");
            // dialog = new ChoiceDialog(dialogData.get(0), dialogData);
            dialog.setTitle("Search box");
            dialog.setHeaderText("Type the name to search for the song");
            dialog.setContentText("Please enter the artist:");
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()) {
                for (int i = 0; i < data.size(); i++) {
                    if (data.get(i).getArtist().contains(result.get())) {
                        // System.out.println(data.get(i));
                        // System.out.println(data.get(i).getFilename());
                        songSearch.add(data.get(i));
                    }
                }
                System.out.println(songSearch);
            }
        });

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

    public static class Song {
        private String filename;
        private String artist;
        private String title;
        private String album;

        // Song constructor
        public Song (String filename, String artist, String title, String album) {
            this.filename = filename;
            this.artist = artist;
            this.title = title;
            this.album = album;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

        public void setArtist(String artist) {
            this.artist = artist;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setAlbum(String album) {
            this.album = album;
        }

        public String getAlbum() {
            return album;
        }

        public String getTitle() {
            return title;
        }

        public String getArtist() {
            return artist;
        }

        public String getFilename() {
            return filename;
        }

        // public String toString() {
        //     return artist;
        // }
    }
}