public class BinaryTreeExample {
    BinaryTreeExample left;
    BinaryTreeExample right;
    String name;

    public BinaryTreeExample(String myName){
        name = myName;
        left = null;
        right = null;
    }

    public void addLeft(String leftName){
        if(this.left == null)
            this.left = new BinaryTreeExample(leftName);
        else
            this.left.addLeft(leftName);
    }

    public void addRight(String rightName){
        this.right = new BinaryTreeExample(rightName);
    }
}
