package linkedList;/*
 *   Created by coder-pig@outlook.com on 2017/4/6.
 */

import _entity.ListNode;

public class RemoveNthNode {

    public static void main(String[] args) {
        int n=4;
        System.out.println((n-1)^(n-1));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode slow=head,fast=head;
        for (int i = 0; fast!=null && i < n; i++) {
            fast=fast.next;
        }
        //說明刪除的是第一個元素
        if(fast==null) return head.next;

        while (fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }

        slow.next=slow.next.next;
        return head;
    }
}
