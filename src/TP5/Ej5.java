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
                Persona persona = vertex.getData();
                if(persona != null){
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

                Persona empleado1 = new Empleado("Empleado1", "Calle 1");
                Persona empleado2 = new Empleado("Empleado2", "Calle 2");

                Persona jubilado1 = new Jubilado("Jubilado1", "Calle 3", false);
                Persona jubilado2 = new Jubilado("Jubilado2", "Calle 4", true);
                Persona jubilado3 = new Jubilado("Jubilado3", "Calle 5", false);
                Persona jubilado4 = new Jubilado("Jubilado4", "Calle 6", false);

                Vertex<Persona> e1 = grafo.createVertex(empleado1);
                Vertex<Persona> e2 = grafo.createVertex(empleado2);
                Vertex<Persona> j1 = grafo.createVertex(jubilado1);
                Vertex<Persona> j2 = grafo.createVertex(jubilado2);
                Vertex<Persona> j3 = grafo.createVertex(jubilado3);
                Vertex<Persona> j4 = grafo.createVertex(jubilado4);

                // TODO:
                /* grafo.connect(e1, j1);
                grafo.connect(e2, j2);
                grafo.connect(, v3);
                grafo.connect(v, empleado2);
                grafo.connect(v, jubilado4);
                grafo.connect(v, jubilado2);

                // Probar el método
                List<Jubilado> resultado = Ej5.armarCartera(grafo, empleado1, 2);

                // Mostrar los resultados
                System.out.println("Jubilados asignados:");
                for (Jubilado j : resultado) {
                    System.out.println(j.getNombre() + " - " + j.getDomicilio());
                }
            */
            }
    }
