package com.trongdat.subject2review.Entities;

/**
 * Created by Alone on 12/27/2016.
 */

public class ContentSubject {
    int id, subjectID;
    String content, image, speak;

    public int getId() {
        return id;
    }

    public ContentSubject setId(int id) {
        this.id = id;
        return this;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public ContentSubject setSubjectID(int subjectID) {
        this.subjectID = subjectID;
        return this;
    }

    public String getContent() {
        return content;
    }

    public ContentSubject setContent(String content) {
        this.content = content;
        return this;
    }

    public String getImage() {
        return image;
    }

    public ContentSubject setImage(String image) {
        this.image = image;
        return this;
    }

    public String getSpeak() {
        return speak;
    }

    public ContentSubject setSpeak(String speak) {
        this.speak = speak;
        return this;
    }
}
