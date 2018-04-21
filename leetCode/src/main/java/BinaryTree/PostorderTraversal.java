package BinaryTree;

import _entity.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

/*
 *   Created by zview@qq.com on 2018/4/18.
 */
public class PostorderTraversal {



    /*
    * 后续遍历是   左->右->根
    * 比较难以处理，不妨倒过来进行遍历，变成   根->右->左、
    * 这就跟前序遍历很像了，只需要在前序遍历的时候首先访问右节点，然后将左节点压栈就可以了
    * */

    public List<Integer> postorderTraversal(TreeNode root) {


        LinkedList<Integer> res = new LinkedList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode t = root;

        while (!stack.isEmpty() || t != null) {

            while (t != null) {
                res.addFirst(t.val);
                if (t.left != null)
                    stack.push(t.left);
                t = t.right;
            }
            if (!stack.isEmpty()) {
                t = stack.pop();
            }
        }
        return res;


    }
}
