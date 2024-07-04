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
    public ListNode mergeNodes(ListNode head) {
        ListNode trav=head.next;
        ListNode root;
        int sum=0;
        while(trav!=null && trav.val!=0){
            sum+=trav.val;
            trav=trav.next;
        }
        root=new ListNode(sum);
        ListNode temp=root;
        sum=0;
        trav=trav.next;
        while(trav!=null){
            if(trav.val==0){
                temp.next=new ListNode(sum);
                temp=temp.next;
                sum=0;
            }else{
                sum+=trav.val;
            }
            trav=trav.next;
        }
        return root;
    }
}