package info.hungmanh.readbook.Entities;

import java.io.Serializable;

/**
 * Created by Alone on 10/8/2016.
 */

public class Category implements Serializable {
    int id;
    String cateName;

    public Category() {
    }

    public Category(int id, String cateName) {
        this.id = id;
        this.cateName = cateName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    @Override
    public String toString() {
        return getCateName();
    }
}
