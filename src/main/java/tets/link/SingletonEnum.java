package tets.link;

import java.util.ArrayList;
import java.util.List;

public enum SingletonEnum {
    Instance;

    private List<Integer> list;

    private SingletonEnum() {
        list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
    }

    public void addList(int value){

        boolean flag = false;

        flag = list.stream().noneMatch(v->v == value);
        System.out.println(flag);
        if(flag){
            list.add(value);
        }
    }

    public int getList(int i) {
        return list.get(i);
    }
}
