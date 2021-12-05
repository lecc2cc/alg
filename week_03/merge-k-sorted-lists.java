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
    public ListNode mergeKLists(ListNode[] lists) {
        return divide(lists, 0, lists.length-1);
    }
    
    private ListNode divide(ListNode[] lists, int left, int right) {
        int m = (left + right) / 2;
        if (lists.length == 0) {
            return null;
        }
        if (left == right) {
            return lists[left];
        }
        ListNode l = divide(lists, left, m);
        ListNode r = divide(lists, m+1, right);

        return merge(l, r);
    }
    
     private ListNode merge(ListNode l1, ListNode l2) {
        ListNode h = new ListNode();
        ListNode p = new ListNode();
        h.next = p;
        
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
                p = p.next;
                
            } else {
                p.next = l2;
                l2 = l2.next;
                p = p.next;
            }
        }
        
        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        
        
        
        return h.next.next;
    }
}
