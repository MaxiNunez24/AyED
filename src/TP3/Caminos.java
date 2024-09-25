package TP3;

import java.util.*;

public class Caminos {
    public List<List<Integer>> caminoMasLargo(GeneralTree<Integer> arbol){
        List<List<Integer>> caminosMasLargos = new LinkedList<List<Integer>>();
        if(arbol!=null && !arbol.isEmpty())
            caminoMasLargoRec(arbol, caminosMasLargos, new LinkedList<Integer>());
        return caminosMasLargos;
    }

    private void caminoMasLargoRec(GeneralTree<Integer> arbol, List<List<Integer>> caminosMasLargos, LinkedList<Integer> caminoActual){
        caminoActual.add(Arbol.getData());
        if(arbol.isLeaf()){
            if(caminoActual.isEmpty | caminoActual.size() == caminosMasLargos.size())
                //Agregar
        }
        //Recorrer todos los hijos y volver a llamar, eliminar el último elemento del CamAct
    }


    private boolean camTodosImpares(GeneralTree<Integer> arbol,LinkedList<Integer> camino){
        boolean encontre = false;
        if(arbol.getData() % 2  != 0){
            camino.add(arbol.getData());
            if (arbol.isLeaf()) encontre = true;
            else {
                Iterator<GeneralTree<Integer>> it = arbol.getChildren().iterator;
                while(!encontre && it.hasNext()) encontre = camTodosImpares(it.next(), camino);
                if(!encontre){
                    camino.removeLast();
                }
            }
        }
    }
}
