package tets.testSerializable.write;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainWrite {

    public static void main(String[] args) {
        List<User> listUser;

        try {
            FileInputStream fis = new FileInputStream("userList.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            listUser = (List<User>) ois.readObject();

            System.out.println(listUser.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
