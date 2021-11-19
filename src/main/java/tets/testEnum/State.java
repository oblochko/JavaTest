package tets.testEnum;

public abstract class State {
    public static State rega;

    static {
        rega = new Rega();
    }

    Menu menu = new Menu();


    public abstract void method();
}
