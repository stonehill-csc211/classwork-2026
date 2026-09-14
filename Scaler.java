import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Scaler {
    public static void scale(List<Integer> l, int s){
        ListIterator<Integer> it = l.listIterator();
        Integer current;
        while(it.hasNext()){
            current = it.next();
            it.set(current * s);
        }
    }

    public static void main(String args[]){
        ArrayList<Integer> l = new ArrayList<Integer>();
        l.add(1);
        l.add(3);
        l.add(5);
        scale(l, 3);
        System.out.println(l);
    }
}
