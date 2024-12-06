package TP5;

import TP1.ej8.Queue;
import TP5.adjList.AdjListGraph;

import java.util.List;

public class EjercicioVirusGraph {

    public int bfs(Graph<String> grafo){
        if(grafo == null) return -1;
        int tiempo = 0;
        boolean[] marca = new boolean[grafo.getSize()];
        for(int i = 0; i < grafo.getSize(); i++){
            if(!marca[i]){
                tiempo += bfs(i, grafo, marca);
            }
        }
        return tiempo;
    }

    private int bfs(int i, Graph<String> grafo, boolean[] marca){
        Queue<Vertex<String>> q = new Queue<>();
        q.enqueue(grafo.getVertex(i));
        q.enqueue(null);
        marca[i] = true;
        int tiempo = 0;
        while(!q.isEmpty()){
            Vertex<String> v = q.dequeue();
            if(v != null){
                List<Edge<String>> adyacentes = grafo.getEdges(v);
                for(Edge<String> w: adyacentes){
                    Vertex<String> adj = w.getTarget();
                    int pos = adj.getPosition();
                    if(!marca[pos]){
                        q.enqueue(adj);
                        marca[pos] = true;
                    }
                }
            } else {
                tiempo++;
                if(!q.isEmpty()){
                    q.enqueue(null);
                }
            }
        }
        return tiempo;
    }

    public static void main(String[] args) {
        Graph<String> ciudades = new AdjListGraph<String>();
        EjercicioVirusGraph rec = new EjercicioVirusGraph();
        Vertex<String> v1 = ciudades.createVertex("Buenos Aires");
        Vertex<String> v2 = ciudades.createVertex("Santiago");
        Vertex<String> v3 = ciudades.createVertex("Asunción");
        Vertex<String> v4 = ciudades.createVertex("Tokio");
        Vertex<String> v5 = ciudades.createVertex("Roma");
        Vertex<String> v6 = ciudades.createVertex("Paris");
        Vertex<String> v7 = ciudades.createVertex("Madrid");
        Vertex<String> v8 = ciudades.createVertex("Caracas");
        ciudades.connect(v1, v2);
        ciudades.connect(v1, v3);
        ciudades.connect(v2, v5);
        ciudades.connect(v3, v7);
        ciudades.connect(v3, v8);
        ciudades.connect(v8, v7);
        ciudades.connect(v8, v4);
        ciudades.connect(v5, v4);
        ciudades.connect(v7, v4);
        ciudades.connect(v6, v5);
        ciudades.connect(v6, v7);
        ciudades.connect(v6, v4);
        ciudades.connect(v4, v1);

        System.out.println(rec.bfs(ciudades));
    }


}
