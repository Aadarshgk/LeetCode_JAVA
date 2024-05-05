class Solution {
    public ListNode reverseList(ListNode head,int n){
        int count=0;
        ListNode prev=null;
        ListNode curr=head;
        ListNode next=curr.next;
        while(count<n){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count++;
        }
        head.next=next;
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode prev=null;
        int count=0;
        while(count<k && temp!=null){
            count++;
            prev=temp;
            temp=temp.next;
        }

        if(count==k){
            prev.next=reverseKGroup(temp,k);
            head=reverseList(head,k);
        }
        
        return head;
    }
}