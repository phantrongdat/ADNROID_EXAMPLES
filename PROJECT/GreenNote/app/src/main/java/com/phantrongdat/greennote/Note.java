package com.phantrongdat.greennote;

import java.util.Date;

/**
 * Created by Alone on 04/11/2016.
 */
public class Note {
    private int id;
    private String title;
    private String content;
    private Date date;
    private String location;

    public Note() {
    }

    public Note(int id, String title, String content, Date date, String location) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.location = location;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Date getDate() {
        return date;
    }
}
