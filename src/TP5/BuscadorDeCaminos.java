package TP5;

import java.util.LinkedList;
import java.util.List;

public class BuscadorDeCaminos {
    private Graph<String> bosque;

    // Hay que evitar las aristas con costo >= 5
    // Todos los caminos

    public List<List<String>> recorridosMasSeguro(){
        List<List<String>> caminos = null;
        if( bosque != null && !bosque.isEmpty()){
            caminos = new LinkedList<>();
            Vertex<String> Caperucita = bosque.search("Caperucita"), Abuela = bosque.search("Abuela");
            if(Caperucita != null && Abuela != null){
                dfs(Caperucita, Abuela, new LinkedList<String>(), caminos, new boolean[bosque.getSize()]);
            }
        }
        return caminos;
    }


    private void dfs(Vertex<String> origen, Vertex<String> destino, List<String> actual, List<List<String>> caminos, boolean[] visitados){
        visitados[origen.getPosition()] = true;
        actual.add(origen.getData());
        if(origen.getData().equals(destino.getData())){
            caminos.add(new LinkedList<>(actual));
        } else {
            for(Edge<String> vecino: bosque.getEdges(origen)){
                Vertex<String> ady = vecino.getTarget();
                int peso = vecino.getWeight();
                if(!visitados[ady.getPosition()] && peso < 5){
                    dfs(ady, destino, actual, caminos, visitados);
                }
            }
        }
        actual.removeLast();
        visitados[origen.getPosition()] = false;
    }

}
