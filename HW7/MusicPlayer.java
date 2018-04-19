import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
// import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
// import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
// import javafx.stage.FileChooser;
// import javafx.scene.text.Font;
// import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.collections.MapChangeListener;
import javafx.collections.MapChangeListener.Change;

import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.util.Optional;
// import java.nio.file.Path;
// import java.nio.file.Paths;

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
    // BorderPane pane;
    final HBox hb = new HBox();
    boolean isPlaying = false;
    ObservableList<Song> songSearch = FXCollections.observableArrayList();
    ObservableList<Song> data = FXCollections.observableArrayList();
    private static enum Choices {Artist, Album, Title}
    private TableView<Song> table = new TableView<Song>();

    @Override
    public void init() {
        // Check all the files in the folder and get all the file mp3
        File currentDir = new File("").getAbsoluteFile();
        File[] filesList = currentDir.listFiles();
        for (File file : filesList) {
            if (file.isFile() && file.getName().contains(".mp3")) {
                data.add(new Song(file));
            }
        }
    }

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
        clickShow.setDisable(true);

        // Disable button functionalites
        if (data.size() == 0) {
            clickPlay.setDisable(true);
            clickSearch.setDisable(true);
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
            Dialog<Options> dialog = new Dialog<>();
            dialog.setTitle("Search for Song");
            dialog.setHeaderText("Please choose and type");
            DialogPane dialogPane = dialog.getDialogPane();
            dialogPane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
            TextField textField = new TextField("Keyword...");
            ObservableList<Choices> choices = FXCollections.observableArrayList(Choices.values());
            ComboBox<Choices> comboBox = new ComboBox<>(choices);
            comboBox.getSelectionModel().selectFirst();
            dialogPane.setContent(new VBox(8, textField, comboBox));
            Platform.runLater(textField::requestFocus);
            dialog.setResultConverter((ButtonType button) -> {
                if (button == ButtonType.OK) {
                    return new Options(textField.getText(), comboBox.getValue());
                }
                return null;
            });

            Optional<Options> result = dialog.showAndWait();
            Options valueOut = result.get();
            if (result.isPresent()) {
                clickShow.setDisable(false);
                System.out.println("Message: " + valueOut.getText());
                System.out.println("Options: " + valueOut.getChoices().toString());
                songSearch.clear();
                for (int i = 0; i < data.size(); i++) {
                    if (valueOut.getChoices().toString().equals("Artist")) {
                        if (data.get(i).getArtist().contains(valueOut.getText())) {
                            System.out.println(data.get(i).getFilename());
                            songSearch.add(data.get(i));
                        }
                    } else if (valueOut.getChoices().toString().equals("Album")) {
                        if (data.get(i).getAlbum().contains(valueOut.getText())) {
                            System.out.println(data.get(i).getFilename());
                            songSearch.add(data.get(i));
                        }
                    } else {
                        if (data.get(i).getTitle().contains(valueOut.getText())) {
                            System.out.println(data.get(i).getFilename());
                            songSearch.add(data.get(i));
                        }
                    }
                }
                table.setItems(songSearch);
            }
        });

        clickShow.setOnAction(event -> {
            table.setItems(data);
            clickShow.setDisable(true);
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

    private static class Options {
        String text;
        Choices choices;

        public Options(String text, Choices choices) {
            this.text = text;
            this.choices = choices;
        }

        public String getText() {
            return text;
        }

        public Choices getChoices() {
            return choices;
        }
    }

    public static class Song {
        private String filename;
        private String artist;
        private String title;
        private String album;
        private File file;
        private Media music;

        // Song constructor
        public Song (File file) {
            music = new Media(getClass().getResource(file.getName()).toExternalForm());
            music.getMetadata().addListener(new MapChangeListener<String, Object>() {
                @Override
                public void onChanged(Change<? extends String, ? extends Object> ch) {
                    if (ch.wasAdded()) {
                        filename = (String) file.getName();
                        if (ch.getKey().equals("artist")) {
                            artist = (String) ch.getValueAdded();
                        } else if (ch.getKey().equals("album")) {
                            album = (String) ch.getValueAdded();
                        } else if (ch.getKey().equals("title")) {
                            title = (String) ch.getValueAdded();
                        }
                    }
                }
            });
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
    }
}