class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        if(head.next!=null && head.val==head.next.val){
            ListNode temp=head.next;
            while(temp!=null && temp.val==head.val){
                temp=temp.next;
            }
            if(temp==null) return null;
            head=temp;
            head=deleteDuplicates(head);
            return head;
        }        
        head.next=deleteDuplicates(head.next);
        return head;
    }
}