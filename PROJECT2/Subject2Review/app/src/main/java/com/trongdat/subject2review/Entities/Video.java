package com.trongdat.subject2review.Entities;

import android.net.Uri;

/**
 * Created by Alone on 12/26/2016.
 */

public class Video {
    private String title;
    private Uri path;

    public String getTitle() {
        return title;
    }

    public Video setTitle(String title) {
        this.title = title;
        return this;
    }

    public Uri getPath() {
        return path;
    }

    public Video setPath(Uri path) {
        this.path = path;
        return this;
    }

    @Override
    public String toString() {
        return title;
    }
}
