package TP5;
import TP1.ej8.Queue;
import TP5.adjList.AdjListGraph;
import TP5.adjList.AdjListVertex;

import java.util.LinkedList;
import java.util.List;

public class Recorridos<T> {
    public List<T> dfs(Graph<T> grafo) {
        boolean[] marca = new boolean[grafo.getSize()];
        List<T> datos = new LinkedList<>();
        for (int i = 0; i < grafo.getSize(); i++) {
            if (!marca[i]) {
                System.out.println("largo con: "+grafo.getVertex(i).getData());
                dfs(i, grafo, marca, datos);
            }
        }
        return datos;
    }
    private void dfs(int i, Graph<T> grafo, boolean[] marca, List<T> datos) {
        marca[i] = true;
        Vertex<T> v = grafo.getVertex(i);
        System.out.println(v.getData());
        List<Edge<T>> adyacentes = grafo.getEdges(v); //adyacentes
        for (Edge<T> e: adyacentes){
            int j = e.getTarget().getPosition();
            if (!marca[j]) {
                dfs(j, grafo, marca, datos);
            }
        }
        /*
            Iterator<Edge<T>> it = adyacentes.iterator();
            while (it.hasNext()) {
                int j = it.next().getTarget().getPosition();
                if (!marca[j]){
                dfs(j, grafo, marca);
            }
         }
         */
    }

    public List<T> bfs(Graph<T> grafo) {
        boolean[] marca = new boolean[grafo.getSize()];
        List<T> datos = new LinkedList<>();
        for (int i = 0; i < grafo.getSize(); i++) {
            if (!marca[i]) {
                this.bfs(i, grafo, marca, datos);
            }
        }
        return datos;
    }

    private void bfs(int i, Graph<T> grafo, boolean[] marca, List<T> datos) {
        Queue<Vertex<T>> q = new Queue<Vertex<T>>();
        q.enqueue(grafo.getVertex(i));
        marca[i] = true;
        while (!q.isEmpty()) {
            Vertex<T> w = q.dequeue();
            System.out.println(w);
            // para todos los vecinos de w:
            List<Edge<T>> adyacentes = grafo.getEdges(w);
            for (Edge<T> e: adyacentes) {
                int j = e.getTarget().getPosition();
                if (!marca[j]) {
                    marca[j] = true;
            //Vertex<T> v = e.getTarget();
                    q.enqueue(e.getTarget());
                }
            }
        }
    }


    public static void main(String[] args){
        Graph<String> ciudades = new AdjListGraph<String>();
        Recorridos<String> rec = new Recorridos<String>();
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

        List<String> lisDFS = rec.dfs(ciudades);
        List<String> lisBFS = rec.bfs(ciudades);

        System.out.print("Lista DFS: ");
        for (String e: lisDFS){
            System.out.print(e + " ~ ");
        }

        System.out.println();

        System.out.print("Lista BFS: ");
        for (String e: lisBFS){
            System.out.print(e + " ~ ");
        }
    }
}