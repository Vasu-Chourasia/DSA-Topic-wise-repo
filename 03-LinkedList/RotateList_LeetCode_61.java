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
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode tail=head;
        int n=1;
        while(tail.next!=null){
            tail=tail.next;
            n++;
        }
        tail.next= head;
        k=k%n;
        int x=n-k-1;
        for(int i=0;i<x;i++){
            head=head.next;
        }
        ListNode newHead=head.next;
        head.next=null;
        return newHead;
    }
}