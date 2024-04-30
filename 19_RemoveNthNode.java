class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count=0;
        ListNode temp=head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }   
        count= count-n;
        if(count==0){
            head=head.next;
        }else{
            int i=1;
            temp=head;
            while(i<count){
                i++;
                temp=temp.next;
            }
            temp.next=temp.next.next;
        }
        return head;
    }
}