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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||k==0)return head;
        ListNode temp=head;
        while(temp!=null&&k>0){
            temp=temp.next;
            if(temp==null)temp=head;
            k--;
        }
        ListNode temp2= head;
        ListNode tail=temp;
        while(temp!=null&&temp.next!=null){
            // tail=temp;
            temp=temp.next;
            temp2=temp2.next;
        }
        ListNode ret=temp2.next;
        temp2.next=null;
        temp.next=head;
        return ret;

    }
}