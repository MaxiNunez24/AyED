package TP5;

import TP5.adjList.AdjListGraph;

public class ParcialF1 {

    public String PilotoQuePasoPorMasEscuderias(Graph<String> escuderias){
        int maxPiloto = 0;
        int maxPases = 0;
        if(escuderias != null && !escuderias.isEmpty()){
            Vertex<String> origen = escuderias.search("Origen");
            for(Edge<String> edge : escuderias.getEdges(origen)){
                int piloto = edge.getWeight();
                Vertex<String> escuderia = edge.getTarget();
                int cantPases = dfs(escuderias, escuderia, piloto);
                if(cantPases > maxPases){
                    maxPases = cantPases;
                    maxPiloto = piloto;
                }
            }
        }
        return switch (maxPiloto) {
            case 1 -> "Fangio";
            case 2 -> "Prost";
            case 3 -> "Senna";
            case 4 -> "Clark";
            default -> "Ninguno";
        };
    }

    private int dfs(Graph<String> grafo, Vertex<String> origen, int piloto){
            for(Edge<String> edge : grafo.getEdges(origen)){
                if(edge.getWeight() == piloto){
                    return 1 + dfs(grafo, edge.getTarget(), piloto);
                }
            }
        return 0;
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
        Vertex<String> williams = f1Graph.createVertex("Williams");
        Vertex<String> mcLaren = f1Graph.createVertex("McLaren");

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

        ParcialF1 test = new ParcialF1();
        System.out.println(test.PilotoQuePasoPorMasEscuderias(f1Graph));
    }
}
