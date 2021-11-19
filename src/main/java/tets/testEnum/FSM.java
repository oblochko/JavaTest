package tets.testEnum;

public enum FSM {
    Instance;

    State rega;

    FSM() {
        rega = new Rega();
    }

    public void method() {
        rega.method();
    }
}
