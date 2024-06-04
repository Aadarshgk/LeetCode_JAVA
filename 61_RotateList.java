class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return null;
        ListNode temp=head;
        ListNode prev;
        int count=1;
        while(temp.next!=null){
            temp=temp.next;
            count++;
        }
        k=k%count;
        while(k>0){
            temp=head;
            prev=null;
            while(temp.next!=null){
                prev=temp;
                temp=temp.next;
            }
            temp.next=head;
            head=temp;
            prev.next=null;
            k--;                      
        }
        return head;
    }
}