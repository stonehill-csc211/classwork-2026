public interface MyList<T> {
    public void add(T value);
    public T remove(int position);
    public T get(int position);
    public T set(int position, T newValue);
    public void insert(int position, T value);
    public boolean contains(T value);
}
