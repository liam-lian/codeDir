package dfs;/*
 *   Created by coder-pig@outlook.com on 2017/4/6.
 */

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {


    private boolean[][] isPalindrome;
    private List<List<String>> lists=new ArrayList<>();

    public List<List<String>> partition(String s) {

        //通过递归，使用动态规划，判断s的每一个子串都是否是回文的
        isPalindrome=new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length()-1; i++) {
            isPalindrome[i][i]=true;
            isPalindrome[i][i+1]=s.charAt(i)==s.charAt(i+1);
        }
        isPalindrome[s.length()-1][s.length()-1]=true;

        //这里一定要注意计算的顺序
        for (int i = s.length()-3; i >=0 ; i--) {
            for (int j = i+2; j < s.length(); j++) {
                isPalindrome[i][j]=isPalindrome[i+1][j-1] && s.charAt(i)==s.charAt(j);
            }
        }

        List<String> partion=new ArrayList<>();
        dfs(s,0,partion);
        return lists;
    }

    private void  dfs(String s,int index,List<String> curpartion){

        if(index==s.length()){
            lists.add(new ArrayList<>(curpartion));
        }
        for (int i = index+1; i <= s.length(); i++) {
            if(isPalindrome[index][i-1]){
                curpartion.add(s.substring(index,i));
                dfs(s,i,curpartion);
                curpartion.remove(curpartion.size()-1);
            }
        }

    }


}
