class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        ListNode temp = head;

        while (temp != null) {

            int count = 0;
            ListNode check = head;

            while (check != null) {
                if (check.val == temp.val) {
                    count++;
                }
                check = check.next;
            }

            if (count == 1) {
                tail.next = new ListNode(temp.val);
                tail = tail.next;
            }

            temp = temp.next;
        }

        return dummy.next;
    }
}