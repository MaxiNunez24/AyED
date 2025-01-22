package TP5;

import TP5.adjList.AdjListGraph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Mapa {
    private Graph<String> mapaCiudades;

    public List<String> devolverCamino(String ciudad1, String ciudad2) {
        List<String> camino = null;
        Vertex<String> origen = mapaCiudades.search(ciudad1);
        if (origen != null && mapaCiudades.search(ciudad2) != null) {
            devolverCaminoHelper3(this.mapaCiudades, origen, ciudad2, camino = new LinkedList<>(), new boolean[mapaCiudades.getSize()]);
        }
        return camino;
    }
    private boolean devolverCaminoHelper1(Graph<String> grafo, Vertex<String> origen, String destino, List<String> camino, boolean[] marcas, boolean encontre) {
        marcas[origen.getPosition()] = true;
        camino.add(origen.getData());
        if (destino.equals(origen.getData())) {
            return true;
        } else {
            Iterator<Edge<String>> it = grafo.getEdges(origen).iterator();
            while (!encontre && it.hasNext()) {
                Vertex<String> v = it.next().getTarget();
                if (!marcas[v.getPosition()]) {
                    encontre = devolverCaminoHelper1(grafo, v, destino, camino, marcas, encontre);
                }
            }
        }
        if (!encontre) {
            marcas[origen.getPosition()] = false;
            camino.removeLast();
        }
        return encontre;
    }
    private boolean devolverCaminoHelper2(Graph<String> grafo, Vertex<String> origen, String destino, List<String> camino, boolean[] marcas) {
        marcas[origen.getPosition()] = true;
        camino.add(origen.getData());
        if (origen.getData().equals(destino)) {
            return true;
        } else {
            Iterator<Edge<String>> it = grafo.getEdges(origen).iterator();
            while (it.hasNext()) {
                Vertex<String> v = it.next().getTarget();
                if (!marcas[v.getPosition()]) {
                    if (devolverCaminoHelper2(grafo, v, destino, camino, marcas)) {
                        return true;
                    }
                }
            }
        }
        marcas[origen.getPosition()] = false;
        camino.removeLast();
        return false;
    }
    private boolean devolverCaminoHelper3(Graph<String> grafo, Vertex<String> origen, String destino, List<String> camino, boolean[] marcas) {
        marcas[origen.getPosition()] = true;
        camino.add(origen.getData());
        boolean encontre = origen.getData().equals(destino);

        if (!encontre) {
            Iterator<Edge<String>> it = grafo.getEdges(origen).iterator();
            while (!encontre && it.hasNext()) {
                Vertex<String> v = it.next().getTarget();
                encontre = devolverCaminoHelper3(grafo, v, destino, camino, marcas);
            }
        }

        if (!encontre) {
            marcas[origen.getPosition()] = false;
            camino.removeLast();
        }
        return encontre;
    }

    public List<String> devolverCaminoExeptuando(String ciudad1, String ciudad2, List<String> ciudades) {
        List<String> camino = new LinkedList<>();
        Vertex<String> origen = mapaCiudades.search(ciudad1);
        if (origen != null && mapaCiudades.search(ciudad2) != null) {
            if (!ciudad1.equals(ciudad2) && !ciudades.contains(ciudad1) && !ciudades.contains(ciudad2)) {
                devolverCaminoExeptuandoHelper(mapaCiudades, origen, ciudad2, camino, new boolean[mapaCiudades.getSize()], ciudades);
            }
        }
        return camino;
    }
    private boolean devolverCaminoExeptuandoHelper(Graph<String> grafo, Vertex<String> origen, String destino, List<String> camino, boolean[] marcas, List<String> ciudades) {
        marcas[origen.getPosition()] = true;
        camino.add(origen.getData());
        boolean encontre = origen.getData().equals(destino);
        if (encontre) {
            return true;
        }
        if (!ciudades.contains(origen.getData())) {
            Iterator<Edge<String>> it = grafo.getEdges(origen).iterator();
            while (!encontre && it.hasNext()) {
                Vertex<String> v = it.next().getTarget();
                if(!marcas[v.getPosition()]){
                    encontre = devolverCaminoExeptuandoHelper(grafo, v, destino, camino, marcas, ciudades);
                }
            }
        }
        if (!encontre) camino.removeLast();
        marcas[origen.getPosition()] = false;
        return encontre;
    }

    public List<List<String>> devolverCaminosExeptuando(String ciudad1 ,String ciudad2, List<String> ciudades) {
        List<List<String>> caminos = new LinkedList<>();
        Vertex<String> origen = mapaCiudades.search(ciudad1);
        if (origen != null && mapaCiudades.search(ciudad2) != null && !ciudades.contains(ciudad1) && !ciudades.contains(ciudad2)) {
            devolverCaminosExeptuandoHelper(mapaCiudades, origen, ciudad2, caminos, new LinkedList<String>(), new boolean[mapaCiudades.getSize()]);
        }
        return caminos;
    }
    private void devolverCaminosExeptuandoHelper(Graph<String> grafo, Vertex<String> origen, String destino, List<List<String>> caminos, List<String> actual, boolean[] marcas){
        marcas[origen.getPosition()] = true;
        actual.add(origen.getData());
        boolean llegue = origen.getData().equals(destino);
        if(llegue){
            caminos.add(new LinkedList<>(actual));
        } else{
            for(Edge<String> e: grafo.getEdges(origen)){
                Vertex<String> v = e.getTarget();
                if(!marcas[v.getPosition()]){
                    devolverCaminosExeptuandoHelper(grafo, v, destino, caminos, actual, marcas);
                }
            }
        }
        actual.removeLast();
        marcas[origen.getPosition()] = false;
    }

    public List<String> caminoMasCorto(String ciudad1, String ciudad2) {
        List<String> camino = new LinkedList<>();
        Vertex<String> origen = mapaCiudades.search(ciudad1);
        if(origen != null && mapaCiudades.search(ciudad2) != null) {
            caminoMasCortoHelper(mapaCiudades, origen, ciudad2, camino, new LinkedList<String>(), Integer.MAX_VALUE, 0, new boolean[mapaCiudades.getSize()]);
        }
        return camino;
    }
    private int caminoMasCortoHelper(Graph<String> grafo, Vertex<String> origen, String destino, List<String> mejorCamino, List<String> caminoActual, int minimo, int actual, boolean[] marcas){
        marcas[origen.getPosition()] = true;
        caminoActual.add(origen.getData());
        if(origen.getData().equals(destino)){
            if(actual < minimo){
                mejorCamino.clear();
                mejorCamino.addAll(caminoActual);
                minimo = actual;
            }
        } else {
            for(Edge<String> e: grafo.getEdges(origen)){
                Vertex<String> v = e.getTarget();
                int peso = e.getWeight();
                if(!marcas[v.getPosition()] && actual + peso < minimo){
                    minimo = caminoMasCortoHelper(grafo, v, destino, mejorCamino, caminoActual, minimo, actual + peso, marcas);
                }
            }
        }
        caminoActual.removeLast();
        marcas[origen.getPosition()] = false;
        return minimo;
    }

    public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){
        List<String> camino = new LinkedList<>();
        Vertex<String> origen = mapaCiudades.search(ciudad1);
        if(origen != null && mapaCiudades.search(ciudad2) != null) {
            caminoSinCargarCombustibleHelper(mapaCiudades, origen, ciudad2, camino, 0, tanqueAuto, new boolean[mapaCiudades.getSize()]);
        }
        return camino;
    }
    private boolean caminoSinCargarCombustibleHelper(Graph<String> grafo, Vertex<String> origen, String destino, List<String> camino, int combustible, int tanque, boolean[] marcas){
        marcas[origen.getPosition()]=true;
        camino.add(origen.getData());
        boolean encontre = origen.getData().equals(destino);
        if (encontre){
            return true;
        }

        Iterator<Edge<String>> it = grafo.getEdges(origen).iterator();
            while(!encontre  && it.hasNext()){
                Edge<String> e= it.next();
                int costo=  e.getWeight();
                Vertex <String> v = e.getTarget();
                if (!marcas[v.getPosition()] ) {
                    if(combustible + costo <= tanque){
                        encontre = caminoSinCargarCombustibleHelper(grafo,v,destino,camino,combustible + costo, tanque, marcas);
                    }
                }
            }

        if(!encontre){
            marcas[origen.getPosition()]=false;
            camino.removeLast();
        }
        return encontre;
    }

    public List<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto){
        List<String> camino = new LinkedList<>();
        Vertex<String> origen = mapaCiudades.search(ciudad1);
        if(origen != null && mapaCiudades.search(ciudad2) != null) {
            caminoConMenorCargaDeCombustibleHelper(mapaCiudades, origen, ciudad2, new LinkedList<String>(),  camino, Integer.MAX_VALUE, 0, tanqueAuto, new boolean[mapaCiudades.getSize()]);
        }
        return camino;
    }
    private int caminoConMenorCargaDeCombustibleHelper(Graph<String> grafo, Vertex<String> origen, String destino, List<String> actual, List<String> menor, int minimo, int combustible, int tanque, boolean[] marcas){
        marcas[origen.getPosition()] = true;
        actual.add(origen.getData());
        if(origen.getData().equals(destino)){
            double calculo = Math.ceil((double) tanque/combustible);
            int cargas = calculo <= 1 ? 0 : (int) calculo;
            if(cargas < minimo){
                minimo = cargas;
                menor.clear();
                menor.addAll(actual);
            }
        } else{
            for(Edge<String> e: grafo.getEdges(origen)){
                Vertex<String> v = e.getTarget();
                int costo = e.getWeight();
                int total = combustible + costo;
                if(costo <= tanque){
                    minimo = caminoConMenorCargaDeCombustibleHelper(grafo, v, destino, actual, menor, minimo, total, tanque, marcas);
                }
            }
        }

        actual.removeLast();
        marcas[origen.getPosition()]=false;
        return minimo;
    }

    public static void imprimirLista(List<String> camino){
        if (camino != null) {
            for (String ciudad : camino) {
                System.out.println(ciudad);
            }
        }
    }

    public static void main(String[] args) {
        Graph<String> cityGraph = new AdjListGraph<>();

        Vertex<String> buenosAires = cityGraph.createVertex("Buenos Aires");
        Vertex<String> laPlata = cityGraph.createVertex("La Plata");
        Vertex<String> rosario = cityGraph.createVertex("Rosario");
        Vertex<String> cordoba = cityGraph.createVertex("Córdoba");
        Vertex<String> ensenada = cityGraph.createVertex("Ensenada");
        Vertex<String> berisso = cityGraph.createVertex("Berisso");
        Vertex<String> marDelPlata = cityGraph.createVertex("Mar del Plata");
        Vertex<String> sanNicolas = cityGraph.createVertex("San Nicolás");
        Vertex<String> tandil = cityGraph.createVertex("Tandil");
        Vertex<String> junin = cityGraph.createVertex("Junín");
        Vertex<String> necochea = cityGraph.createVertex("Necochea");
        Vertex<String> pergamino = cityGraph.createVertex("Pergamino");
        Vertex<String> azul = cityGraph.createVertex("Azul");
        Vertex<String> villaMaria = cityGraph.createVertex("Villa María");
        Vertex<String> santaFe = cityGraph.createVertex("Santa Fe");

        cityGraph.connect(buenosAires, laPlata, 60);
        cityGraph.connect(buenosAires, rosario, 300);
        cityGraph.connect(buenosAires, marDelPlata, 400);
        cityGraph.connect(rosario, cordoba, 400);
        cityGraph.connect(rosario, santaFe, 150);
        cityGraph.connect(santaFe, cordoba, 350);
        cityGraph.connect(cordoba, villaMaria, 140);
        cityGraph.connect(laPlata, cordoba, 500);
        cityGraph.connect(laPlata, ensenada, 10);
        cityGraph.connect(laPlata, berisso, 15);
        cityGraph.connect(marDelPlata, tandil, 180);
        cityGraph.connect(tandil, azul, 140);
        cityGraph.connect(pergamino, sanNicolas, 110);
        cityGraph.connect(junin, pergamino, 90);
        cityGraph.connect(necochea, marDelPlata, 130);
        /*
            cityGraph.connect(cordoba,ensenada,5);
            cityGraph.connect(ensenada,villaMaria,20);
        */

        Mapa mapa = new Mapa();
        mapa.mapaCiudades = cityGraph;

        System.out.println("Cities in the graph:");
        for (Vertex<String> city : cityGraph.getVertices()) {
            System.out.println("- " + city.getData());
        }

        System.out.println("\nConnections:");
        for (Vertex<String> city : cityGraph.getVertices()) {
            for (Edge<String> edge : cityGraph.getEdges(city)) {
                System.out.println(city.getData() + " -> " + edge.getTarget().getData() + " (" + edge.getWeight() + " km)");
            }
        }

        System.out.println(" Ejercicio 1------------------------------------------------------------------");

        List<String> camino = mapa.devolverCamino("Buenos Aires", "Mar del Plata");

        imprimirLista(camino);

        System.out.println(" Ejercicio 2------------------------------------------------------------------");
        List<String> exeptuadas = new LinkedList<>();
        exeptuadas.add("La Plata");
        exeptuadas.add("Rosario");
        camino = mapa.devolverCaminoExeptuando("Buenos Aires", "Villa María", exeptuadas);

        imprimirLista(camino);

        System.out.println(" Ejercicio 2 con todos--------------------------------------------------------");
        exeptuadas.clear();
        exeptuadas.add("Ensenada");

        List<List<String>> caminos = new LinkedList<>();
        caminos = mapa.devolverCaminosExeptuando("Buenos Aires", "Villa María", exeptuadas);

        for(List<String> lista : caminos) {
            imprimirLista(lista);
            System.out.println("Otro camino_________________________________");
        }

        System.out.println(" Ejercicio 3--------------------------------------------------------");
        camino = mapa.caminoMasCorto("Buenos Aires", "Villa María");

        imprimirLista(camino);

        System.out.println(" Ejercicio 4--------------------------------------------------------");
        camino = mapa.caminoSinCargarCombustible("Buenos Aires", "Villa María", 780);

        imprimirLista(camino);

        System.out.println(" Ejercicio 5--------------------------------------------------------");
        camino = mapa.caminoConMenorCargaDeCombustible("Buenos Aires", "Villa María", 350);

        imprimirLista(camino);



    }
}


