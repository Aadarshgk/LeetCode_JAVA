class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;

        head.next.next=swapPairs(head.next.next);
        ListNode temp= head.next;
        head.next= head.next.next;
        temp.next=head;
        head=temp;
        return head;
    }
}