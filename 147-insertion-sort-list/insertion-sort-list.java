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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0); // dummy node before the sorted part
        ListNode curr = head;

        while (curr != null) {
            ListNode prev = dummy;

            // Find where to insert the current node
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            // Save next node and insert current between prev and prev.next
            ListNode next = curr.next;
            curr.next = prev.next;
            prev.next = curr;

            curr = next;
        }

        return dummy.next;
    }
}
