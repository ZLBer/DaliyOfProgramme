package leetcode;

public class leet1541 {
    //mine
/*  static   public int minInsertions(String s) {
        int res=0;
    int left=0;
    int right=0;
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(c=='('){
                if(left!=0&&right!=0){
                    res++;
                    left--;
                    right--;
                }
               if(right!=0){
                   res+=(right/2+((right%2==1)?2:0));
                  right=0;
               }
                left++;
            }else {
                right++;
                if(left>0&&right>=2){
                  right-=2;
                  left--;
                }
            }
        }
        if(left!=0&&right!=0){
           res++;
           left--;
           right--;
        }
       if(left!=0){
        res+=left*2;
        left=0;
       }
       if(right!=0){
         res+=(right/2+((right%2==1)?2:0));
       }
       return res;
    }*/


    int minInsertions(String s) {
        int ans = 0, left = 0, n = s.length();
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(') ++left; // 左括号次数
            else if (s.charAt(i) == ')') {
                if (i+1 < n && s.charAt(i+1) == ')') ++i; // 找第二个左括号
                else ++ans; // 缺少第二个右括号就添加一个
                if (left > 0) --left;   // 两个右括号匹配一个左括号
                else ++ans; // 缺少左括号就添加一个
            }
        }
        ans += left * 2;  // 多出的左括号都匹配两个右括号
        return ans;
    }


    public static void main(String[] args) {
       // minInsertions("))");
    }
}
