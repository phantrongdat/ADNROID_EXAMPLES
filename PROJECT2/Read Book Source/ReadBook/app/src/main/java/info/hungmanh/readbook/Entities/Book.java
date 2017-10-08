package info.hungmanh.readbook.Entities;

import java.io.Serializable;

/**
 * Created by Alone on 10/8/2016.
 */
public class Book implements Serializable{
    private int id;
    private int categoryID;
    private String bookName;
    private String imageName;
    private String description;
    private int extranetID;
    private String author;
    private String detail;
    private int view;
    private int favorite;

    public Book() {
    }

    public Book(int id, int categoryID, String bookName, String imageName, String description, int extranet, String author, String detail, int view, int favorite) {
        this.id = id;
        this.categoryID = categoryID;
        this.bookName = bookName;
        this.imageName = imageName;
        this.description = description;
        this.extranetID = extranet;
        this.author = author;
        this.detail = detail;
        this.view = view;
        this.favorite = favorite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getExtranet() {
        return extranetID;
    }

    public void setExtranet(int extranet) {
        this.extranetID = extranet;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getFavorite() {
        return favorite;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }
}