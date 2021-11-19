package tets.link;

public class Main {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.addList(3);
        singleton.addList(4);
        singleton.addList(5);
        singleton.addList(6);
        singleton.addList(7); //4
        singleton.addList(8);
        singleton.addList(9);
        singleton.addList(10);

        Singleton singleton1 = Singleton.getInstance();
        int value = singleton1.getList(4);
        System.out.println(value);

        SingletonEnum sEnum = SingletonEnum.Instance;
        sEnum.addList(5); //3
        sEnum.addList(6);
        sEnum.addList(7);

        value = SingletonEnum.Instance.getList(3);
        System.out.println(value);

        String str1 = "";
        String str2 = "Pososi";

        String str3 = str1 + str2;
        System.out.println(str3);

        sEnum.addList(5);

    }
}
