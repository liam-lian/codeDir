package BinaryTree;

/*
 *   Created by zhuang.lian@qunar.com on 18-6-19.
 */


import _entity.TreeNode;

public class Flatten {
    /*
    * 将二叉树转化为链表
    * 所谓链表就是将每一个点的左节点清空，右节点作为next指针
    * */

    public void flatten(TreeNode root) {
        flat(root);
    }

    private TreeNode flat(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode lroot = flat(node.left);
        TreeNode rroot = flat(node.right);

        node.left = null;  //特别注意讲left节点要清空掉
        if (lroot != null) {
            node.right = lroot;
            while (lroot.right != null) {
                lroot = lroot.right;
            }
            lroot.right = rroot;
        } else {
            node.right = rroot;
        }
        return node;
    }
}
