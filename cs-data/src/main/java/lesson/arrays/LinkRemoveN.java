package lesson.arrays;

public class LinkRemoveN {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = getSize(head);
        ListNode protect = new ListNode(-1, head);
        ListNode last = protect;

        int found = size - n;
        while (last != null) {
            if (found == 0) {
                break;
            }
            found--;
            last = last.next;
        }

        if (last != null && last.next != null) {
            last.next = last.next.next;
        }

        return protect.next;
    }

    private int getSize(ListNode p) {
        int size = 0;
        while (p != null) {
            size++;
            p = p.next;
        }
        return size;
    }
}
