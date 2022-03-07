package lesson.arrays;

public class ReverseGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode protect = new ListNode(0, head);
        ListNode last = protect;


        while (head != null) {
            // 分组中最后一个
            ListNode end = getIndexOf(head, k - 1);
            if (end == null) {
                break;
            }
            // 下一组的起始
            ListNode nextGroup = end.next;

            // 翻转
            reverse(head, nextGroup);

            // 当前分组的最后节点作为最新起始
            last.next = end;
            // 当前节点翻转后，作为下一组起始节点的前继
            head.next = nextGroup;

            // 移到下一组
            last = head;

            // 下一组
            head = nextGroup;
        }

        return protect.next;
    }

    /**
     * 查找第K个节点
     *
     * @param p 起始节点
     * @param k 第k个， 0序号开始
     * @return
     */
    private ListNode getIndexOf(ListNode p, int k) {
        int index = 0;
        while (p != null) {
            if (index == k) {
                break;
            }
            index++;
            p = p.next;
        }

        return p;
    }

    /**
     * 翻转
     *
     * @param p    起始节点
     * @param stop 停止节点
     * @return 头节点
     */
    private ListNode reverse(ListNode p, ListNode stop) {
        ListNode last = new ListNode(0, stop);
        while (p != null) {
            if (p.equals(stop)) {
                break;
            }
            ListNode t = p.next;

            p.next = last.next;
            last.next = p;

            p = t;
        }

        return last.next;
    }
}
