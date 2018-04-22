package linkedList;/*
 *   Created by coder-pig@outlook.com on 2017/4/6.
 */

import _entity.ListNode;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {


        if(head==null) return null;

        ListNode dummyNode=new ListNode(0);
        ListNode node=dummyNode;
        while (head!=null && head.next!=null){
            node.next=head.next;
            ListNode newHead=head.next.next;
            head.next.next=head;
            head.next=newHead;
            head=newHead;
            node=node.next.next;
        }
        if(head!=null){
            node.next=head;
        }
        return dummyNode.next;

    }
}
