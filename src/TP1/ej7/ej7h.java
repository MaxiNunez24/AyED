package TP1.ej7;

import java.util.ArrayList;

public class ej7h {
    public static void invertirArrayList(ArrayList<Integer> lista){
        if(!lista.isEmpty()){
            int i = lista.getLast();
            lista.set(lista.size()-1, lista.getFirst());
            lista.set(0, i);
            lista.removeFirst();
            invertirArrayList(lista);
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(5);
        lista.add(4);
        lista.add(3);
        lista.add(2);
        lista.add(1);
        invertirArrayList(lista);
        System.out.println(lista);
    }
}
