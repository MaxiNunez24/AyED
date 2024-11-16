    package TP2;

    public class esPrefijo {

        public boolean esPrefijoRaiz(BinaryTree<Integer>arbol1 , BinaryTree<Integer>arbol2) {
            boolean ok=true;
            if(arbol1.isEmpty() || arbol2.isEmpty()) {
                return false;
            }
            else {
                ok=esPrefijoRaizHelper(arbol1,arbol2);
            }
            return ok;
        }

        private boolean esPrefijoRaizHelper(BinaryTree<Integer>arbol1 , BinaryTree<Integer>arbol2) {
            boolean ok=true;
            if(!(arbol1.getData().equals(arbol2.getData()))){
                ok=false;
            }
            else{
                if(arbol1.hasLeftChild() && arbol2.hasLeftChild()) {
                    ok= esPrefijoRaizHelper(arbol1.getLeftChild(), arbol2.getLeftChild());
                }
                if(ok && arbol1.hasRightChild() && arbol2.hasRightChild()) {
                    ok= esPrefijoRaizHelper(arbol1.getRightChild(), arbol2.getRightChild());
                }

            }
            return ok;
        }

        public boolean esPrefijoInterno(BinaryTree<Integer>arbol1 , BinaryTree<Integer>arbol2) {
            boolean ok=true;
            if(arbol1.isEmpty() || arbol2.isEmpty()) {
                return false;
            }
            else {
                ok=esPrefijoInternoHelper(arbol1,arbol2);
            }
            return ok;
        }

        private boolean esPrefijoInternoHelper(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2){
            boolean ok=true;
            if(arbol1.getData().equals(arbol2.getData())){
                return esPrefijoRaiz(arbol1, arbol2);
            }else{
                if(arbol1.hasLeftChild()){
                    ok= esPrefijoInternoHelper(arbol1.getLeftChild(), arbol2);
                }
                if(ok && arbol1.hasRightChild()){
                    ok= esPrefijoInternoHelper(arbol1.getRightChild(), arbol2);
                }
            }
            return ok;
        }

        public static void main(String[] args) {
            // Crear nodos del árbol 1
            BinaryTree<Integer> arbol1 = new BinaryTree<>(1);
            arbol1.addLeftChild(new BinaryTree<>(2));
            arbol1.addRightChild(new BinaryTree<>(3));
            arbol1.getLeftChild().addLeftChild(new BinaryTree<>(4));
            arbol1.getLeftChild().addRightChild(new BinaryTree<>(5));

            // Crear nodos del árbol 2
            BinaryTree<Integer> arbol2 = new BinaryTree<>(2);
            arbol2.addLeftChild(new BinaryTree<>(4));
            /*arbol2.addRightChild(new BinaryTree<>(3));
            arbol2.getLeftChild().addLeftChild(new BinaryTree<>(4));*/

            // Crear instancia de ParcialArboles y probar el método esPrefijo
            esPrefijo esPrefijoRaiz = new esPrefijo();
            boolean resultado1 = esPrefijoRaiz.esPrefijoRaiz(arbol1, arbol2);
            System.out.println("El árbol 2 es prefijo raíz del árbol 1: " + resultado1);

            esPrefijo esPrefijoInterno = new esPrefijo();
            boolean resultado2 = esPrefijoRaiz.esPrefijoInterno(arbol1, arbol2);
            System.out.println("El árbol 2 es prefijo interno del árbol 1: " + resultado2);
        }
    }
