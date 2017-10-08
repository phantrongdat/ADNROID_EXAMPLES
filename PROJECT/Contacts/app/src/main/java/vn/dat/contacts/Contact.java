package vn.dat.contacts;

public class Contact {
    int id;
    private String name, phoneNumber, details;

    byte[] image;
    public Contact(int id,String name, String phoneNumber, String details, byte[] image) {
        this.id=id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.details = details;
        this.image=image;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDetails() {
        return details;
    }

    public int getId() {
        return id;
    }

    public byte[] getImage() {
        return image;
    }
}
