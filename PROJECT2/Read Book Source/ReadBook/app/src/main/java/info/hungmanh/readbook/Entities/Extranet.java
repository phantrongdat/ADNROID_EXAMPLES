package info.hungmanh.readbook.Entities;

import java.io.Serializable;

/**
 * Created by Alone on 10/8/2016.
 */

public class Extranet implements Serializable {
    private int id;
    private String extName, description,address, phoneNumber;

    public Extranet() {
    }

    public Extranet(int id, String extName, String description, String address, String phoneNumber) {
        this.id = id;
        this.extName = extName;
        this.description = description;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExtName() {
        return extName;
    }

    public void setExtName(String extName) {
        this.extName = extName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
