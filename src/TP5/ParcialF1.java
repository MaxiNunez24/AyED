package TP5;

import TP5.adjList.AdjListGraph;
import java.util.List;

public class ParcialF1 {
    public static void main(String[] args) {
        Graph<String> f1Graph = new AdjListGraph<>();

        // Adding vertices (teams)
        Vertex<String> williams = f1Graph.createVertex("Williams");
        Vertex<String> renault = f1Graph.createVertex("Renault");
        Vertex<String> ferrari = f1Graph.createVertex("Ferrari");
        Vertex<String> mercedes = f1Graph.createVertex("Mercedes");
        Vertex<String> redBull = f1Graph.createVertex("Red Bull");
        Vertex<String> astonMartin = f1Graph.createVertex("Aston Martin");
        Vertex<String> alfaRomeo = f1Graph.createVertex("Alfa Romeo");
        Vertex<String> alpine = f1Graph.createVertex("Alpine");

        // Adding edges (pilots)
        /**
         * 1) Fangio
         * 2) Prost
         * 3) Verstappen
         * 4) Vettel
         * 5) Alonso
         * 6) Colapinto
         * 7) Bottas
         */
        f1Graph.connect(mercedes, ferrari, 1); // Fangio
        f1Graph.connect(ferrari, renault, 1); // Fangio
        f1Graph.connect(renault, williams, 1); // Fangio

        f1Graph.connect(mercedes, renault, 2); // Prost
        f1Graph.connect(renault, ferrari, 2); // Prost

        f1Graph.connect(renault, redBull, 3); // Verstappen

        f1Graph.connect(alfaRomeo, renault, 4); // Vettel
        f1Graph.connect(renault, astonMartin, 4); // Vettel

        f1Graph.connect(alfaRomeo, astonMartin, 5); // Alonso

        f1Graph.connect(williams, alpine, 6); // Colapinto

        f1Graph.connect(mercedes, alfaRomeo, 7); // Bottas

        // Display adjacency list
        System.out.println("Adjacency List:");
        List<Vertex<String>> teams = f1Graph.getVertices();
        for(Vertex<String> team : teams){
            List<Edge<String>> edges = f1Graph.getEdges(team);
            for (Edge<String> edge : edges) {
                System.out.println(team.getData() + " - " + edge.getWeight() + " -> " + edge.getTarget().getData());
            }
        }
    }
}
