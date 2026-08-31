public class MyLinkedList<T>{

    private Node head, tail;

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
    }

    private class Node{
        T value;
        Node next;
    }

    public static void main(String[] args){
        MyLinkedList<Integer> myList = new MyLinkedList<>();
        myList.add(1);
        myList.add(3);
        myList.add(5);
        myList.add(6);
        myList.add(8);

        System.out.println(myList);

        /*System.out.println("Expecting: 8");
        System.out.println(myList.remove(4));
        System.out.println(myList.remove(1));

        System.out.println(myList);

        myList.insert(2, 15);

        System.out.println(myList);*/
    }
}
