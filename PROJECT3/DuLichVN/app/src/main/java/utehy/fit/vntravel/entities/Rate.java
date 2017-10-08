package utehy.fit.vntravel.entities;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Admin on 4/6/2017.
 */

public class Rate implements Serializable {
    @SerializedName("IDUser")
    int IDUser;
    @SerializedName("IDDiaDiem")
    int IDDiaDiem;
    @SerializedName("SoDiem")
    float SoDiem;

    public Rate() {
    }

    public Rate(int IDUser, int IDDiaDiem, float soDiem) {
        this.IDUser = IDUser;
        this.IDDiaDiem = IDDiaDiem;
        SoDiem = soDiem;
    }

    public int getIDUser() {
        return IDUser;
    }

    public void setIDUser(int IDUser) {
        this.IDUser = IDUser;
    }

    public int getIDDiaDiem() {
        return IDDiaDiem;
    }

    public void setIDDiaDiem(int IDDiaDiem) {
        this.IDDiaDiem = IDDiaDiem;
    }

    public float getSoDiem() {
        return SoDiem;
    }

    public void setSoDiem(float soDiem) {
        SoDiem = soDiem;
    }
}
