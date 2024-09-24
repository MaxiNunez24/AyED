package TP1.ej7;

import java.util.ArrayList;

public class ej7h {
    public static void invertirArrayList(ArrayList<Integer> lista){
        invertirHelper(lista, 0, lista.size()-1);
    }

    private static void invertirHelper(ArrayList<Integer> lista, int start, int end){
        if(start < end){
            int aux = lista.get(start);
            lista.set(start, lista.get(end));
            lista.set(end, aux);
            invertirHelper(lista, ++start, --end);
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);
        invertirArrayList(lista);
        System.out.println(lista);
    }
}
