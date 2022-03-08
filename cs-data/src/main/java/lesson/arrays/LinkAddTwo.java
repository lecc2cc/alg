package lesson.arrays;

public class LinkAddTwo {

    /**
     * 两个数字书写逆序的链表相加，返回逆序的结果
     * <p>
     * 例如： 123 + 234
     * 表示为：
     * <pre>
     *     l1 = 3 -> 2 -> 1
     *     l2 = 4 -> 3 -> 2
     *     结果：7 -> 5 -> 3
     * </pre>
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode protect = new ListNode(-1, null);
        ListNode last = protect;

        // 进位
        int bitCarry = 0;
        ListNode n = null;
        while (l1 != null || l2 != null) {
            int v = 0;

            if (l2 == null || l1 != null) {
                v = l1.val + bitCarry;
                if (l2 != null) {
                    v += l2.val;

                    l2 = l2.next;
                }
                l1 = l1.next;
            } else {
                v = l2.val + bitCarry;

                l2 = l2.next;
            }
            // 是否进位
            if (v >= 10) {
                n = new ListNode(v - 10, null);
                bitCarry = 1;
            } else {
                n = new ListNode(v, null);
                bitCarry = 0;

            }


            last.next = n;
            last = n;
        }

        if (bitCarry > 0) {
            n = new ListNode(bitCarry, null);

            last.next = n;
            last = n;

        }

        return protect.next;
    }
}
