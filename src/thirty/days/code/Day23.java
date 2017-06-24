package thirty.days.code;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
    Node left, right;
    int data;
    Node(int data){
        this.data = data;
        left=right=null;
    }
}
public class Day23 {
    static void levelOrder(Node root){
        Queue<Node> queue = new LinkedList<>();
        if(root!=null){
          System.out.print(root.data + " ");
          queue.add(root.left);
          queue.add(root.right);
        }
        while(!queue.isEmpty()){
            Node temp = queue.remove();
            if(temp != null){
                System.out.print(temp.data + " ");
                queue.add(temp.left);
                queue.add(temp.right);
            }               
        }
    }

    public static Node insert(Node root, int data){
        if(root == null){
            return new Node(data);
        }else{
            Node cur;
            if(data <= root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        Node root = null;
        while(T-->0){
            int data = s.nextInt();
            root = insert(root,data);
        }
        levelOrder(root);
    }
}
