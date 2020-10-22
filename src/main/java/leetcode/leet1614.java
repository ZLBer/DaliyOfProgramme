package leetcode;

public class leet1614 {
    public int maxDepth(String s) {
       int count=0;
       int res=0;
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(c=='(') count++;
            else if(c==')'){
               res=Math.max(res,count);
                count--;
            }
        }
        return res;
    }







    public static void main(String[] args) {

    }
}
