package lesson.arrays;

public class LinkAddNumber {
    /**
     * 两个数字按书写顺序的组成的链表相加，返回顺序顺序的结果
     *
     * 例如： 123 + 234 = 357
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 翻转，处理进位情况
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode protect = new ListNode(-1, null);
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


            n.next = protect.next;
            protect.next = n;

        }

        if (bitCarry > 0) {
            n = new ListNode(bitCarry, null);

            n.next = protect.next;
            protect.next = n;
        }

        return protect.next;
    }

    /**
     * 翻转
     */
    private ListNode reverse(ListNode p) {
        ListNode last = null;
        while (p != null) {
            ListNode t = p.next;

            p.next = last;
            last = p;

            p = t;
        }

        return last;
    }
}
