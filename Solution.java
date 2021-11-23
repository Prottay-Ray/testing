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
        int a = 0, b = 0;
        a = (l1.val + l2.val) % 10;
        b = (l1.val + l2.val) / 10;
        ListNode l = new ListNode(a), head = l;
        l = l.next;
        while(l1.next != null && l2.next != null) {
            l = new ListNode((l1.val + l2.val + b) % 10);
            b = (l1.val + l2.val + b) / 10;       
            l = l.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1.next != null) {
            l = new ListNode((l1.val + b) % 10);
            b = (l1.val + b) / 10;       
            l = l.next;     
            l1 = l1.next;
        }
        while(l2.next != null) {
            l = new ListNode((l2.val + b) % 10);
            b = (l2.val + b) / 10;       
            l = l.next;     
            l2 = l2.next;
        }
        l = null;
        return head;
    }
}