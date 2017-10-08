package com.trongdat.subject2review.Entities;

import android.net.Uri;

/**
 * Created by Alone on 12/26/2016.
 */

public class Audio {
    private String title;
    private Uri path;

    public String getTitle() {
        return title;
    }

    public Audio setTitle(String title) {
        this.title = title;
        return this;
    }

    public Uri getPath() {
        return path;
    }

    public Audio setPath(Uri path) {
        this.path = path;
        return this;
    }

    @Override
    public String toString() {
        return title;
    }
}
