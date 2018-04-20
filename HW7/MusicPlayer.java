import java.io.File;
import java.util.List;
import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener.Change;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
* This is the music control player GUI
* @author tnguyen451
* @version 1.0
*/
public class MusicPlayer extends Application {

    Button clickPlay, clickPause, clickSearch, clickShow;
    Media musicFile;
    MediaPlayer mediaplayer;
    ObservableList<Song> data = FXCollections.observableArrayList();
    ObservableList<Song> songSearch = FXCollections.observableArrayList();
    String theCurrentSong;
    boolean isPlaying = false;
    private TableView<Song> table = new TableView<Song>();
    private static enum Choices {Artist, Album, Title}

    @Override
    public void init() {
        File currentDir = new File("").getAbsoluteFile();
        File[] filesList = currentDir.listFiles();
        for (File file : filesList) {
            if (file.isFile() && file.getName().contains(".mp3")) {
                System.out.println(file.getName());
                data.add(new Song(file));
            }
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void start(Stage stage) {

        // Create columns for table
        TableColumn album = new TableColumn("Album");
        TableColumn artist = new TableColumn("Artist");
        TableColumn attri = new TableColumn("Attributes");
        TableColumn fileName = new TableColumn("File Name");
        TableColumn title = new TableColumn("Title");

        // Set the values for each column depend on the variables
        album.setCellValueFactory(new PropertyValueFactory<Song, String>("album"));
        artist.setCellValueFactory(new PropertyValueFactory<Song, String>("artist"));
        fileName.setCellValueFactory(new PropertyValueFactory<Song, String>("filename"));
        title.setCellValueFactory(new PropertyValueFactory<Song, String>("title"));

        // Refresh the table
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                 refeshTable();
            }
        });

        // Table styles, size.
        album.setMinWidth(200);
        album.setResizable(false);
        artist.setMinWidth(200);
        artist.setResizable(false);
        attri.getColumns().addAll(artist, title, album);
        attri.setMinWidth(600);
        attri.setResizable(false);
        fileName.setMinWidth(400);
        fileName.setResizable(false);
        table.getColumns().addAll(fileName, attri);
        table.setEditable(true);
        table.setMinHeight(550);
        title.setMinWidth(200);
        title.setResizable(false);

        // Set the value for the table
        table.setItems(data);

        // Create UI Buttons
        clickPause = new Button("Pause");
        clickPause.setDisable(true);
        clickPlay = new Button("Play");
        clickSearch = new Button("Search Songs");
        clickShow = new Button("Show all Songs");
        clickShow.setDisable(true);

        // Disable button functionalites if there is no data
        if (data.size() == 0) {
            clickPlay.setDisable(true);
            clickSearch.setDisable(true);
        }

        // Adding components to the Horizontal line
        final HBox hb = new HBox();
        hb.getChildren().addAll(clickPlay, clickPause, clickSearch, clickShow);
        hb.setSpacing(5);

        // Click the row to choose the song to play
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

        // If Music is playing then Pause will visible
        if (!isPlaying) {
            clickPause.setDisable(true);
        }

        // Create the function for each buttons
        clickPlay.setOnAction(event -> {
            // musicFile = new Media(getClass().getResource("JoshWoodward-Ashes-07-AlreadyThere.mp3").toExternalForm());
            // mediaplayer = new MediaPlayer(musicFile);
            if (musicFile != null) {
                isPlaying = true;
                mediaplayer.play();
                System.out.println("Music is playing!!!");
                clickPause.setDisable(false);
            }
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
            dialogPane.setContent(new VBox(8, comboBox, textField));
            Platform.runLater(textField::requestFocus);
            dialog.setResultConverter((ButtonType button) -> {
                if (button == ButtonType.OK) {
                    return new Options(textField.getText(), comboBox.getValue());
                }
                return null;
            });

            Optional<Options> result = dialog.showAndWait();
            if (result.isPresent()) {
                Options valueOut = result.get();
                clickShow.setDisable(false);
                System.out.println("Message: " + valueOut.getText());
                System.out.println("Options: " + valueOut.getChoices().toString());
                songSearch.clear();
                for (int i = 0; i < data.size(); i++) {
                    if (valueOut.getChoices().toString().equals("Artist")) {
                        if (data.get(i).getArtist() == null) {
                            continue;
                        } else if (data.get(i).getArtist().toUpperCase().contains(valueOut.getText().toUpperCase())) {
                            System.out.println(data.get(i).getFilename());
                            songSearch.add(data.get(i));
                        }
                    } else if (valueOut.getChoices().toString().equals("Title")) {
                        if (data.get(i).getTitle() == null) {
                            continue;
                        } else if (data.get(i).getTitle().toUpperCase().contains(valueOut.getText().toUpperCase())) {
                            System.out.println(data.get(i).getFilename());
                            songSearch.add(data.get(i));
                        }
                    } else {
                        if (data.get(i).getAlbum() == null) {
                            continue;
                        } else if (data.get(i).getAlbum().toUpperCase().contains(valueOut.getText().toUpperCase())) {
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

        // Adding components to the Vertical line
        final VBox root = new VBox();
        root.getChildren().addAll(table, hb);

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
    *
    *
    */
    private static class Options {
        String text;
        Choices choices;

        /**
        * Options constructor that pass in values for each variables
        * @param text Take in the search message
        * @param choices Take in the value of the options choice
        */
        public Options(String text, Choices choices) {
            this.text = text;
            this.choices = choices;
        }

        /**
        * Getter method for text
        * @return String Return the text
        */
        public String getText() {
            return text;
        }

        /**
        * Getter method for choices
        * @return String Return the choices
        */
        public Choices getChoices() {
            return choices;
        }
    }

    /**
    * Song class that generate each song
    */
    public static class Song {

        private File file;
        private Media music;
        private String album;
        private String artist;
        private String filename;
        private String title;

        /**
        * Song constructor that generate and pass in the values for each variables
        * @param file Take in a music file
        *
        */
        public Song (File file) {
            music = new Media(getClass().getResource(file.getName()).toExternalForm());
            music.getMetadata().addListener(new MapChangeListener<String, Object>() {
                @Override
                public void onChanged(Change<? extends String, ? extends Object> ch) {
                    filename = (String) file.getName();
                    if (ch.wasAdded()) {
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

        /**
        * Getter method for album
        * @return String return the album value
        */
        public String getAlbum() {
            return this.album;
        }

        /**
        * Getter method for title
        * @return String return the title value
        */
        public String getTitle() {
            return this.title;
        }

        /**
        * Getter method for artist
        * @return String return the album value
        */
        public String getArtist() {
            return this.artist;
        }

        /**
        * Getter method for filename
        * @return String return the filename value
        */
        public String getFilename() {
            return this.filename;
        }
    }

    /**
    * Helper method for the refeshTable function
    * It will check and reappear the column values again
    */
    private void refeshTable() {
        if (table != null) {
            ObservableList<TableColumn<Song, ?>> columns = table.getColumns();
            for (TableColumn<Song, ?> column : columns) {
                if (column.getText().equals("File Name")) {
                    // column.setVisible(false);
                    column.setVisible(true);
                }
            }
        }
    }

    /**
    * The main test for Application
    * @param args Take in an args
    */
    public static void main(String[] args) { launch(args); }
}