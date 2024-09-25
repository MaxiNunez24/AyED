package TP1.ej8;

public class DoubleEndedQueue<T> extends Queue<T> {
    public void enqueueFirst(T elem){
        data.addFirst(elem);
    }
}
