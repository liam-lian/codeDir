package main.java.dfs;/*
 *   Created by coder-pig@outlook.com on 2017/4/6.
 */

import java.util.*;

public class PyramidTransitionMatrix {

    public static void main(String[] args) {
        String s[]=new String[]{"ABD","BCE","DEF","FFF"};
        System.out.println(new PyramidTransitionMatrix().pyramidTransition("ABC",Arrays.asList(s)));

    }

    private Map<String, List<Character>> allowMap;

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        allowMap = new HashMap<>();
        for (String s : allowed) {

            List<Character> val = allowMap.putIfAbsent(s.substring(0, 2),new ArrayList<>(Collections.singletonList(s.charAt(2))));
            if (val!=null) {
                val.add(s.charAt(2));
            }
        }
        return dfs(new StringBuilder(bottom),0,new StringBuilder());
    }

    private boolean dfs(StringBuilder string, int index, StringBuilder nextLevel) {

        if(string.length()==1) return true;
        if(index==string.length()-1){
            return dfs(nextLevel,0,new StringBuilder());
        }
        List<Character> nextchars = allowMap.get(string.substring(index,index+2));
        if (nextchars == null) return false;
        for (Character c : nextchars) {
            nextLevel.append(c);
            boolean curRes = dfs(string, index + 1, nextLevel);
            nextLevel.deleteCharAt(nextLevel.length() - 1);

            if (curRes) {
                return true;
            }
        }
        return false;
    }
}
