package com.example.alone.wifimanager;

/**
 * Created by Alone on 04/02/2016.
 */
public class WifiName {
    private String name;
    private String status;

    public WifiName(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public WifiName() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {

        return name;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return this.getName() + "\n" + this.getStatus();
    }
}
