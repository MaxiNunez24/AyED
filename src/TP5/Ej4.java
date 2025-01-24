package TP5;

import TP5.adjList.AdjListGraph;

import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class Ej4 {
    public static List<String> paseoEnBici(Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos){
        List<String> camino = new LinkedList<>();
        Vertex<String> origen = lugares.search("Ayuntamiento");
        if(origen != null && lugares.search(destino) != null){
            paseoEnBiciHelper(lugares, origen, destino, camino, 0, maxTiempo, lugaresRestringidos, new boolean[lugares.getSize()]);
        }
        return camino;
    }

    private static boolean paseoEnBiciHelper(Graph<String> grafo, Vertex<String> origen, String destino, List<String> camino, int tiempoActual, int maxTiempo, List<String> lugaresRestringidos, boolean[] marcas){
        marcas[origen.getPosition()] = true;
        camino.add(origen.getData());
        boolean llegue = origen.getData().equals(destino);
        if(llegue){
            System.out.println(tiempoActual);
            return llegue;
        } else {
            Iterator<Edge<String>> it = grafo.getEdges(origen).iterator();
            while(!llegue && it.hasNext()){
                Edge<String> e = it.next();
                Vertex<String> v = e.getTarget();
                int proxTiempo = e.getWeight() + tiempoActual;
                if(!marcas[v.getPosition()] && !lugaresRestringidos.contains(v.getData()) &&  proxTiempo < maxTiempo){

                    llegue = paseoEnBiciHelper(grafo, v, destino, camino, proxTiempo, maxTiempo, lugaresRestringidos, marcas );
                }
            }
        }
        if(!llegue){
            camino.removeLast();
            marcas[origen.getPosition()] = false;
        }
        return llegue;
    }


    public static void main(String[] args) {
        Graph<String> cityGraph = new AdjListGraph<>();

        Vertex<String> holmenkollen = cityGraph.createVertex("Holmenkollen");
        Vertex<String> parqueVigeland = cityGraph.createVertex("Parque Vigeland");
        Vertex<String> folkMuseum = cityGraph.createVertex("FolkMuseum");
        Vertex<String> museoFram = cityGraph.createVertex("Museo Fram");
        Vertex<String> museoBarcoPolar = cityGraph.createVertex("Museo del Barco Polar");
        Vertex<String> museoVikingo = cityGraph.createVertex("Museo Vikingo");
        Vertex<String> galeriaNacional = cityGraph.createVertex("Galería Nacional");
        Vertex<String> palacioReal = cityGraph.createVertex("Palacio Real");
        Vertex<String> akkerBrigge = cityGraph.createVertex("Akker Brigge");
        Vertex<String> parqueBotanico = cityGraph.createVertex("Parque Botánico");
        Vertex<String> ayuntamiento = cityGraph.createVertex("Ayuntamiento");
        Vertex<String> museoMunch = cityGraph.createVertex("Museo Munch");
        Vertex<String> elTigre = cityGraph.createVertex("El Tigre");
        Vertex<String> laOpera = cityGraph.createVertex("La Opera");
        Vertex<String> fortalezaAkershus = cityGraph.createVertex("Fortaleza Akershus");

        cityGraph.connect(holmenkollen, parqueVigeland, 30);
        cityGraph.connect(parqueVigeland,holmenkollen, 30);

        cityGraph.connect(parqueVigeland, folkMuseum, 20);
        cityGraph.connect(folkMuseum,parqueVigeland , 20);

        cityGraph.connect(parqueVigeland, galeriaNacional, 10);
        cityGraph.connect(galeriaNacional, parqueVigeland, 10);

        cityGraph.connect(folkMuseum, museoFram, 5);
        cityGraph.connect(museoFram, folkMuseum, 5);

        cityGraph.connect(folkMuseum, akkerBrigge, 30);
        cityGraph.connect(akkerBrigge,folkMuseum, 30);

        cityGraph.connect(folkMuseum,palacioReal, 5);
        cityGraph.connect(palacioReal,folkMuseum, 5);

        cityGraph.connect(museoFram, museoBarcoPolar, 5);
        cityGraph.connect(museoBarcoPolar,museoFram, 5);

        cityGraph.connect(museoBarcoPolar, museoVikingo, 5);
        cityGraph.connect(museoVikingo, museoBarcoPolar, 5);

        cityGraph.connect(museoVikingo, akkerBrigge, 30);
        cityGraph.connect(akkerBrigge, museoVikingo, 30);

        cityGraph.connect(galeriaNacional, parqueBotanico, 15);
        cityGraph.connect(parqueBotanico, galeriaNacional, 15);

        cityGraph.connect(parqueBotanico, ayuntamiento, 10);
        cityGraph.connect(ayuntamiento, parqueBotanico, 10);

        cityGraph.connect(parqueBotanico, museoMunch, 1);
        cityGraph.connect(museoMunch, parqueBotanico, 1);

        cityGraph.connect(museoMunch, elTigre, 15);
        cityGraph.connect(elTigre, museoMunch, 15);

        cityGraph.connect(ayuntamiento, akkerBrigge, 20);
        cityGraph.connect(akkerBrigge, ayuntamiento, 20);

        cityGraph.connect(ayuntamiento, palacioReal, 5);
        cityGraph.connect(palacioReal, ayuntamiento, 5);

        cityGraph.connect(elTigre, ayuntamiento, 15);
        cityGraph.connect(ayuntamiento, elTigre, 15);

        cityGraph.connect(elTigre, laOpera, 5);
        cityGraph.connect(laOpera, elTigre, 5);

        cityGraph.connect(laOpera, fortalezaAkershus, 10);
        cityGraph.connect(fortalezaAkershus, laOpera, 10);

        List<String> lugaresProhibidos = new LinkedList<>();
        lugaresProhibidos.add("AkkerBrigge");
        lugaresProhibidos.add("Palacio Real");

        List<String> paseo = paseoEnBici(cityGraph, "Museo Vikingo", 120, lugaresProhibidos);

        for(String ciudad : paseo){
            System.out.println(ciudad);
        }

    }
}
