package info.trongdat.accountmanager;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Alone on 4/20/2017.
 */

public class User implements Serializable {
    @SerializedName("id")
    int id;
    @SerializedName("username")
    String username;
    @SerializedName("password")
    String password;
    @SerializedName("name")
    String name;

    public User(int id, String username, String password, String name) {
        if (id != 0)
            this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
    }

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

    @Override
    public String toString() {
        return id + "\n" + username + "\n" + name;
    }


}
