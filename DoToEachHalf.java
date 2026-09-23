import java.util.ArrayList;
import java.util.List;

public class DoToEachHalf {
    public static void doToEachHalf(List<Integer> lst){
        int size = lst.size();
        for(int i = 0; i < size; i++){
            lst.set(i, lst.get(i) + 1);
        }
        if(size <= 1) return;
        doToEachHalf(lst.subList(0, size / 2));
        doToEachHalf(lst.subList(size/2, size));
    }

    public static void main(String[] args){
        ArrayList<Integer> myList = new ArrayList<>();
        for(int i = 0; i < 32; i++){
            myList.add(0);
        }
        doToEachHalf(myList);
        for(int i = 0; i < myList.size(); i++){
            System.out.print(myList.get(i));
        }
        System.out.println();
    }
}
