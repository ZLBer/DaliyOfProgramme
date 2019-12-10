package leetcode;

import java.util.*;

public class leet301 {

    //minr  DFS+set
    public List<String> removeInvalidParentheses(String s) {
     int []leftAndRight=getMin(s);
        DFS(s,leftAndRight[0], leftAndRight[1],"");
        return new ArrayList<>(set);
    }


    Set<String> set=new HashSet<>();
    void DFS(String s,int leftCount,int rightCount,String pre){
        if(leftCount<0||rightCount<0) return;
       if(leftCount==0&&rightCount==0){
           if(checkValid(pre+s))
             set.add(pre+s);
             return;
       }
       if("".equals(s)) return;

       if(s.charAt(0)=='('){
           DFS(s.substring(1),leftCount-1,rightCount,pre);
       }else if(s.charAt(0)==')'){
           DFS(s.substring(1),leftCount,rightCount-1,pre);
       }
       DFS(s.substring(1),leftCount,rightCount,pre+s.charAt(0));
    }

    int[] getMin(String s) {
        int leftCount = 0;
        int rightCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') leftCount++;
            else if (c == ')') {
                if (leftCount == 0) {
                    rightCount++;
                } else {
                    leftCount--;
                }
            }
        }
        return new int[]{ leftCount,rightCount};
    }

    boolean checkValid(String  s){
     if(s=="") return true;
     int left=0;
     for(char c:s.toCharArray()){
         if(c=='(') left++;
         else if(c==')') {
             left--;
             if(left<0) return false;
         }
     }
     return left==0;
    }





    //DFS  不用知道有多少个不符合条件的括号，实现提前拦截
 /*   public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();

        // sanity check
        if (s == null) return res;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        // initialize
        queue.add(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {
            s = queue.poll();


            //验证是不是回文串
            if (isValid(s)) {
                // found an answer, add to the result
                res.add(s);
                found = true;
            }

            //提前拦截  如果大的串都已经是回文串了，那就不必继续往下走了
            if (found) continue;

            // generate all possible states
            for (int i = 0; i < s.length(); i++) {
                // we only try to remove left or right paren
                if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;


                //把这个位置的符号去掉
                String t = s.substring(0, i) + s.substring(i + 1);

                //去重
                if (!visited.contains(t)) {
                    // for each state, if it's not visited, add it to the queue
                    queue.add(t);
                    visited.add(t);
                }
            }
        }

        return res;
    }

    // helper function checks if string s contains valid parantheses
    boolean isValid(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') count++;
            if (c == ')' && count-- == 0) return false;
        }

        return count == 0;
    }*/


    public List<String> removeInvalidParentheses(String s) {
        List<String> output = new ArrayList<>();
        removeHelper(s, output, 0, 0, '(', ')');
        return output;
    }

    public void removeHelper(String s, List<String> output, int iStart, int jStart, char openParen, char closedParen) {
        int numOpenParen = 0, numClosedParen = 0;
        for (int i = iStart; i < s.length(); i++) {
            if (s.charAt(i) == openParen) numOpenParen++;
            if (s.charAt(i) == closedParen) numClosedParen++;
            if (numClosedParen > numOpenParen) { // We have an extra closed paren we need to remove
                for (int j = jStart; j <= i; j++) // Try removing one at each position, skipping duplicates
                    if (s.charAt(j) == closedParen && (j == jStart || s.charAt(j - 1) != closedParen))
                        // Recursion: iStart = i since we now have valid # closed parenthesis thru i. jStart = j prevents duplicates
                        removeHelper(s.substring(0, j) + s.substring(j + 1, s.length()), output, i, j, openParen, closedParen);
                return; // Stop here. The recursive calls handle the rest of the string.
            }
        }
        // No invalid closed parenthesis detected. Now check opposite direction, or reverse back to original direction.
        String reversed = new StringBuilder(s).reverse().toString();
        if (openParen == '(')
            removeHelper(reversed, output, 0, 0, ')','(');
        else
            output.add(reversed);
    }

}
