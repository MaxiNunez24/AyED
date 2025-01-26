package TP5;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import TP1.ej8.Queue;
import TP5.adjList.AdjListGraph;

public class Ej5 {
    public static List<Jubilado> armarCartera(Graph<Persona> grafo, Empleado empleado, int gradoSeparacion){
        List<Jubilado> jubilados = new LinkedList<>();
        boolean[] marcas = new boolean[grafo.getSize()];
        Vertex<Persona> emple = grafo.search(empleado);
        if(emple != null){
            Queue<Vertex<Persona>> cola = new Queue<>();
            cola.enqueue(emple);
            cola.enqueue(null);
            int distanciaActual = 0;
            boolean termine = false;
            while(!termine && !cola.isEmpty()){
                Vertex<Persona> vertex = cola.dequeue();
                if(vertex != null){
                    Persona persona = vertex.getData();
                    if(jubilados.size() <  40 && distanciaActual < gradoSeparacion){
                        if(persona.cumple()) jubilados.add((Jubilado)persona);
                        Iterator<Edge<Persona>> it = grafo.getEdges(vertex).iterator();
                        while(!termine && it.hasNext()){
                            Edge<Persona> e = it.next();
                            Vertex<Persona> v = e.getTarget();
                            if(!marcas[v.getPosition()]) {
                                marcas[v.getPosition()] = true;
                                cola.enqueue(v);
                            }
                        }
                    } else termine = true;
                } else if(!cola.isEmpty()){
                    distanciaActual++;
                    cola.enqueue(null);
                }
            }
        }
        return jubilados;
    }
    public static void main(String[] args) {
        Graph<Persona> grafo = new AdjListGraph<>();
        Empleado miEmpleado= new Empleado( "Julian", "BBB");
        Vertex<Persona> v1 = grafo.createVertex(miEmpleado);
        Vertex<Persona> v2 = grafo.createVertex(new Jubilado("Matias", "AAA", true));
        Vertex<Persona> v3 = grafo.createVertex(new Jubilado( "Francisco", "CCC", false));
        Vertex<Persona> v4 = grafo.createVertex(new Jubilado( "Valentin", "DDD", true));
        Vertex<Persona> v5 = grafo.createVertex(new Jubilado( "Omar", "EEE", true));
        Vertex<Persona> v6 = grafo.createVertex(new Jubilado( "Rosana", "FFF", true));
        Vertex<Persona> v7 = grafo.createVertex(new Jubilado( "Maria", "GGG", false));

        Vertex<Persona> v8 = grafo.createVertex(new Jubilado( "Sandra", "HHH", true));
        Vertex<Persona> v9 = grafo.createVertex(new Jubilado("Matheo", "III", false));

        grafo.connect(v1, v2);
        grafo.connect(v2, v1);
        grafo.connect(v2, v3);
        grafo.connect(v3, v2);

        grafo.connect(v1, v9);
        grafo.connect(v9, v1);
        grafo.connect(v9, v8);
        grafo.connect(v8, v9);

        grafo.connect(v1, v4);
        grafo.connect(v4, v1);
        grafo.connect(v1, v6);
        grafo.connect(v6, v1);
        grafo.connect(v4, v5);
        grafo.connect(v5, v4);
        grafo.connect(v5, v7);
        grafo.connect(v7, v5);


        Ej5 banco = new Ej5();

        //System.out.println(banco.carteraJubilados(grafo, "Matias", 1, 40));
        List<Jubilado> listado= banco.armarCartera(grafo,miEmpleado,3);

        for (Jubilado x : listado){
            System.out.println(x.getNombre());
        }
    }
}


