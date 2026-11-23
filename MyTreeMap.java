import javax.management.openmbean.KeyAlreadyExistsException;

public class MyTreeMap<K extends Comparable, V> {
    private BinarySearchTree<Record> tree;

    public MyTreeMap(){
        tree = new BinarySearchTree<>();
    }

    public void put(K key, V value) throws KeyAlreadyExistsException{
        Record r = new Record(key, value);
        if(tree.contains(r)) throw new KeyAlreadyExistsException();
        tree.add(r);
    }

    public boolean contains(K key){
        Record r = new Record(key, null);
        return tree.contains(r);
    }

    public V remove(K key){
        Record r = new Record(key, null);
        Record existingRecord = tree.getElement(r);
        tree.remove(r);
        return existingRecord.value;
    }

    public V get(K key){
        Record r = new Record(key, null);
        Record existingRecord = tree.getElement(r);
        return existingRecord.value;
    }

    public void set(K key, V newValue){
        Record r = new Record(key, null);
        Record existingRecord = tree.getElement(r);
        existingRecord.value = newValue;
    }

    private class Record implements Comparable<Record>{
        K key;
        V value;

        private Record(K key, V value){
            this.key = key;
            this.value = value;
        }

        public int compareTo(Record other){
            return this.key.compareTo(other.key);
        }
    }

    public static void main(String[] args){
        MyTreeMap<String, Integer> inventory = new MyTreeMap<>();
        inventory.put("Apple", 12);
        inventory.put("Banana", 36);
        inventory.put("Mango", 3);
        inventory.put("Pineapple", 5);

        System.out.println(inventory.contains("Mango"));
        System.out.println(inventory.contains("Papaya"));
    }
}
