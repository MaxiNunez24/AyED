package TP1.ej7;

import java.util.LinkedList;

public class ej7i {
    public static int sumarLinkedList(LinkedList<Integer> lista){
        if(!lista.isEmpty()){
            return sumarLinkedListHelper(lista, lista.size()-1);
        }
        return 0;
    }

    private static int sumarLinkedListHelper(LinkedList<Integer> lista, int pos){
        if(pos<0){
            return 0;
        }
        return lista.get(pos) + sumarLinkedListHelper(lista, pos - 1);
    }


    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<>();
        lista.add(1);lista.add(2);lista.add(3);lista.add(4);lista.add(5);
        lista.add(6);lista.add(7);lista.add(8);lista.add(9);lista.add(10);
        System.out.println(sumarLinkedList(lista));
    }
}
