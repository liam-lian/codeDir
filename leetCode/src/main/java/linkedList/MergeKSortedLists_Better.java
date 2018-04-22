package linkedList;/*
 *   Created by coder-pig@outlook.com on 2017/4/6.
 */

import _entity.ListNode;

public class MergeKSortedLists_Better {

    public ListNode mergeKLists(ListNode[] lists) {
        return Merge(lists,0,lists.length-1);
    }

    private ListNode Merge(ListNode[] lists, int low, int high) {
        if(low==high){
            return lists[low];
        }
        if(low+1==high){
            return mergeTwoLists(lists[low],lists[high]);
        }
        int mid=(high-low)/2+low;
        ListNode left=Merge(lists,low,mid);
        ListNode right=Merge(lists,mid+1,high);
        return mergeTwoLists(left,right);
    }


    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummyNode = new ListNode(0);
        ListNode node = dummyNode;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                node = node.next;
                l1 = l1.next;
            } else {
                node.next = l2;
                node = node.next;
                l2 = l2.next;
            }
        }

        if (l1 != null) node.next = l1;
        if (l2 != null) node.next = l2;

        return dummyNode.next;
    }
}
