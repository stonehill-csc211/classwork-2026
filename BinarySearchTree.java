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
        } else{
            root.add(newElement);
        }
        size++;
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
            if(element.compareTo(root.value) == 0 && size==1){
                root = null;
                size = 0;
            }
            else if(root.remove(element)){
                size--;
            }
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
        
        /**
        * Remove a value from the tree and shift a new value into its place
        * only works if the size is greater than 1, if the size is 1, handle
        * it in the public method
        */
        private boolean remove(T valueToRemove){
            if(valueToRemove.compareTo(value) == 0){
                removeByReplacement(); // we know this won't fail because the size is greater than 1
                return true;
            } else if(valueToRemove.compareTo(value) < 0){
                // If it's the same as the left child
                if(valueToRemove.compareTo(left.value) == 0){
                    if(!left.removeByReplacement()){
                        left = null;
                    }
                    return true;
                }
                // otherwise recurse
                else return this.left.remove(valueToRemove);
            } else {
                if(valueToRemove.compareTo(this.right.value) == 0){
                    if(!right.removeByReplacement()){
                        right = null;
                    }
                    return true;
                } else return this.right.remove(valueToRemove);
            }
        }
        

        private boolean removeByReplacement(){
            // remove the data by swapping with a descendant and deleting
            Node descendant;
            if(this.left == null && this.right == null){ // we're at a leaf
                return false;
            } else if(this.left == null){
                // find the smallest right descendant
                descendant = this.findSmallestLeafParent();
                this.value = descendant.left.value;
                descendant.left = null;
            } else{
                // find the largest left descendant
                descendant = this.findLargestLeafParent();
                this.value = descendant.right.value;
                descendant.right = null;
            }
            return true;
            
        }

        private Node findLargestLeafParent(){
            // helper for remove
            if(this.right.right == null) return this;
            else return this.right.findLargestLeafParent();
        }

        private Node findSmallestLeafParent(){
        // helper for remove
            if(this.left.left == null) return this;
            else return this.left.findSmallestLeafParent();
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