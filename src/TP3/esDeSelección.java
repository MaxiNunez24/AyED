package TP3;

// Primer parcial 16 de Noviembre 8am!!!

import TP1.ej8.Queue;

public class esDeSelección {
    public static boolean resolver(GeneralTree<Integer> arbol){
        Queue<GeneralTree<Integer>> cola = new Queue<>();
        boolean esDeSeleccion = true;
        if(arbol!=null && !arbol.isEmpty()){
            cola.enqueue(arbol);
            while(esDeSeleccion && !cola.isEmpty()){
                GeneralTree<Integer> auxArbol = cola.dequeue();
                Iterator<GeneralTree<Integer>> it = auxArbol.getChildren().iterator;
                int minimo = Integer.MAX_VALUE;
                while(esDeSeleccion && it.hasNext()){
                    GeneralTree<Integer> hijo = it.next();
                    if(hijo.getData() < auxArbol.getData()) esDeSeleccion = false;
                    else {
                        minimo = Math.min(minimo,hijo.getData());
                        if(hijo.isLeaf()) cola.enqueue(hijo);
                    }
                }
                if(!auxArbol.isLeaf() && minimo != auxArbol.getData()) esDeSeleccion = false;
            }
        }
    }
}
