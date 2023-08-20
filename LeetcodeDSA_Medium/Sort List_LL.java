/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {

        if(head==null || head.next==null) return head;
        ListNode slow=head;
        ListNode fast=head;
        ListNode temp=null;
        while(fast!=null && fast.next!=null)
        {
            temp=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        temp.next=null;
        ListNode list1=sortList(head);
        ListNode list2=sortList(slow);
        return mergelist(list1,list2);
    }

    ListNode mergelist(ListNode list1, ListNode list2)
    {

        ListNode headT=null, temp=null;
        while(list1!=null && list2!=null)
        {
            if(headT==null && temp==null)
            {
                if(list1.val<list2.val)
                {
                    headT=list1;
                    temp=list1;
                    list1=list1.next;
                }
                else {
                    headT=list2;
                    temp=list2;
                    list2=list2.next;
                }
                
            }

            if(list1!=null && list2!=null)
            {
                if(list1.val<list2.val)
                {
                    temp.next=list1;
                    temp=temp.next;
                    list1=list1.next;
                }
                else
                {
                    temp.next=list2;
                    temp=temp.next;
                    list2=list2.next;
                }
            }
        }
            while(list1!=null)
            {
                temp.next=list1;
                temp=temp.next;
                list1=list1.next;
            }
            while(list2!=null)
            {
                temp.next=list2;
                temp=temp.next;
                list2=list2.next;
            }
            
        return headT;

    }
}
