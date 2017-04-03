package daily.practice.impl.list;

public class ListNode<T> {
    T value;
    ListNode<T> next;

    public ListNode(T val){
        value = val;
        next = null;
    }

    public int addNode(T val){
        ListNode<T> temp = this;
        int index = 1;
        ListNode<T> newNode = new ListNode<>(val);
        while(temp.next!=null){
            temp = temp.next;
            index++;
        }
        
        temp.next = newNode;
        return index;
    }

    public T getValue(){
        return value;
    }
    
    public ListNode<T> getNext(){
        return this.next;
    }
}
