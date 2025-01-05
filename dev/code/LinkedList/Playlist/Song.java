package com.io.Java11.dev.code.LinkedList.Playlist;

public class Song {

    private String title;
    private double duration;

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    /**
     * Return the title of the song.
     *
     * @return the title of the song
     */
    public String getTitle() {
        return title;
    }

    /**
     * Return a string representation of the song.
     *
     * @return a string representation of the song
     */
    public String toString() {
        return title + ": " + duration;
    }
}
