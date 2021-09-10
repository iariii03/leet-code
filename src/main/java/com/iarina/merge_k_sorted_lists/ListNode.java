package com.iarina.merge_k_sorted_lists;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> sortedQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        for (ListNode node : lists) {
            if (node != null) {
                sortedQueue.add(node);
            }
        }
        ListNode start = new ListNode(0);
        ListNode current = start;

        while (!sortedQueue.isEmpty()) {
            ListNode nextNode = sortedQueue.remove();
            current.next = nextNode;
            current = current.next;

            if (nextNode.next != null) {
                sortedQueue.add(nextNode.next);
            }

        }
        return start.next;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append(this.val);
        if (this.next != null)
            s.append(" ").append(this.next);

        return s.toString();
    }

}
