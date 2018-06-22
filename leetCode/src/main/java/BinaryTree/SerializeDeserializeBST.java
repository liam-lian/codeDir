package BinaryTree;

/*
 *   Created by zhuang.lian@qunar.com on 2017/6/19.
 */

import _entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBST {

    /*
     * ArrayDeque的一个重要的问题就是，不能够添加null元素
     * LinkedList则是可以添加null元素
     * */
    public String serialize(TreeNode root) {


        StringBuilder res = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                res.append("N#");
            } else {
                res.append(node.val);
                res.append('#');
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        TreeNode root;
        String split[] = data.split("#");
        root = newNode(split[0]);
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; i < split.length; i += 2) {
            TreeNode node = queue.poll();
            node.left = newNode(split[i]);
            node.right = newNode(split[i + 1]);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return root;
    }

    private TreeNode newNode(String val) {
        if (val.equals("N")) {
            return null;
        }
        return new TreeNode(Integer.valueOf(val));
    }
}
