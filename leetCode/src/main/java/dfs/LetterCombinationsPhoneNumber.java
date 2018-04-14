package main.java.dfs;/*
 *   Created by coder-pig@outlook.com on 2017/4/6.
 */

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhoneNumber {


    private List<String> res=new ArrayList<>();

    public List<String> letterCombinations(String digits) {

       char[][] letterMapping={
               {'a','b','c'},
               {'d','e','f'},
               {'g','h','i'},
               {'j','k','l'},
               {'m','n','o'},
               {'p','q','r','s'},
               {'t','u','v'},
               {'w','x','y','z'}
       };

        for (int i = 0; i < digits.length(); i++) {
            if (digits.charAt(i)<'2' || digits.charAt(i)>'9'){
                return new ArrayList<>();
            }
        }

        StringBuilder sb=new StringBuilder();

        dfs(digits,0,sb,letterMapping);
        return res;
    }

    private void  dfs(String digits,int index,StringBuilder sb,char[][] letterMapping){
        if(index==digits.length()){
            res.add(sb.toString());
            return;
        }
        for(char c:letterMapping[digits.charAt(index)-'2']){
            sb.append(c);
            dfs(digits,index+1,sb,letterMapping);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
