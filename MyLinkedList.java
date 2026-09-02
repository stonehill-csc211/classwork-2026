public class MyLinkedList<T> implements MyList<T>{

    private Node head, tail;
    private int length;

    public MyLinkedList(){
        head = new Node();
        tail = head;
    }
    public void add(T value){
        if(head == tail && head.value == null){
            head.value = value;
        } else if(head == tail){
            Node newNode = new Node();
            newNode.value = value;
            head.next = newNode;
            tail = newNode;
        } else {
            Node newNode = new Node();
            newNode.value = value;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    @Override
    public void insert(int position, T value) {
        Node previous = getNode(position - 1);
        Node next = getNode(position);

        Node newNode = new Node();
        newNode.value = value;
        newNode.next = next;
        if(previous != null){
            previous.next = newNode;
        }
        length++;
    }

    private Node getNode(int position){
        if(position < 0) return null;
        if(position >= length) return null;

        Node current = head;
        for(int i = 0; i < position; i++){
            current = current.next;
        }
        return current;
    }

    @Override
    public T remove(int position) {
        T retval = null;
        if(position == 0){
            // removing the head
            retval = head.value;
            head = head.next;
            length--;
        } else if(position == length - 1){
            // removing the tail
            tail = getNode(position - 1);
            retval = tail.next.value;
            tail.next = null;
            length--;
        } else if(0 < position && position < length - 1){
            Node current = getNode(position - 1);
            retval = current.next.value;
            current.next = current.next.next;
            length--;
        }

        return retval;

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
    public boolean contains(T value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }

    private class Node{
        T value;
        Node next;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while(current != null){
            sb.append(current.value.toString());
            sb.append(" ");
            current = current.next;
        }
        return sb.toString();
    }

    public static void main(String[] args){
        MyLinkedList<Integer> myList = new MyLinkedList<>();
        myList.add(1);
        myList.add(3);
        myList.add(5);
        myList.add(6);
        myList.add(8);

        System.out.println(myList);

        myList.insert(2, 12);

        System.out.println(myList);
        System.out.println(myList.remove(1));
        System.out.println(myList.remove(4));

        System.out.println(myList);
    }
    
}
