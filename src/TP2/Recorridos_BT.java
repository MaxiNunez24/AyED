package TP2;

public class Recorridos_BT {
    public void printPreOrden(BinaryTree<Integer> bt){
        System.out.print(bt.getData() + " ");
        if(bt.hasLeftChild()){
            printPreOrden(bt.getLeftChild());
        }
        if (bt.hasRightChild()){
            printPreOrden(bt.getRightChild());
        }
    }
}
