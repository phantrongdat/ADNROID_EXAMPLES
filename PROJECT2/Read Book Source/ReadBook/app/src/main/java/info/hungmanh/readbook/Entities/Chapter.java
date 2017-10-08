package info.hungmanh.readbook.Entities;

import java.io.Serializable;

/**
 * Created by Alone on 10/8/2016.
 */

public class Chapter implements Serializable {
    int id, bookID;
    String chapName, detail;

    public Chapter() {
    }

    public Chapter(int id, int bookID, String chapName, String detail) {
        this.id = id;
        this.bookID = bookID;
        this.chapName = chapName;
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getChapName() {
        return chapName;
    }

    public void setChapName(String chapName) {
        this.chapName = chapName;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}