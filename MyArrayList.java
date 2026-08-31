public class MyArrayList<T> implements MyList<T>{

    private Object[] data;
    private int length;

    public MyArrayList(){
        data = new Object[10];
        length = 0;
    }

    @Override
    public void add(T value) {
        data[length] = value;
        length++;

        if(length > data.length){
            resize(length * 2);
        }

    }

    private void resize(int newLength){
        Object[] newData = new Object[newLength];
        for(int i = 0; i < length; i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T remove(int position) {
        T temp = (T)data[position];
        shiftLeft(position);
        this.length--;
        return temp;
    }

    private void shiftLeft(int position){
        if(data[position] == null) return;
        else{
            data[position] = data[position + 1];
            shiftLeft(position + 1);
        }
    }

    private void shiftRight(int position, int end){
        if(position == end) return;
        else{
            data[end] = data[end - 1];
            shiftRight(position, end - 1);
        }
    }

    @Override
    public T get(int position) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public T set(int position, T newValue) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public void insert(int position, T value) {
        shiftRight(position, this.length+1);
        data[position] = value;
    }

    @Override
    public boolean contains(T value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < data.length; i++){
            if(data[i] == null) sb.append("null");
            else sb.append(data[i].toString());
            sb.append(" ");
        }
        sb.append("Length: " + length);
        return sb.toString();
    }

    public static void main(String[] args){
        MyArrayList<Integer> myList = new MyArrayList<>();
        myList.add(1);
        myList.add(3);
        myList.add(5);
        myList.add(6);
        myList.add(8);

        System.out.println("Expecting: 8");
        System.out.println(myList.remove(4));
        System.out.println(myList.remove(1));

        System.out.println(myList);

        myList.insert(2, 15);

        System.out.println(myList);
    }
    
}
