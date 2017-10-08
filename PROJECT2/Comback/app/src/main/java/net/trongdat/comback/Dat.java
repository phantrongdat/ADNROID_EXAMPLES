package net.trongdat.comback;

/**
 * Created by Alone on 8/7/2016.
 */
public class Dat {
    private String lastName;
    private String firstName;

    public Dat(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }
}
