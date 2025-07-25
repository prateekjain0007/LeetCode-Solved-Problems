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
    public ListNode deleteDuplicates(ListNode head) {
        // Dummy node before the head (to handle head deletion easily)
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {
            // Check if it's a duplicate sequence
            if (current.next != null && current.val == current.next.val) {
                int dupVal = current.val;

                // Skip all nodes with this duplicate value
                while (current != null && current.val == dupVal) {
                    current = current.next;
                }

                // Link prev to the next unique node
                prev.next = current;
            } else {
                // Move both pointers forward if no duplicate
                prev = current;
                current = current.next;
            }
        }

        return dummy.next;
    }
}

