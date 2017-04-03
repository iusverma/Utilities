package daily.practice.test.list;

import daily.practice.impl.list.ListNode;

public class ListTest {
    public static void main(String args[]){
        ListNode<Integer> ln = new ListNode<>(10);
        ln.addNode(23);
        ln.addNode(5);
        ln.addNode(45);
        ln.addNode(31);
        ln.addNode(99);
        
        ListNode<Integer> temp = ln;
        while(temp.getNext()!=null){
            System.out.print(temp.getValue() +", ");
            temp = temp.getNext();
        }
        System.out.println(temp.getValue());
    }
}
