package linkedList;
/*
 *   Created by zview@qq.com on 18-4-13.
 */

import _entity.ListNode;


public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0), node = dummyNode;

        while (l1 != null && l2 != null) {
            node.next = new ListNode(l1.val + l2.val);
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            node.next = l1;
        } else {
            node.next = l2;
        }

        node = dummyNode;
        int add = 0;
        while (node.next != null) {
            if (node.next.val + add > 9) {
                node.next.val = (node.next.val + add) / 10;
                add = 1;
                node = node.next;
            } else {
                add = 0;
                break;
            }
        }
        if (add == 1) {
            node.next = new ListNode(1);
        }
        return dummyNode.next;
    }
}
