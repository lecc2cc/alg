package lesson.arrays;

import utils.Fmt;

public class Test {
    public static void main(String[] args) {
        // test_RemoveDuplicate();

        // test_MoveZero();

        // test_MergeSorted();

        // test_PlusOne();

        // test_ArrList();

        test_ReverseGroup();
    }

    private static void test_ReverseGroup() {
        ListNode protect = new ListNode(0);
        for (int i = 10; i > 0; i--) {
            ListNode n = new ListNode(i);
            n.next = protect.next;
            protect.next = n;
        }

        ListNode p = protect.next;
        while(p != null) {
            System.out.print(p + " -> ");
            p = p.next;
        }
        System.out.println("\n");

        ReverseGroup ins = new ReverseGroup();
        p = ins.reverseKGroup(protect.next, 2);

        while(p != null) {
            System.out.print(p + " -> ");
            p = p.next;
        }
        System.out.println("\n");

    }

    private static void test_ArrList() {
        ArrList ins = new ArrList(10);
        Fmt.println(ins);
        for (int i=0; i< 12; i++) {
            ins.append(i+100);
        }

        Fmt.println(ins);

    }


    private static void test_PlusOne() {
        int[] nums = new int[]{9,9,9};

        PlusOne ins = new PlusOne();
        Fmt.println(nums);
        Fmt.println(ins.plusOne(nums));
    }

    private static void test_MergeSorted() {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};

        MergeSorted ins = new MergeSorted();
        Fmt.println(nums1);
        Fmt.println(nums2);

        ins.merge(nums1, 3, nums2, 3);
        Fmt.println(nums1);

    }

    private static void test_MoveZero() {
        MoveZero ins = new MoveZero();

        int[] nums = new int[]{0, 0, 1, 1, 1, 0, 2, 3, 3, 0};

        Fmt.println(nums);
        ins.moveZeroes(nums);

        Fmt.println(nums);
    }

    private static void test_RemoveDuplicate() {
        RemoveDuplicate ins = new RemoveDuplicate();


        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        Fmt.println(nums);
        int k = ins.removeDuplicates(nums);
        Fmt.println(k);
        Fmt.println(nums);
    }
}
