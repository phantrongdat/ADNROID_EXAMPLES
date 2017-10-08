package com.example.alone.amthucappclient;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Alone on 4/27/2017.
 */

public class TaiKhoan {
    @SerializedName("id")
    int id;
    @SerializedName("username")
    String username;
    @SerializedName("password")
    String password;
    @SerializedName("name")
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
