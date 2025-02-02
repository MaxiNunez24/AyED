package TP5;

import TP5.adjList.AdjListGraph;
import java.util.List;

public class ParcialF1 {
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
        /**
         * 1) Fangio
         * 2) Prost
         * 3) Senna
         * 4) Clark
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
        f1Graph.connect(mcLaren, williams, 2); // Prost
        f1Graph.connect(mcLaren, williams, 3); // Senna

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
