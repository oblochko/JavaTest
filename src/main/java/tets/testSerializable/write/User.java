package tets.testSerializable.write;

import java.io.Serializable;

public class User implements Serializable {
    int id;
    String name;
    public User(int id, String name) {
        this.id = 4;
        this.name = name;
    }
}
