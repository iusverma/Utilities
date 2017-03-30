package daily.practice.test.tree;

import daily.practice.impl.tree.BinaryTreeNode;
import daily.practice.impl.tree.BinaryTreeTraversal;

public class TreeCreationTest {
    public static void main(String args[]){
        int array[] = {25,10,5,99,56,3,4,101,6,33};
        BinaryTreeNode root = null;
        BinaryTreeNode current = null;
        for(int i=0;i<array.length;i++){
            if(root==null){
                BinaryTreeNode temp = new BinaryTreeNode();
                temp.setValue(array[i]);
                root = temp;
                current = temp;
            }else{
                current.addChildNode(array[i]);
            }
        }
        System.out.println("Binary tree created");
        System.out.println("Traversing Inorder");
        BinaryTreeTraversal.traverseInorder(root);
        System.out.println("\nTraversing Preorder");
        BinaryTreeTraversal.traversePreorder(root);
        System.out.println("\nTraversing Postorder");
        BinaryTreeTraversal.traversePostorder(root);
        System.out.println("\n\nPrinting All Paths");      
        BinaryTreeTraversal.printAllPath(root);
        System.out.println("\n\nGet max distinct number in a Path");      
        BinaryTreeTraversal.getMaxDistinctNumberInAPath(root);
    }
}
