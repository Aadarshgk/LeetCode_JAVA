class Solution {
    public ListNode reverseList(ListNode head,int n){
        int count=0;
        ListNode prev=null;
        ListNode curr=head;
        ListNode next;

        while(count<n){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count++;
            
        }
        head.next=curr;
        return prev;

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null || left==right) return head;

        if(left==1){
            head= reverseList(head, right-left+1);
        }else{
            int i=1;
            ListNode temp=head;
            while(i<left-1){
                i++;
                temp=temp.next;
            }
            temp.next=reverseList(temp.next,right-left+1);
        }        
        return head;
    }
}