package TP5;

import java.util.LinkedList;
import java.util.List;

public class Ej3 {
    public List<List<String>> caminos (Graph<String> map, String ciudad1, String ciudad2, int tanqueAuto){
        if(map != null && !map.isEmpty() && tanqueAuto > 0){
            Vertex vOrigen = map.search(ciudad1);
            if (vOrigen != null) {
                Vertex vDestino = map.search(ciudad2);
                if (vDestino != null) {
                    List<List<String>> listaCaminos = new LinkedList<List<String>>();
                    dfs(map, new Boolean[map.getSize()], listaCaminos, vOrigen, vDestino, tanqueAuto, new LinkedList<String>());
                    return listaCaminos;
                }
            }
        }
        return null;
    }


    private void dfs(Graph<String> map, Boolean[] marcas, List<List<String>> listaCaminos, Vertex vActual,Vertex  vDestino,int tanqueAuto,List<String> caminoActual){
        marcas[vActual.getPosition()] = true;
        caminoActual.add(vActual.getData());
        if(vActual == vDestino){
            listaCaminos.add(new LinkedList<>(caminoActual)); // IMPORTANTE HACER LA COPIA! Porque siempre modificamos el caminoActual
        }else{ // Se hace un foreach porque tengo que recorrer todo, si me pidieran el primer camino se hace con el Iterator para cortar cuando sea igual
            for(Edge<String> arista : map.getEdge(vActual)){
                Vertex<String> vAdy = arista.getTarget();
                int peso = arista.getWeight();
                if(tanqueAuto >= peso && !marcas[vAdy.getPosition()]){
                    dfs(map, marcas, listaCaminos, vAdy, vDestino, tanqueAuto, caminoActual);
                }
            }
        }
        marcas[vActual.getPosition()] = false; // Misma línea pero con False y en el mismo nivel pero más abajo
        caminoActual.remove(caminoActual.size() - 1);
    }
}


// 5 sentencias fundamentales para el dfs
// 1) marcas[vActual.getPosition()] = true;
// 2) caminoActual.add(vActual.getData());
// 3) if(vActual == vDestino)
//       utilizar foreach si se recorre todo el grafo o Iterator si solo se pide el primer camino
//       preguntar, si el grafo es pesado, si llego con el peso adyacente y si el vAdyacente no está marcado
// 4) marcas[vActual.getPosition()] = false;
// 5) caminoActual.remove(caminoActual.size() - 1);




/*
    REPASAR PARA EL PARCIAL
    comparar dos arboles generales elemento a elemento
 */
