package TP1.ej8;

import java.util.LinkedList;
import java.util.List;

public class Queue<T> {
    protected List<T> data;

    public Queue(){
        data = new LinkedList<T>();
    }

    public int size(){
        return data.size();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    public void enqueue(T dato){
        data.add(dato);
    }

    public T dequeue(){
        return data.removeFirst();
    }

    public T head(){
        return data.getFirst();
    }

    public String toString(){
        return data.toString();
    }


}
