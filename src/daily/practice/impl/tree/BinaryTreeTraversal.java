package daily.practice.impl.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTraversal {
    public static void traverseInorder(BinaryTreeNode current){
        if(current!=null){
            traverseInorder(current.getLeftChild());
            System.out.print(current.getValue() + ", ");
            traverseInorder(current.getRightChild());
        }
    }
    public static void traversePreorder(BinaryTreeNode current){
        if(current!=null){
            System.out.print(current.getValue() + ", ");
            traversePreorder(current.getLeftChild());
            traversePreorder(current.getRightChild());
        }
    }
    public static void traversePostorder(BinaryTreeNode current){
        if(current!=null){
            traversePostorder(current.getLeftChild());
            traversePostorder(current.getRightChild());
            System.out.print(current.getValue() + ", ");
        }
    }
    public static void printAllPath(BinaryTreeNode t){
        List<Integer> pathElements = new ArrayList<>();
        printAllPath(t, pathElements);
    }
    private static void printAllPath(BinaryTreeNode t, List<Integer> pathElements){
        List<Integer> tempPathElements = new ArrayList<>(pathElements);
        if(t!=null){
            tempPathElements.add(new Integer(t.getValue()));
            if(!t.hasLeftChild() && !t.hasRightChild()){
                System.out.println();
                for(int i=0;i<tempPathElements.size();i++){
                    System.out.print(tempPathElements.get(i)+", ");
                }
            }
            printAllPath(t.getLeftChild(), tempPathElements);
            printAllPath(t.getRightChild(), tempPathElements);            
        }
    }
    public static void getMaxDistinctNumberInAPath(BinaryTreeNode t){
        List<Integer> pathElements = new ArrayList<>();
        int count = 1;
        getMaxDistinctNumberInAPath(t, pathElements, count);
    }
    private static void getMaxDistinctNumberInAPath(BinaryTreeNode t, List<Integer> pathElements, int count){
        List<Integer> tempPathElements = new ArrayList<>(pathElements);
        int tempCount = count;
        if(t!=null){
            if(!tempPathElements.contains(t.getValue())){
                tempPathElements.add(new Integer(t.getValue()));
                tempCount++;
            }
            if(!t.hasLeftChild() && !t.hasRightChild()){
                System.out.println();
                for(int i=0;i<tempPathElements.size();i++){
                    System.out.print(tempPathElements.get(i)+", ");
                }
                System.out.println("==>>"+count);
            }
            getMaxDistinctNumberInAPath(t.getLeftChild(), tempPathElements, tempCount );
            getMaxDistinctNumberInAPath(t.getRightChild(), tempPathElements, tempCount );
        }
    }
}