package TP3;
import java.util.List;
import java.util.LinkedList;

public class Caminos {
    GeneralTree<Integer> arbol;

    public List<Integer> caminoAHojaMasLejana(){
        List<Integer> camino = new LinkedList<>();
        if (arbol!= null){
            caminoHelper(arbol, camino, new LinkedList<Integer>());
        }
        return camino;
    }

    private List<Integer> caminoHelper(GeneralTree<Integer> arbol, List<Integer> camino, List<Integer> caminoActual){
        caminoActual.add(arbol.getData());
        if(arbol.isLeaf()){
            if(camino.isEmpty() || caminoActual.size() > camino.size()){
                camino = new LinkedList<>(caminoActual);
            }
        }
        for(GeneralTree<Integer> child : arbol.getChildren()){
            caminoActual.add(child.getData());
            caminoHelper(child, camino, caminoActual);
            caminoActual.remove(caminoActual.size()-1);
        }

        return camino;
    }
    
}
