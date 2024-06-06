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
    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode root=head;
        ListNode tail=head;
        ListNode temp=head;
        ListNode temp2;
        while(tail.next!=null){
            if(tail.next.val<=root.val){
                temp=tail.next;
                tail.next=tail.next.next;
                temp.next=root;
                root=temp;
            }else if(tail.next.val>tail.val){
                tail=tail.next;
            }else{
                temp=root;
                while(temp.next.val<tail.next.val){
                    temp=temp.next;
                }
                temp2=tail.next;
                tail.next=temp2.next;
                temp2.next=temp.next;
                temp.next=temp2;
            }
        }
        return root;
    }
}