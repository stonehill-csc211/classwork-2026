public class BinarySearchTree<T extends Comparable<T>> {

    Node root;

    int size;

    public BinarySearchTree(){
        root = null;
        size = 0;
    }

    public void add(T newElement){
        if(root == null){
            root = new Node(newElement);
            size++;
        } else{
            if(root.add(newElement)){
                size++;
            }
        }
        
    }

    public boolean contains(T query){
        if(root == null){
            return false;
        } else{
            return root.contains(query);
        }
    }

    public void remove(T element){
        if(root != null){
            // handle the case where we're removing the last element
            root = root.remove(element);
        }
    }

    

    private class Node{
        T value;
        Node left, right;

        private Node(T value){
            this.value = value;
        }

        private boolean add(T newElement){
            if(newElement.compareTo(value) < 0){
                if(left == null){
                    left = new Node(newElement);
                    return true;
                } else {
                    return left.add(newElement);
                }
            } else if(newElement.compareTo(value) > 0){
                if(right == null){
                    right = new Node(newElement);
                    return true;
                } else {
                    return right.add(newElement);
                }
            } else return false;
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
        
        /**
        * Remove a value from the tree and return this node's new value
        * Usually the new value will be this. Sometimes it will be null.
        */
        private Node remove(T valueToRemove){
            // if we've found the right node
            if(valueToRemove.compareTo(value) == 0){
                return removeFromRoot();
            // if it's smaller look down the left subtree
            } else if(valueToRemove.compareTo(value) < 0){
                if(left == null) return this;
                else{
                    left = left.remove(valueToRemove);
                    return this;
                }
            // if it's larger look down the right subtree
            } else{
                if(right == null) return this;
                else{
                    right = right.remove(valueToRemove);
                    return this;
                }
            }
        }

        /**
         * Remove this node by swapping its value or returning its replacement
         */
        private Node removeFromRoot(){
            Node largestNode;
            // if we've got two children
            if(left != null && right != null){
                largestNode = left.getLargestChild();
                // we take its value
                value = largestNode.value;
                // then remove the node
                if(largestNode == left) left = null;
                else left.removeLeaf(largestNode);
                size--;
                return this;
            } else if(right != null){
                size--;
                return right;
            } else if(left != null){
                size--;
                return left;
            } else{
                size--;
                return null;
            }
        }
        /**
         * Simply remove n from the tree
         * assumes that n is a leaf
         */
        private void removeLeaf(Node n){
            if(left == n){
                left = null;
            } else if(right == n){
                right = null;
            } else if(n.value.compareTo(value) < 0){
                left.removeLeaf(n);
            } else{
                right.removeLeaf(n);
            }
        }

        private Node getLargestChild(){
            if(right != null) return right.getLargestChild();
            else return this;
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
        myBst.remove(5);
        System.out.println(myBst.contains(5));

        System.out.println(myBst.contains(3));
        myBst.remove(3);
        System.out.println(myBst.contains(3));
    }
}