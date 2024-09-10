class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode prev=head;
        ListNode root=head.next;
        while(root!=null){
            int val=gcd(prev.val,root.val);
            ListNode node=new ListNode(val);
            node.next=root;
            prev.next=node;
            prev=root;
            root=root.next;
        }
        return head;
    }

    public int gcd(int m,int n){
        int p=(m>n)? m:n;
        int q=(m<n)? m:n;
        while(p%q!=0){
            int r=p%q;
            p=q;
            q=r;   
        }
        return q;
    }
}