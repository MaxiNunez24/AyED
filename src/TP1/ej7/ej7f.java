package TP1.ej7;

import TP1.Stack;
import java.util.ArrayList;

public class ej7f {

    public static boolean esCapicua (ArrayList<Integer> lista){
        boolean es = true;
        Stack<Integer> pila = new Stack<>();
        for(int i=0; i<lista.size()/2; i++) pila.push(lista.get(i));
        int i=(lista.size()+1)/2;
        while(es && !pila.isEmpty()){
                int l = lista.get(i++);
                int p = pila.pop();
                if(l != p)es=false;
        }
        return es;
    }

    public static void main(String[] args){
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(2);
        lista.add(4);
        lista.add(3);
        lista.add(4);
        lista.add(2);


        System.out.println(esCapicua(lista));
    }
}
