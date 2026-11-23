public class Heap<T extends Comparable> {
    private Object[] data;
    private int end;
    public Heap(){
        data = new Object[10];
        end = 1;
    }

    public void add(T newElement){
        if(end >= data.length) resize(data.length * 2);
        data[end] = newElement;
        int current = end;
        end++;
        T currentValue = (T)data[current];
        if(parent(current) <= 0) return;
        T parentValue = (T)data[parent(current)];
        while(current > 1 && currentValue.compareTo(parentValue) > 0){
            swap(data, current, parent(current));
            current = parent(current);
            currentValue = (T)data[current];
            parentValue = (T)data[parent(current)];
        }
    }

    public T removeMax(){
        T retval = (T)data[1];
        data[1] = data[end-1];
        end--;
        reheap(1);
        return retval;
    }

    private void reheap(int root){
        if(root * 2 + 1 > end){
            return;
        }
        T rootValue = (T)data[root];
        // find the larger child
        int left = root * 2;
        T leftValue = (T)data[left];
        int right = root * 2 + 1;
        int largerChild;
        T largerChildValue;
        if(right > end){
            largerChild = left;
            largerChildValue = leftValue;
        }
        else {
            T rightValue = (T)data[right];

            if(leftValue.compareTo(rightValue) > 0){
                largerChild = left;
                largerChildValue = leftValue;
            } else{
                largerChild = right;
                largerChildValue = rightValue;
            }
        }
        // check whether the larger child is bigger than root
        if(rootValue.compareTo(largerChildValue) > 0){
            return;
        } else {
            swap(data, root, largerChild);
            reheap(largerChild);
        }
    }

    private void swap(Object[] arr, int i, int j){
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int parent(int i){
        return i / 2;
    }

    private void resize(int newLength){
        Object[] newData = new Object[newLength];
        for(int i = 0; i < end; i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < data.length; i++){
            if(data[i] == null) sb.append("null");
            else sb.append(data[i].toString());
            sb.append(" ");
        }
        sb.append("End: " + end);
        return sb.toString();
    }

    public static void main(String[] args){
        Heap<Integer> myHeap = new Heap<Integer>();
        myHeap.add(5);
        myHeap.add(10);
        myHeap.add(3);
        myHeap.add(9);
        System.out.println(myHeap);
        System.out.println(myHeap.removeMax());
        System.out.println(myHeap.removeMax());
        System.out.println(myHeap);
    }
}
