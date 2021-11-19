package tets.link;

import java.util.ArrayList;
import java.util.List;

public class Singleton {
    private static Singleton instance = new Singleton();
    private List<Integer> list;

    private Singleton() {
        list = new ArrayList<>();
    }

    public static Singleton getInstance() {
        return instance;
    }

    public void addList(int value){

        boolean flag = false;
        /*for(int i = 0; i < list.size(); i ++){
            if(list.get(i) == value) {
                flag = true;
                break;
            }
        }*/
        flag = list.stream().noneMatch(v->v == value);

        if(flag){
            list.add(value);
        }
    }

    public int getList(int i) {
        return list.get(i);
    }





}
