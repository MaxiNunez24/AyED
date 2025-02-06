package TP5;

import TP1.ej8.Queue;
import TP5.adjList.AdjListGraph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Repaso {

    public String PilotoQuePasoPorMasEscuderias(Graph<String> escuderias,){
        if(escuderias != null){
            Vertex<String> origen = buscarVertice(escuderias,"Origen");
            List<Piloto>pilotos= new LinkedList<>();

            //generar lista de pilotos
            for(Edge<String> aux: escuderias.getEdges(origen)){
                Piloto p= new Piloto(aux.getWeight());
                pilotos.add(p);
            }

            boolean[] marcas= new boolean[escuderias.getSize()];
            Queue<Vertex<String>>colaPilotos= new Queue<>();
            colaPilotos.enqueue(origen);
            marcas[origen.getPosition()]=true;

            while(!colaPilotos.isEmpty()){
                Vertex<String> aux= colaPilotos.dequeue();
                for(Edge<String> edge : escuderias.getEdges(aux)){
                    Vertex<String> actual= edge.getTarget();
                    int w= edge.getWeight();
                    pilotos.get(w).incrementarPases();
                    if(!marcas[actual.getPosition()]){
                        marcas[actual.getPosition()]=true;
                        colaPilotos.enqueue(actual);
                    }
                }
            }

            //hacer el parcial de temaiken
            int max=-1;
            String nombre="";
            for(Piloto colapintos: pilotos){
                if(colapintos.getPases()>max){
                    max=colapintos.getPases();
                    nombre=colapintos.getNombre();
                }
            }
            return nombre;



        }
    }
















    private Vertex<String> buscarVertice(Graph<String> grafo, String nombre){
        Iterator<Vertex<String>> lista= grafo.getVertices().iterator();
        Vertex<String> aux= null;
        boolean encontre= false;
        while(lista.hasNext() && !encontre){
            aux=lista.next();
            if(aux.getData().equals(nombre)) {
                encontre=true;
            }
        }
        return aux;
    }



    public static void main(String[] args){
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
        f1Graph.connect(mcLaren, williams, 2); // Prost
        f1Graph.connect(mcLaren, williams, 3); // Senna

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

        Repaso test = new Repaso();
        System.out.println(test.PilotoQuePasoPorMasEscuderias(f1Graph));
    }
}
