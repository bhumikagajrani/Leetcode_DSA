/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
       Node temp=head;
       while(temp!=null)
       {
           Node node = new Node(temp.val);
           node.next=temp.next;
           temp.next=node;
           temp=temp.next.next;
       }
       temp=head;
       while(temp!=null)
       {
           if(temp.random!=null)
           {
               temp.next.random=temp.random.next;
           }
           temp=temp.next.next;
       }
       Node dummy=new Node(0);
       Node itr=head;
       temp=dummy;
       Node fast;
       while(itr!=null)
       {
           fast=itr.next.next;
           temp.next=itr.next;
           itr.next=fast;
           temp=temp.next;
           itr=fast;
       }
       return dummy.next;
    }
}
