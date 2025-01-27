/*package TP5;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import TP5.Edge;
import TP5.Graph;
import TP5.Vertex;
import TP5.adjList.AdjListGraph;

public class ParcialCaperucita {

    public List<String> recorridoSeguroMaxFrutales (Graph<String> bosque, String caperucita, String abuelita, int maxFrutales) {
        List<String> resultado = new LinkedList<String>();
        // Búsqueda de la casa de Caperucita Roja
        Vertex<String> vOrigen = bosque.search(caperucita, ); //buscarCasaCaperucita(bosque, caperucita);
        if (vOrigen!= null)
            dfs(vOrigen.getPosition(), 0, 0, new LinkedList<String>(), new boolean[bosque.getVertices().size()], resultado, abuelita, maxFrutales, bosque);
        return resultado;
    }

    private int dfs(int posV, int cantFrutAct, int cantFrutMax, List<String> caminoActual, boolean[] marca, List<String> resultado, String abuelita, int maxFrutales, Graph<String> bosque){

        Vertex<String> vertice = bosque.getVertex(posV);
        caminoActual.add(vertice.getData());
        marca[posV] = true;

        if (vertice.getData().equals(abuelita)) {
            if(cantFrutAct > cantFrutMax) {
                cantFrutMax = cantFrutAct;
                resultado.clear();
                resultado.addAll(caminoActual);
            }
        }else {
            List<Edge<String>> adys = bosque.getEdges(vertice);
            for(Edge<String> arista : adys) {
                Vertex<String> vDest = arista.getTarget();
                int posDest = vDest.getPosition();
                if (!marca[posDest] && arista.getWeight() <= maxFrutales)
                    cantFrutMax =  dfs(posDest, cantFrutAct + arista.getWeight(), cantFrutMax, caminoActual, marca, resultado, abuelita, maxFrutales, bosque);
            }
        }

        caminoActual.remove(caminoActual.size()-1);
        marca[posV] = false;
        return cantFrutMax;
    }

    private Vertex<String> buscarCasaCaperucita(Graph<String> bosque, String caperucita) {
        List<Vertex<String>> vertices = bosque.getVertices();
        Iterator<Vertex<String>> it = vertices.iterator();
        while(it.hasNext() ){
            Vertex<String> v = it.next();
            if (v.getData().equals(caperucita))
                return v;
        }
        return null;
    }

    public static void main (String[] args){

        Graph<String> grafo = new AdjListGraph<String>();

        Vertex<String> vertCap = grafo.createVertex("Casa de Caperucita");
        Vertex<String> vertAbu = grafo.createVertex("Casa de la Abuelita");
        Vertex<String> vert1 = grafo.createVertex("Claro 1");
        Vertex<String> vert2 = grafo.createVertex("Claro 2");
        Vertex<String> vert3 = grafo.createVertex("Claro 3");
        Vertex<String> vert4 = grafo.createVertex("Claro 4");
        Vertex<String> vert5 = grafo.createVertex("Claro 5");
        Vertex<String> vert6 = grafo.createVertex("Claro 6");

        grafo.connect(vertCap, vert1, 10);
        grafo.connect(vert1, vertCap, 10);

        grafo.connect(vertCap, vert2, 15);
        grafo.connect(vert2, vertCap, 15);

        grafo.connect(vertCap, vert3, 20);
        grafo.connect(vert3, vertCap, 20);

        grafo.connect(vertCap, vert4, 8);
        grafo.connect(vert4, vertCap, 8);

        grafo.connect(vert1, vert3, 5);
        grafo.connect(vert3, vert1, 5);

        grafo.connect(vert3, vert5, 3);
        grafo.connect(vert5, vert3, 3);

        grafo.connect(vert2, vert4, 38);
        grafo.connect(vert4, vert2, 38);

        grafo.connect(vert2, vert6, 30);
        grafo.connect(vert6, vert2, 30);

        grafo.connect(vert4, vert6, 45);
        grafo.connect(vert6, vert4, 45);

        grafo.connect(vert5, vert6, 7);
        grafo.connect(vert6, vert5, 7);

        grafo.connect(vert5, vertAbu, 35);
        grafo.connect(vertAbu, vert5, 35);

        grafo.connect(vert6, vertAbu, 15);
        grafo.connect(vertAbu, vert6, 15);


        ParcialCaperucita parcial = new ParcialCaperucita();
        List<String> lista = parcial.recorridoSeguroMaxFrutales(grafo, "Casa de Caperucita", "Casa de la Abuelita", 30);

        System.out.println("El recorrido seguro y de mayor cantidad de frutales es: ");

        if (!lista.isEmpty()) {
            System.out.print(lista+ " ");
        }else System.out.println("No hay un recorrido seguro entre casa caperucita y la de su abuelita ");
    }

}
*/
