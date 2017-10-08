package com.trongdat.subject2review.Entities;

/**
 * Created by Alone on 12/27/2016.
 */

public class Subject {
    private int id;
    private String subjectName;

    public int getId() {
        return id;
    }

    public Subject setId(int id) {
        this.id = id;
        return this;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public Subject setSubjectName(String tenBaiHoc) {
        this.subjectName = tenBaiHoc;
        return this;
    }

    @Override
    public String toString() {
        return subjectName;
    }
}
