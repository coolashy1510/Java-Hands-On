package com.io.Java11.dev.code.LinkedList.Playlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        int index = trackNumber - 1;
        if ((index >= 0) && ( index <= songs.size())) {
            playList.add(songs.get(index));
            return true;
        }
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song song = findSong(title);
        if (song != null) {
            playList.add(song);
            return true;
        }
        return false;
    }

    /**
     * Searches for a song by title and returns the song if it exists.
     *
     * @param title the title of the song to search for
     * @return the song if it exists, null otherwise
     */
    private Song findSong(String title) {
        // Iterate through the list of songs
        for (Song song : songs) {
            // Check if the title matches the one we're looking for
            if (song.getTitle().equals(title)) {
                // Return the song if it exists
                return song;
            }
        }
        // Return null if no song is found
        return null;
    }
}
