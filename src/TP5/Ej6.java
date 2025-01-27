package TP5;

import TP5.adjList.AdjListGraph;
import TP5.adjList.AdjListVertex;

import java.util.LinkedList;
import java.util.List;

public class Ej6 {

    public Ej6(Graph<String> bosque){
        this.bosque = bosque;
    }

    private Graph<String> bosque;
    public List<List<String>> recorridosMasSeguro(){
        List<List<String>> caminos = new LinkedList<>();
        Vertex<String> origen = bosque.search("Caperucita");
        if(origen != null){
            recorridosMasSeguroHelper(bosque, origen,"Casa Abuelita", new LinkedList<>(), caminos, 5, new boolean[bosque.getSize()]);
        }
        return caminos;
    }

    private List<String> recorridosMasSeguroHelper(Graph<String> grafo, Vertex<String> origen, String destino, List<String> caminoActual, List<List<String>> caminos, int maxFrutales,boolean[] marcas){
        marcas[origen.getPosition()] = true;
        String data = origen.getData();
        caminoActual.add(origen.getData());
        if(data.equals(destino)){
            caminos.add(new LinkedList<>(caminoActual));
        }
        for(Edge<String> e : grafo.getEdges(origen)){
            Vertex<String> v = e.getTarget();
            if(!marcas[v.getPosition()] && e.getWeight() < maxFrutales){
                caminoActual = recorridosMasSeguroHelper(grafo, v, destino, caminoActual, caminos, maxFrutales, marcas);
            }
        }

        marcas[origen.getPosition()] = false;
        caminoActual.removeLast();
        return caminoActual;
    }

    public static void main(String[] args){
        Graph<String> bosque = new AdjListGraph<>();

        Vertex<String> caperucita = bosque.createVertex("Caperucita");
        Vertex<String> claro1 = bosque.createVertex("Claro 1");
        Vertex<String> claro2 = bosque.createVertex("Claro 2");
        Vertex<String> claro3 = bosque.createVertex("Claro 3");
        Vertex<String> claro4 = bosque.createVertex("Claro 4");
        Vertex<String> claro5 = bosque.createVertex("Claro 5");
        Vertex<String> casaAbue = bosque.createVertex("Casa Abuelita");

        bosque.connect(caperucita,claro1,3);
        bosque.connect(claro1,caperucita,3);

        bosque.connect(caperucita,claro2,4);
        bosque.connect(claro2,caperucita,4);

        bosque.connect(caperucita,claro3,4);
        bosque.connect(claro3,caperucita,4);

        bosque.connect(claro2,claro1,4);
        bosque.connect(claro1,claro2,4);

        bosque.connect(claro5,claro1,3);
        bosque.connect(claro1,claro5,3);

        bosque.connect(claro3,claro5,15);
        bosque.connect(claro5,claro3,15);

        bosque.connect(claro2, claro5, 11);
        bosque.connect(claro5, claro2, 11);

        bosque.connect(claro2, claro4, 10);
        bosque.connect(claro4, claro2, 10);

        bosque.connect(casaAbue, claro5, 4);
        bosque.connect(claro5, casaAbue, 4);

        bosque.connect(casaAbue, claro4, 9);
        bosque.connect(claro4, casaAbue, 9);

        Ej6 ej6 = new Ej6(bosque);

        List<List<String>> recorridos = ej6.recorridosMasSeguro();

        for(List<String> recorrido : recorridos){
            System.out.println(recorrido);
        }

    }
}

