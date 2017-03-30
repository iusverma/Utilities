package daily.practice.impl.tree;

public class BinaryTreeNode {
    private int value;
    private BinaryTreeNode leftChild = null;
    private BinaryTreeNode rightChild = null;
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }
    public void setLeftChild(BinaryTreeNode leftChild) {
        this.leftChild = leftChild;
    }
    public BinaryTreeNode getRightChild() {
        return rightChild;
    }
    public void setRightChild(BinaryTreeNode rightChild) {
        this.rightChild = rightChild;
    }
    public boolean hasLeftChild(){
        if(leftChild!=null){
            return true;
        }
        return false;
    }
    public boolean hasRightChild(){
        if(rightChild!=null){
            return true;
        }
        return false;
    }
    public BinaryTreeNode addChildNode(int value){
        BinaryTreeNode childNode = new BinaryTreeNode();
        childNode.setValue(value);
        placeNode(this,childNode);
        return childNode;
    }
    private void placeNode(BinaryTreeNode current, BinaryTreeNode childNode){
        if(current.getValue() > childNode.getValue()){
            if(current.hasLeftChild()){
                placeNode(current.getLeftChild(),childNode);
            } else{
                current.setLeftChild(childNode);
            }
        }else{
            if(current.hasRightChild()){
                placeNode(current.getRightChild(),childNode);
            } else{
                current.setRightChild(childNode);
            }
        }
    }
}
