package leetcode;

public class leet397$ {

    //这种题 额..怎么硕呢
    public int integerReplacement(int n) {
        int res=0;
        while(n!=1){
            //System.out.println(n);
            res++;
            if((n&1)==0){
                n>>>=1;
            }else if(n==3||Integer.bitCount(n+1)>Integer.bitCount(n-1)) {
                n--;
            }else {
                n++;
            }
        }
        return res;
    }
}
