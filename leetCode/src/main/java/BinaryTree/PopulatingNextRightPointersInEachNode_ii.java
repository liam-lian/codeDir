package BinaryTree;
/*
 *   Created by zview@qq.com on 18-4-14.
 */

import _entity.TreeLinkNode;

/*
*        1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
*
* 实际上还是按照层次遍历,但是上一层形成的链表,对于下一层来说就相当于是那个辅助的结构.
* */

public class PopulatingNextRightPointersInEachNode_ii {

    public void connect(TreeLinkNode root) {

        TreeLinkNode head=root;
        TreeLinkNode pre;
        TreeLinkNode node;

        while (head!=null) {
            pre = null;
            node = head;
            head=null;
            while (node != null) {
                if (node.left != null) {
                    if (pre == null) {
                        head = node.left;
                        pre = head;
                    } else {
                        pre.next = node.left;
                        pre = pre.next;
                    }
                }
                if (node.right != null) {
                    if (pre == null) {
                        head = node.right;
                        pre = head;
                    } else {
                        pre.next = node.right;
                        pre = pre.next;
                    }
                }
                node = node.next;
            }
            if(pre!=null )pre.next = null;
        }
    }
}
