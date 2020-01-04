package leetcode;

public class leet678 {
/*  public boolean checkValidString(String s) {
      int left=0,all=0;
      for(char c:s.toCharArray()){
          if(c=='(') left++;
          else if(c=='*') all++;
          else {
              if(left>0) left--;
              else if(all>0) all--;
              else return false;
          }
      }
      if(left!=0) return left<=all?true:false;
      return true;
    }*/


 //mine stupid DFS
 /*   public boolean checkValidString(String s) {
         return dfs(s,0,0);
    }
    boolean dfs(String s,int deep,int left){
        if(deep>=s.length()) {
          if(left==0) return true;
          else return false;
        }
        if(s.charAt(deep)=='*'){
           //当作右括号
            if(left>0){
                if(dfs(s,deep+1,left-1)) return true;
            }
            //当作空
            if(dfs(s,deep+1,left)) return true;

            //当作左括号
            if( dfs(s,deep+1,left+1)) return true;


        }else if(s.charAt(deep)==')'){
            if(left==0) return false;
            else {
                if(dfs(s,deep+1,left-1)) return true;

            }
        }else {
            if(dfs(s,deep+1,left+1)) return  true;

        }
        return false;
    }*/


    //防止了大部分的回溯
   /* public boolean checkValidString(String s) {
        return check(s, 0, 0);
    }

    private boolean check(String s, int start, int count) {
        if (count < 0) return false;

        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            }
            else if (c == ')') {
                if (count <= 0) return false;
                count--;
            }
            else if (c == '*') {
                return check(s, i + 1, count + 1) || check(s, i + 1, count - 1) || check(s, i + 1, count);
            }
        }

        return count == 0;
    }*/


   //也想过这种 但没想全
   /* public boolean checkValidString(String s) {
        Stack<Integer> leftID = new Stack<>();
        Stack<Integer> starID = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                leftID.push(i);
            else if (ch == '*')
                starID.push(i);
            else {
                if (leftID.isEmpty() && starID.isEmpty())   return false;
                if (!leftID.isEmpty())
                    leftID.pop();
                else
                    starID.pop();
            }
        }
        while (!leftID.isEmpty() && !starID.isEmpty()) {
            if (leftID.pop() > starID.pop())
                return false;
        }
        return leftID.isEmpty();
    }*/

   //c 太强了吧
    //具体解释 https://leetcode.com/problems/valid-parenthesis-string/discuss/107577/Short-Java-O(n)-time-O(1)-space-one-pass
    public boolean checkValidString(String s) {
        int low = 0;
        int high = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                low++;
                high++;
            } else if (s.charAt(i) == ')') {
                if (low > 0) {
                    low--;
                }
                high--;
            } else {
                if (low > 0) {
                    low--;
                }
                high++;
            }
            if (high < 0) {
                return false;
            }
        }
        return low == 0;
    }
}
