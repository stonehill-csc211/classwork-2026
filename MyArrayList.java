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

    @Override
    public T remove(int position) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public boolean contains(T value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }
    
}
