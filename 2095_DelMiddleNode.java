class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head.next==null) return null;
        if(head.next.next==null){
            head.next=null;
            return head;
        }

        ListNode fast=head.next.next;
        ListNode slow=head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        slow.next=slow.next.next;
        return head;
    }
}