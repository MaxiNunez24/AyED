package TP3;

import TP1.ej8.Queue;

public class esCreciente {

    public static boolean resolver(GeneralTree<Integer> arbol){
        Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
        int cantNodosNivel = 0, nivel = 0;
        boolean esCreciente = true;
        if(arbol!=null && !arbol.isEmpty()){
            cola.enqueue(null);
            while(esCreciente && !cola.isEmpty()){
                GeneralTree<Integer> auxArbol = cola.dequeue();
                if(auxArbol != null){
                    cantNodosNivel++;
                    for(GeneralTree<Integer> hijo : auxArbol.getChildren()) cola.enqueue(hijo);
                }
                else if (cantNodosNivel == nivel++) {
                    cantNodosNivel = 0;
                    if (!cola.isEmpty()) cola.enqueue(null);
                }
                else esCreciente = false;
        }
    }

}
