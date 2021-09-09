package com.iarina.merge_k_sorted_lists;

public class MergeMain {

    public static void main(String[] args) {
        ListNode[] lists = initializeData();
        ListNode mergeNode = ListNode.mergeKLists(lists);

        while (mergeNode != null) {
            System.out.print(mergeNode.val + " ");
            mergeNode = mergeNode.next;
        }
    }


    public static ListNode[] initializeData() {
        ListNode listNode1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode3 = new ListNode(2, new ListNode(6));
        ListNode[] lists = new ListNode[4];
        lists[0] = listNode1;
        lists[1] = listNode2;
        lists[2] = listNode3;
        return lists;
    }
}


