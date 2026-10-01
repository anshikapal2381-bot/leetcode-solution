class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ptr = head;
        ListNode temp = head;
        for (int i = 0; i < n; i++) {
            ptr = ptr.next;
        }
        if (ptr == null) {
            return head.next;
        }
        while (ptr.next != null) {
            ptr = ptr.next;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}

