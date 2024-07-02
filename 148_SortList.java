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
        ListNode slow= head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        fast=slow.next;
        slow.next=null;
        slow=head;
        slow=sortList(slow);
        fast=sortList(fast);
        return mergeList(slow,fast);

    }

    public ListNode mergeList(ListNode temp1, ListNode temp2){
        if(temp1==null && temp2==null) return null;
        if(temp1==null) return temp2;
        if(temp2==null) return temp1;
        ListNode head= new ListNode();
        ListNode temp=head;
        while(temp1!=null && temp2!=null){
            if(temp1.val<temp2.val){
                temp.next=temp1;
                temp1=temp1.next;
            }else{
                temp.next=temp2;
                temp2=temp2.next;
            }
            temp=temp.next;
        }
        if(temp1!=null){
            temp.next=temp1;
        }
        if(temp2!=null){
            temp.next=temp2;
        }
        return head.next;
    }
}