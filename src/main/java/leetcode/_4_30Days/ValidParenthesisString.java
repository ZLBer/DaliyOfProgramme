package leetcode._4_30Days;

public class ValidParenthesisString {
    public boolean checkValidString(String s) {
 return dfs(0,0,s);
    }

    boolean dfs(int left,int index,String s){
        if(index>=s.length()){
         if(left==0) return true;
         else return false;
        }

        if(left<0) return false;

        char c=s.charAt(index);

        if(c=='('){
           return dfs(left+1,index+1,s);
        }else if(c==')'){
           return dfs(left-1,index+1,s);
        }else { //*号
           return dfs(left+1,index+1,s)||dfs(left-1,index+1,s)||dfs(left,index+1,s);
        }
    }

    //强
   /* public boolean checkValidString(String s) {
        int low=0,high=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                low++;
                high++;
            }
            else if(s.charAt(i)==')'){
                if (low > 0) {
                    low--;
                }
                high--;
            }else {
              if(low>0){
                  low--;
              }
                high++;
            }

            if(high<0) return false;
        }
        return low==0;
    }*/
    
}
