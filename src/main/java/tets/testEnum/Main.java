package tets.testEnum;

public class Main {
    public static void main(String[] args) {
        State.rega.method();

        String str = "Sosi_1213";
        boolean flag = str.matches("Sosi_(.*)");
        System.out.println(flag);
        str = str.replaceAll("[^0-9]", "");
        System.out.println(str);

        StringBuffer strBuf = new StringBuffer("Добро пожаловать");
        strBuf.append(" кусок ");
        strBuf.append("говна");
        System.out.println(strBuf);
    }
}
