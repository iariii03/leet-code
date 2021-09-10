package com.iarina.merge_k_sorted_lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListNodeTest {

    ListNode [] lists_1;
    ListNode [] lists_2;


    @BeforeEach
    private void init() {
        ListNode listNode1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode3 = new ListNode(2, new ListNode(6));
        lists_1 = new ListNode[3];

        lists_1[0] = listNode1;
        lists_1[1] = listNode2;
        lists_1[2] = listNode3;

        lists_2 = new ListNode[1];
        lists_2[0]= listNode1;
    }

    @Test
    void merge_k_lists() {
        ListNode mergeKlists = ListNode.mergeKLists(lists_1);
        Assertions.assertEquals("1 1 2 3 4 4 5 6", mergeKlists.toString());
    }

    @Test
    void merge_1_list(){
        ListNode mergeKlists = ListNode.mergeKLists(lists_2);
        Assertions.assertEquals("1 4 5", mergeKlists.toString());
    }

    @Test
    void merge_null_or_empty_list(){
        Assertions.assertNull(ListNode.mergeKLists(null));
        Assertions.assertNull(ListNode.mergeKLists(new ListNode[1]));
    }

}