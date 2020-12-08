package com.streamapi;

public class Movies
{
    private String title;
    private int likes;
    private Genre genre;

    public Movies(String title, int likes, Genre genre)
    {
        this.title = title;
        this.likes = likes;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public int getLikes() {
        return likes;
    }

    public Genre getGenre()
    {
        return genre;
    }
}
