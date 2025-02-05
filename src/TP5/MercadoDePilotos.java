package TP5;

import TP1.ej8.Queue;
import TP5.adjList.AdjListGraph;

import java.util.LinkedList;
import java.util.List;

public class MercadoDePilotos {

    public String PilotoQuePasoPorMasEscuderias(Graph<String> escuderias) {
        Vertex<String> origen = escuderias.search("Origen");
        List<Piloto> pilotos = new LinkedList<>();

        for(Edge<String> edge : escuderias.getEdges(origen)){
            Piloto pilotoActual = new Piloto(edge.getWeight());
            pilotos.add(pilotoActual);
        }

        Queue<Vertex<String>> queue = new Queue<>();
        queue.enqueue(origen);
        boolean[] marcas = new boolean[escuderias.getSize()]; // Se inicializa en False
        marcas[origen.getPosition()] = true;
        while(!queue.isEmpty()){
            Vertex<String> actual = queue.dequeue();
            for(Edge<String> edge : escuderias.getEdges(actual)){
                int weight = edge.getWeight();
                Vertex<String> target = edge.getTarget();
                pilotos.get(weight-1).incrementarPases();
                if(!marcas[weight]){
                    marcas[target.getPosition()] = true;
                    queue.enqueue(target);
                }
            }
        }
        Piloto maxPiloto = pilotos.getFirst();
        for(Piloto p : pilotos){
            if(p.getPases() > maxPiloto.getPases()){
                maxPiloto = p;
            }
        }

        return maxPiloto.getNombre();
    }

    public static void main(String[] args) {
        Graph<String> f1Graph = new AdjListGraph<>();

        // Adding vertices (teams)
        Vertex<String> origen = f1Graph.createVertex("Origen");
        Vertex<String> alfaRomeo = f1Graph.createVertex("Alfa Romeo");
        Vertex<String> ferrari = f1Graph.createVertex("Ferrari");
        Vertex<String> toleman = f1Graph.createVertex("Toleman");
        Vertex<String> lotus = f1Graph.createVertex("Lotus");
        Vertex<String> mercedes = f1Graph.createVertex("Mercedes");
        Vertex<String> mcLaren = f1Graph.createVertex("McLaren");
        Vertex<String> williams = f1Graph.createVertex("Williams");

        // Adding edges (pilots)
        /*
          1) Fangio
          2) Prost
          3) Senna
          4) Clark
         */
        f1Graph.connect(origen, alfaRomeo, 1); // Fangio
        f1Graph.connect(origen, ferrari, 2); // Prost
        f1Graph.connect(origen, toleman, 3); // Senna
        f1Graph.connect(origen, lotus, 4); // Clark

        f1Graph.connect(alfaRomeo, mercedes, 1); // Fangio
        f1Graph.connect(toleman, lotus, 3); // Senna
        f1Graph.connect(ferrari, mcLaren, 2); // Prost
        f1Graph.connect(lotus, mcLaren, 3); // Senna

        f1Graph.connect(mercedes, ferrari, 1); // Fangio
        f1Graph.connect(mcLaren, williams, 3); // Senna // EL ERROR ERA QUE NO PUEDE HABER DOS ARISTAS CON EL MISMO ORIGEN Y DESTINO!!
        f1Graph.connect(mcLaren, williams, 2); // Prost

        /*
        // Display adjacency list
        System.out.println("Adjacency List:");
        List<Vertex<String>> teams = f1Graph.getVertices();
        for(Vertex<String> team : teams){
            List<Edge<String>> edges = f1Graph.getEdges(team);
            for (Edge<String> edge : edges) {
                System.out.println(team.getData() + " - " + edge.getWeight() + " -> " + edge.getTarget().getData());
            }
        }
        */

        MercadoDePilotos test = new MercadoDePilotos();
        System.out.println(test.PilotoQuePasoPorMasEscuderias(f1Graph));
    }
}


