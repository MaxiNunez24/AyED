package TP3;
import java.util.List;
import java.util.LinkedList;

public class Caminos {
    GeneralTree<Integer> arbol;

    public List<Integer> caminoAHojaMasLejana(){
        List<Integer> caminoMaximo = new LinkedList<>();
        if (arbol!= null){
            caminoHelper(arbol, caminoMaximo, new LinkedList<Integer>());
        }
        return caminoMaximo;
    }

    private List<Integer> caminoHelper(GeneralTree<Integer> arbol, List<Integer> camino, List<Integer> caminoActual){
        caminoActual.add(arbol.getData());
        if(arbol.isLeaf()) {
            if (caminoActual.size() > camino.size()) {
                camino.clear();
                camino.addAll(caminoActual);
            }
        }else {
            for(GeneralTree<Integer> child : arbol.getChildren()){
                caminoHelper(child, camino, caminoActual);
            }
        }
        caminoActual.remove(caminoActual.size()-1);
        return camino;
    }

        public static void main(String[] args) {
            // Crear nodos del árbol
            GeneralTree<Integer> root = new GeneralTree<>(1);
            GeneralTree<Integer> child1 = new GeneralTree<>(2);
            GeneralTree<Integer> child2 = new GeneralTree<>(3);
            GeneralTree<Integer> child3 = new GeneralTree<>(4);
            GeneralTree<Integer> grandChild1 = new GeneralTree<>(5);
            GeneralTree<Integer> grandChild2 = new GeneralTree<>(6);
            GeneralTree<Integer> grandChild3 = new GeneralTree<>(7);

            // Construir el árbol
            child1.addChild(grandChild1);
            child1.addChild(grandChild2);
            grandChild2.addChild(grandChild3);
            root.addChild(child1);
            root.addChild(child2);
            root.addChild(child3);

            // Crear instancia de Caminos y asignar el árbol
            Caminos caminos = new Caminos();
            caminos.arbol = root;

            // Probar el método caminoAHojaMasLejana
            List<Integer> camino = caminos.caminoAHojaMasLejana();
            System.out.println("Camino a la hoja más lejana: " + camino);
        }
    }


