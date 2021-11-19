package tets.testSerializable.write;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainRead {

    public static void main(String[] args) {
        List<User> listUser = new ArrayList<>();
        listUser.add(new User(1, "one"));
        listUser.add(new User(2, "two"));
        listUser.add(new User(1, "free"));

        try {
            FileOutputStream fos = new FileOutputStream("userList.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(listUser);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
