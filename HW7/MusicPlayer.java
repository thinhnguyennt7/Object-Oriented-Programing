import java.io.File;
import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener.Change;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
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
import javafx.util.Duration;

/**
* This is the music control player GUI. It will appear the GUI interface.
* @author tnguyen451
* @version 1.0
*/
public class MusicPlayer extends Application {

    private Button clickPlay, clickPause, clickSearch, clickShow;
    private Media musicFile;
    private MediaPlayer mediaplayer;
    private ObservableList<Song> data = FXCollections.observableArrayList();
    private ObservableList<Song> songSearch = FXCollections.observableArrayList(
        );
    private String theCurrentSong;
    private boolean isPlaying = false;
    private TableView<Song> table = new TableView<Song>();
    private static enum Choices { Artist, Album, Title, FileName }

    @Override
    public void init() {
        File currentDir = new File("").getAbsoluteFile();
        File[] filesList = currentDir.listFiles();
        for (File file : filesList) {
            if (file.isFile() && file.getName().contains(".mp3")) {
                data.add(new Song(file));
            }
        }
    }

    @Override
    public void start(Stage stage) {

        setTableView();
        table.setItems(data);

        // Create UI Buttons
        createButtons();

        // Disable button functionalites if there is no data
        if (data.size() == 0) {
            clickPlay.setDisable(true);
            clickSearch.setDisable(true);
        }

        // Adding components to the Horizontal line
        final HBox hb = new HBox();
        hb.getChildren().addAll(clickPlay, clickPause, clickSearch, clickShow);
        hb.setSpacing(5);


        // This method helper will help user to collect the song data for every
        // single row. Then it will set the song file to the Media and then it
        // will parse the Media to the Player to make it playable
        table.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1) {
                    clickPlay.setDisable(false);
                    if (table.getSelectionModel().getSelectedItem() != null) {
                        Song selectedSong = table.getSelectionModel()
                            .getSelectedItem();
                        theCurrentSong = (String) selectedSong.getFilename();
                        if (theCurrentSong != null) {
                            musicFile = new Media(getClass().getResource(
                                theCurrentSong).toExternalForm());
                            mediaplayer = new MediaPlayer(musicFile);
                        }
                    }
                }
            });

        // If Music is playing then pause button will visible
        if (!isPlaying) {
            clickPause.setDisable(true);
        }

        // BUTTON FUNCTIONALITIES
        clickPlay.setOnAction(event -> {
                play();
            });

        clickPause.setOnAction(event -> {
                pause();
            });

        clickSearch.setOnAction(event -> {
                searchFunction();
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
        stage.setHeight(600);
        ((Group) scene.getRoot()).getChildren().addAll(root);

        // Main stage setting
        stage.setTitle("Music Player");
        stage.setScene(scene);
        table.refresh();
        stage.show();
    }

    private void createButtons() {
        clickPause = new Button("Pause");
        clickPause.setDisable(true);
        clickPlay = new Button("Play");
        clickSearch = new Button("Search Songs");
        clickShow = new Button("Show all Songs");
        clickShow.setDisable(true);
    }

    /**
     * This method helper generate the pause button
     */
    private void pause() {
        isPlaying = false;
        clickPause.setDisable(true);
        mediaplayer.pause();
        System.out.println("Music is pausing!!!");
    }

    /**
     * This method helper generate the play button
     */
    private void play() {
        if (musicFile != null) {
            isPlaying = true;
            mediaplayer.setStartTime(Duration.seconds(0));
            mediaplayer.play();
            System.out.println("Music is playing!!!");
            clickPause.setDisable(false);
        }
    }

    /**
     * This method helper generete the search functions
     * It will search for any song title, song artist, album.
     * Then it will display the the table view the result any song that have
     * the same keywords that match
     * Otherwise it will return the table with an empty include the message
     */
    private void searchFunction() {
        Dialog<Options> dialog = new Dialog<>();
        dialog.setTitle("Search for Song");
        dialog.setHeaderText("Please choose and type");
        DialogPane dialogPane = dialog.getDialogPane();
        dialogPane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        TextField textField = new TextField("Keyword...");
        ObservableList<Choices> choices = FXCollections
            .observableArrayList(Choices.values());
        ComboBox<Choices> comboBox = new ComboBox<>(choices);
        comboBox.getSelectionModel().selectFirst();
        dialogPane.setContent(new VBox(8, comboBox, textField));
        Platform.runLater(textField::requestFocus);
        dialog.setResultConverter((ButtonType button) -> {
                if (button == ButtonType.OK) {
                    return new Options(textField.getText(),
                        comboBox.getValue());
                }
                return null;
            });
        Optional<Options> result = dialog.showAndWait();
        if (result.isPresent()) {
            Options valueOut = result.get();
            clickShow.setDisable(false);
            songSearch.clear();
            if (valueOut.getText().equals("")) {
                clickShow.setDisable(true);
            } else {
                for (int i = 0; i < data.size(); i++) {
                    if (valueOut.getChoices().toString()
                            .equals("Artist")) {
                        if (data.get(i).getArtist() == null) {
                            continue;
                        } else if (data.get(i).getArtist().toUpperCase()
                            .contains(valueOut.getText()
                                .toUpperCase())) {
                            songSearch.add(data.get(i));
                        }
                    } else if (valueOut.getChoices().toString()
                        .equals("Title")) {
                        if (data.get(i).getTitle() == null) {
                            continue;
                        } else if (data.get(i).getTitle().toUpperCase()
                            .contains(valueOut.getText()
                                .toUpperCase())) {
                            songSearch.add(data.get(i));
                        }
                    } else if (valueOut.getChoices().toString()
                        .equals("Album")) {
                        if (data.get(i).getAlbum() == null) {
                            continue;
                        } else if (data.get(i).getAlbum().toUpperCase()
                            .contains(valueOut.getText()
                                .toUpperCase())) {
                            songSearch.add(data.get(i));
                        }
                    } else {
                        if (data.get(i).getFilename() == null) {
                            continue;
                        } else if (data.get(i).getFilename()
                                .toUpperCase().contains(valueOut
                                .getText().toUpperCase())) {
                            songSearch.add(data.get(i));
                        }
                    }
                }
                table.setItems(songSearch);
            }
        }
    }

    /**
     * This method helper is generate and creating the basic type of table view
     * Also it taking action to set the values to the table
     * The values are the album, the artist, the filename and the title
     */
    @SuppressWarnings("unchecked")
    private void setTableView() {
        // Create columns for table
        TableColumn<Song, String> album = new TableColumn("Album");
        TableColumn<Song, String> artist = new TableColumn("Artist");
        TableColumn<Song, String> attri = new TableColumn("Attributes");
        TableColumn<Song, String> fileName = new TableColumn("File Name");
        TableColumn<Song, String> title = new TableColumn("Title");

        // Set the values for each column depend on the variables
        album.setCellValueFactory(new PropertyValueFactory<Song,
            String>("album"));
        artist.setCellValueFactory(new PropertyValueFactory<Song,
            String>("artist"));
        fileName.setCellValueFactory(new PropertyValueFactory<Song,
            String>("filename"));
        title.setCellValueFactory(new PropertyValueFactory<Song,
            String>("title"));

        // Refresh the table
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                refeshTable();
            }
        });

        // Set table styles, size.
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
    }

    /**
    * Options function that help to select the choices from the magic enum
    * This options choice has two getter methods that help user to be able to
    * get the data of the choices
    */
    private static class Options {
        private String text;
        private Choices choices;

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
    * This class will get the data for the song such as the filename, the title,
    * the album, the artist
    */
    public static class Song {

        private File file;
        private Media music;
        private String album;
        private String artist;
        private String filename;
        private String title;

        /**
        * Song constructor that generate of the values for each variables
        * It will take in the song file in the current directory and then
        * generate the song to parse the basic metadata to the instance vars
        * @param file Take in a music file
        */
        public Song(File file) {
            music = new Media(getClass().getResource(file.getName()
                ).toExternalForm());
            music.getMetadata().addListener(new MapChangeListener<String,
                Object>() {
                @Override
                public void onChanged(Change<? extends String,
                    ? extends Object> ch) {
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
    * It will go to every single line in the table and turn the visible off and
    * on to refresh it again.
    */
    private void refeshTable() {
        if (table != null) {
            ObservableList<TableColumn<Song, ?>> columns = table.getColumns();
            for (TableColumn<Song, ?> column : columns) {
                if (column.getText().equals("File Name")) {
                    column.setVisible(false);
                    column.setVisible(true);
                }
            }
        }
    }

    /**
    * The main test for Application
    * @param args Take in an args
    */
    public static void main(String[] args) {
        launch(args);
    }
}