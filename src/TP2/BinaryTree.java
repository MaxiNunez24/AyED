package TP2;

public class BinaryTree <T> {
    private T data;
    private BinaryTree<T> rightChild;
    private BinaryTree<T> leftChild;

    public BinaryTree(){
        this.data = null;
        this.rightChild = null;
        this.leftChild = null;
    }

    public BinaryTree(T data){
        this.data = data;
        this.rightChild = null;
        this.leftChild = null;
    }

    public T getData(){
        return this.data;
    }

    public void setData(T data){
        this.data = data;
    }

    public BinaryTree<T> getRightChild(){
        return this.rightChild;
    }

    public BinaryTree<T> getLeftChild(){
        return this.leftChild;
    }

    public void addRightChild(BinaryTree<T> rightChild){
        this.rightChild = rightChild;
    }

    public void addLeftChild(BinaryTree<T> leftChild){
        this.leftChild = leftChild;
    }

    public void removeLeftChild(){
        this.leftChild = null;
    }

    public void removeRightChild(){
        this.rightChild = null;
    }

    public boolean hasLeftChild(){
        return this.leftChild != null;
    }

    public boolean hasRightChild(){
        return this.rightChild != null;
    }

    public boolean isLeaf(){
        return !this.hasLeftChild() && !this.hasRightChild();
    }

    public boolean isEmpty(){
        return (this.isLeaf() && this.getData() == null);
    }

    @Override
    public String toString(){
        return this.getData().toString();
    }


}
