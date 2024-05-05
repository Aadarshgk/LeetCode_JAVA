/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0,sum=0,num1,num2;
        ListNode l3= new ListNode(0);
        ListNode temp=l3;
        while(l1!=null || l2!=null){
            sum=num1=num2=0;
            if(l1!=null){
                num1=l1.val;
                l1=l1.next;
            }

            if(l2!=null){
                num2=l2.val;
                l2=l2.next;
            }

            sum=num1+num2+carry;
            temp.next= new ListNode(sum%10);
            carry=sum/10;
            temp=temp.next;
        }
        if(carry>0){
            temp.next=new ListNode(carry);
        }
        return l3.next;
    }
}