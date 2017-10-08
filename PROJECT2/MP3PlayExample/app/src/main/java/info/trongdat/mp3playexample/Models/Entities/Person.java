package info.trongdat.mp3playexample.Models.Entities;

/**
 * Created by Alone on 10/14/2016.
 */

public class Person {
    protected int id;
    protected String name;
    protected int birthYear;
    protected boolean sex;
    protected String country;
    protected String image;

    public Person() {
    }

    public Person(int id, String name, int birthYear, boolean sex, String country, String avatar) {
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
        this.sex = sex;
        this.country = country;
        this.image = avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String avatar) {
        this.image = avatar;
    }
}
