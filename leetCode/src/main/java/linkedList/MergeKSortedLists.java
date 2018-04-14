package main.java.linkedList;/*
 *   Created by coder-pig@outlook.com on 2017/4/6.
 */

import _entity.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    class InnerClass implements Comparable<InnerClass>{
        int val;
        int index;

        public InnerClass(int val, int index) {
            this.val = val;
            this.index = index;
        }


        @Override
        public int compareTo(InnerClass o) {
            return this.val-o.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<InnerClass> queue=new PriorityQueue<>();
        ListNode dummyNode=new ListNode(0);
        ListNode node=dummyNode;
        int count=lists.length;

        for (int i = 0; i < lists.length; i++) {
            if(lists[i]!=null){
                queue.add(new InnerClass(lists[i].val,i));
            }else {
                count--;
            }
        }

        while (count>=1){
            InnerClass curMin=queue.poll();
            node.next=lists[curMin.index];
            lists[curMin.index]=lists[curMin.index].next;
            if(lists[curMin.index]!=null){
                queue.add(new InnerClass(lists[curMin.index].val,curMin.index));
            }else {
                count--;
            }
            node=node.next;
        }

        for (int i = 0; i < lists.length; i++) {
            if(lists[i]!=null){
                node.next=lists[i];
                break;
            }
        }

        return dummyNode.next;
    }
}
