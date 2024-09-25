package TP1;
import java.util.*;

public class Stack<T> {
    private List<T> data;

    public Stack() {
        data = new ArrayList<T>();
    }

    public void push(T item) {
        data.addLast(item);
    }

    public T pop() {
        return data.removeFirst();
    }

    public T top (){
        return data.getLast();
    }

    public int size(){
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public String toString() {
        String str = "[";
        for (T d: data) str += d + ", ";
        str = str.substring(0, str.length() - 2)+"]";
        return str;
    }
    

}
