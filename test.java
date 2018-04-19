package application;

import java.io.File;

import javafx.collections.MapChangeListener;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Song {
private File file;
private String title;
private String artist;
private String album;
private Media music;
private MediaPlayer mp;

public Song(File file) {
    music = new Media(file.toURI().toString());

    music.getMetadata().addListener((Change<? extends String, ? extends Object> c) -> {
        if (c.wasAdded()) {
            if ("artist".equals(c.getKey())) {
                artist = c.getValueAdded().toString();
            } else if ("title".equals(c.getKey())) {
                title = c.getValueAdded().toString();
            } else if ("album".equals(c.getKey())) {
                album = c.getValueAdded().toString();
            }
        }
    });

    mp = new MediaPlayer(music);

}


public void play() {
    mp.play();
}

public void pause() {
    mp.pause();
}

public void stop() {
    mp.stop();
}

public String getTitle(){
    return title;
}

public String getArtist(){
    return artist;
}

public String getAlbum(){
    return album;
}



// Get metadata for the song
        // mediaplayer.setOnReady(() -> {
        //     ObservableMap<String, Object> ol = musicFile.getMetadata();
        //     // Object value = ol.get("Composer"); 
        //     // System.out.println(ol);
        // });

comment-1
comment-0
artist
year
raw metadata
album
comment-2
title
comment-0
artist


}