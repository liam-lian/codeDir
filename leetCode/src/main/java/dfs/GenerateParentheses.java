package main.java.dfs;
/*
 *   Created by coder-pig@outlook.com on 2017/4/6.
 */

import java.util.ArrayList;
import java.util.List;


/*
* 思考：
* dfs当中的StringBuilder参数是需要特别注意的
* 在进行子函数调用之后，在子函数中对于其进行的修改应该在返回父函数之前完全清除掉。
* 例如当前状态是`(`,下面第一个阶段是搜索'((',第二个阶段是搜索`()`,
* 事实上在对于第一个阶段进行搜索的过程中,一定会这个StringBuilder进行修改,那么就需要在第一阶段完全计算完成之后,确保其中的值变化回来到`(`
* 这样才能确保后面的`()`这个阶段的正确执行.
* */


public class GenerateParentheses {

    public static void main(String[] args) {
        List<String> res=new GenerateParentheses().generateParenthesis(3);


        for(String s:res){
            System.out.println(s);
        }
    }

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        dfs(0,0,sb,n);
        return res;

    }
    private void dfs(int leftNum, int rightNum, StringBuilder sb, int n) {

        if (leftNum == n && rightNum == n) {
            res.add(sb.toString());
            return;
        }

        if (leftNum == n) {
            for (int i = rightNum; i < n; i++) {
                sb.append(')');
            }
            res.add(sb.toString());
            sb.delete(leftNum+rightNum,2*n);
            return;
        }

        sb.append('(');
        dfs(leftNum + 1, rightNum, sb, n);
        sb.deleteCharAt(sb.length() - 1);
        if (leftNum > rightNum) {
            sb.append(')');
            dfs(leftNum, rightNum + 1, sb, n);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

}
