package TP3;
import java.util.Iterator;

public class esPrefijo {

    public static boolean esPrefijoRaiz(GeneralTree<Integer> arbol1, GeneralTree<Integer> arbol2) {
        if((arbol1 !=null && arbol2 != null) && (!arbol1.isEmpty() && !arbol2.isEmpty())){
            return esPrefijoRaizHelper(arbol1, arbol2);
        }
        return false;
    }

    private static boolean esPrefijoRaizHelper(GeneralTree<Integer> arbol1, GeneralTree<Integer> arbol2){
        if(!arbol1.getData().equals(arbol2.getData())){
            return false;
        }
        Iterator<GeneralTree<Integer>> it1 = arbol1.getChildren().iterator();
        Iterator<GeneralTree<Integer>> it2 = arbol2.getChildren().iterator();

        while(it1.hasNext() && it2.hasNext()){
            GeneralTree<Integer> hijo1 = it1.next(), hijo2 = it2.next();
            if(!esPrefijoRaizHelper(hijo1, hijo2)){
                return false;
            }
        }
        return !it2.hasNext();
    }


    public static boolean esPrefijoInterno(GeneralTree<Integer> arbol1, GeneralTree<Integer> arbol2) {
        if((arbol1 !=null && arbol2 != null) && (!arbol1.isEmpty() && !arbol2.isEmpty())){
            return esPrefijoInternoHelper(arbol1, arbol2);
        }
        return false;
    }

    private static boolean esPrefijoInternoHelper(GeneralTree<Integer> arbol1, GeneralTree<Integer> arbol2){
        if(arbol1.getData().equals(arbol2.getData())){
            return esPrefijoRaiz(arbol1, arbol2);
        }else {
            Iterator<GeneralTree<Integer>> it1 = arbol1.getChildren().iterator();
            while(it1.hasNext()){
                GeneralTree<Integer> hijo1 = it1.next();
                if(esPrefijoInternoHelper(hijo1, arbol2)){
                    return true;
                };
            }
            return false;
        }
    }

    public static void main(String[] args) {
        // Crear árboles de prueba
        GeneralTree<Integer> arbol1 = new GeneralTree<>(1);
        GeneralTree<Integer> arbol2 = new GeneralTree<>(1);

        // Añadir hijos al primer árbol (arbol1)
        GeneralTree<Integer> child1 = new GeneralTree<>(2);
        GeneralTree<Integer> child2 = new GeneralTree<>(3);
        arbol1.addChild(child1);
        arbol1.addChild(child2);

        // Añadir hijos al segundo árbol (arbol2)
        GeneralTree<Integer> child3 = new GeneralTree<>(2);
        arbol2.addChild(child3);

        // Probar si arbol2 es prefijo de arbol1
        boolean resultado = esPrefijoRaiz(arbol1, arbol2);
        System.out.println("¿Es arbol2 prefijo raiz de arbol1? " + resultado);

        // Crear otro caso de prueba
        GeneralTree<Integer> arbol3 = new GeneralTree<>(7);
        GeneralTree<Integer> child4 = new GeneralTree<>(9);
        GeneralTree<Integer> child5 = new GeneralTree<>(10);
        arbol3.addChild(child4);
        arbol3.addChild(child5);

        // Probar si arbol3 es prefijo de arbol1
        boolean resultado2 = esPrefijoRaiz(arbol1, arbol3);
        System.out.println("¿Es arbol3 prefijo raíz de arbol1? " + resultado2);
        // Crear el árbol más grande (arbolGrande)
        GeneralTree<Integer> arbolGrande = new GeneralTree<>(1);

// Nivel 1
        GeneralTree<Integer> child21 = new GeneralTree<>(2);
        GeneralTree<Integer> child31 = new GeneralTree<>(3);
        GeneralTree<Integer> child41 = new GeneralTree<>(4);
        arbolGrande.addChild(child21);
        arbolGrande.addChild(child31);
        arbolGrande.addChild(child41);

// Nivel 2
        GeneralTree<Integer> child51 = new GeneralTree<>(5);
        GeneralTree<Integer> child61 = new GeneralTree<>(6);
        child21.addChild(child51);
        child21.addChild(child61);

        GeneralTree<Integer> child7 = new GeneralTree<>(7);
        child31.addChild(child7);

// Nivel 3
        GeneralTree<Integer> child8 = new GeneralTree<>(8);
        child51.addChild(child8);

        GeneralTree<Integer> child9 = new GeneralTree<>(9);
        GeneralTree<Integer> child10 = new GeneralTree<>(10);
        child7.addChild(child9);
        child7.addChild(child10);

// Probar si algún árbol es prefijo de arbolGrande
        boolean resultado3 = esPrefijoRaiz(arbol1,arbolGrande);
        System.out.println("¿Es arbol1 prefijo raiz de arbolGrande? " + resultado3);


        // Probar si algún árbol es prefijo de arbolGrande
        boolean resultado4 = esPrefijoInterno(arbolGrande, arbol3);
        System.out.println("¿Es arbol3 es prefijo interno de arbolGrande? " + resultado4);
    }

}
