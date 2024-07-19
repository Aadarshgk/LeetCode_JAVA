import java.util.Stack;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> a= new Stack<>();
        while(l1!=null){
            a.push(l1.val);
            l1=l1.next;
        }

        Stack<Integer> b= new Stack<>();
        while(l2!=null){
            b.push(l2.val);
            l2=l2.next;
        }
        
        ListNode temp1=null;
        int carry=0;
        while(!a.isEmpty() || !b.isEmpty() || carry!=0){
            int sum=0;
            if(!a.isEmpty()) sum+=a.pop();
            if(!b.isEmpty()) sum+=b.pop();
            sum+=carry;
            ListNode temp2=new ListNode(sum%10,temp1);
            temp1=temp2;
            carry=sum/10;
        }
        return temp1;
    }
}

