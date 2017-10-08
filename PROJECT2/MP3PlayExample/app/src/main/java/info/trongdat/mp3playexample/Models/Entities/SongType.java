package info.trongdat.mp3playexample.Models.Entities;

/**
 * Created by Alone on 10/14/2016.
 */

public class SongType {
    private int typeID;
    private String typeName, description;

    public SongType() {

    }

    public SongType(int typeID, String typeName, String description) {
        this.typeID = typeID;
        this.typeName = typeName;
        this.description = description;

    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
