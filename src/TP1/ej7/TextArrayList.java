package TP1.ej7;
import java.util.*;

public class TextArrayList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList(args));
        // List<String> list = new LinkedList<String>(Arrays.asList(args)); -> Inciso b

        System.out.println("----------- FOR EACH -------------");

        for(String s: list){
            System.out.println(s);
        }

        System.out.println("----------- ITERATOR -------------");

        Iterator<String> iter = list.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }

        System.out.println("----------- FOR -------------");

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

    }
}
