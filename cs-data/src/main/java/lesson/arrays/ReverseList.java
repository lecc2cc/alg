package lesson.arrays;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        return reverse2(head);
    }

    /**
     * 保护节点指向新节点
     *
     * @param head 起始节点
     * @return
     */
    private ListNode reverse1(ListNode head) {
        ListNode last = new ListNode(-10000, null);
        ListNode t = null;
        while (head != null) {
            t = head.next;
            head.next = last.next;
            last.next = head;
            head = t;
        }
        return last.next;
    }

    /**
     * 动态更新最新头节点
     *
     * @param head 起始节点
     * @return
     */
    private ListNode reverse2(ListNode head) {
        ListNode last = null;
        while (head != null) {
            ListNode nextHead = head.next;

            head.next = last;
            last = head;

            head = nextHead;
        }
        return last;
    }


}
