package stack;

import java.util.ArrayDeque;

public class VlidParentheses {


    public static void main(String[] args) {

        System.out.println(new VlidParentheses().isValid("()"));
    }

    public boolean isValid(String s) {
        ArrayDeque<Character> stack=new ArrayDeque<>();
        if(s==null || s.length()==0) return true;

        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(c=='(' || c=='[' || c=='{'){
                stack.push(c);
            }else if(c==')' || c==']' || c=='}'){
                if(stack.isEmpty()) return false;
                char left=stack.poll();
                if(left=='(' && c!=')') return false;
                if(left=='[' && c!=']') return false;
                if(left=='{' && c!='}') return false;
            }
        }
        return stack.isEmpty();
    }
}
