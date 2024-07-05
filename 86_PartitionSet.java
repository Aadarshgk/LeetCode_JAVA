class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next==null) return head;
        ListNode tail=head;
        while(tail.next!=null){
            tail=tail.next;
        }
        head= partition(head,tail,tail,x);
        return head;
    }

    public ListNode partition(ListNode head, ListNode tail,ListNode end, int x){
        if(head==tail){
            if(tail==end){
                return tail;
            }
            if(head.val<x){
                return head;
            }else{
                ListNode temp= head.next;
                end.next=head;
                head.next= null;
                return temp;
            }
        }
        
        if(head.val<x){
            head.next=partition(head.next,tail,end,x);
            return head;
        }else{
            ListNode temp=head.next;
            end.next=head;
            head.next=null;
            end=end.next;
            return partition(temp,tail,end,x);
        }
    }
}