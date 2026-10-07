public class BinarySearchTree<T extends Comparable<T>> {

    Node root;

    public BinarySearchTree(){
        root = null;
    }

    public void add(T newElement){
        if(root == null){
            root = new Node(newElement);
        } else{
            root.add(newElement);
        }
    }

    public boolean contains(T query){
        if(root == null){
            return false;
        } else{
            return root.contains(query);
        }
    }

    private class Node{
        T value;
        Node left, right;

        private Node(T value){
            this.value = value;
        }

        private void add(T newElement){
            if(newElement.compareTo(value) < 0){
                if(left == null){
                    left = new Node(newElement);
                } else {
                    left.add(newElement);
                }
            } else if(newElement.compareTo(value) > 0){
                if(right == null){
                    right = new Node(newElement);
                } else {
                    right.add(newElement);
                }
            }
        }

        private boolean contains(T query){
            if(query.compareTo(value) == 0){
                return true;
            } else if(query.compareTo(value) < 0){
                if(left == null) return false;
                return left.contains(query);
            } else {
                if(right == null) return false;
                return right.contains(query);
            }
        }

        private boolean removeLeaf(T element){
            // TODO
            // This only works if element is in a leaf
            if(element.compareTo(left.value) == 0 
            && left.left == null && left.right == null){
                left = null;
                return true;
            } else if(element.compareTo(right.value) == 0
            && right.left == null && right.right == null){
                right = null;
                return true;
            } else {
                if(element.compareTo(value) < 0){
                    return left.removeLeaf(element);
                } else if(element.compareTo(value) > 0){
                    return right.removeLeaf(element);
                } else {
                    return false;
                }
            }
        }
    }

    public static void main(String[] args){
        BinarySearchTree<Integer> myBst = new BinarySearchTree<>();
        myBst.add(3);
        myBst.add(4);
        myBst.add(5);
        myBst.add(2);
        System.out.println(myBst.contains(5));
        System.out.println(myBst.contains(1));
    }
}
