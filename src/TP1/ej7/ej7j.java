package TP1.ej7;

import java.util.ArrayList;

public class ej7j {

    public static ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1, ArrayList<Integer> lista2) {
        ArrayList<Integer> listaCombinada = new ArrayList<>();
        int i = 0, j = 0;
        while (i < lista1.size() && j < lista2.size()) {
            if (lista1.get(i) < lista2.get(j)) {
                listaCombinada.add(lista1.get(i++));
            }
            else {
                listaCombinada.add(lista2.get(j++));
            }
        }
        while (i < lista1.size()) {
            listaCombinada.add(lista1.get(i++));
        }
        while (j < lista2.size()) {
            listaCombinada.add(lista2.get(j++));
        }
        return listaCombinada;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        list1.add(1);list2.add(2);
        list1.add(3);list2.add(6);
        list1.add(5);list2.add(8);
        list1.add(13);list2.add(10);
        list1.add(16);list2.add(15);
        list1.add(25);list2.add(22);
        list1.add(42);list2.add(32);

        System.out.println(combinarOrdenado(list1, list2));
    }
}
