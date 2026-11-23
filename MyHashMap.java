public class MyHashMap<K,V>{

    private Object[] hashTable;

    public MyHashMap(){
        hashTable = new Object[10];
    }

    public void add(K key, V value){
        Record r = new Record(key, value);
        int hashValue = key.hashCode() % hashTable.length;
        insert(r, hashValue);
    }

    private void insert(Record r, int position){
        while(hashTable[position] != null){
            position++;
        }
        hashTable[position] = r;
    }

    private V get(K query){
        int hashCode = query.hashCode() % hashTable.length;
        Record current = (Record)hashTable[hashCode];
        while(!current.key.equals(query)){
            hashCode++;
            current = (Record)hashTable[hashCode];
        }
        return current.value;
    }

    private class Record{
        K key;
        V value;

        private Record(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
}