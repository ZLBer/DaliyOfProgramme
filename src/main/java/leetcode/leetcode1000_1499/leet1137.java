package leetcode.leetcode1000_1499;

public class leet1137 {

    //mine 递归
    int []tn=new int[38];
    public int tribonacci(int n) {


        return helper(n);
    }
    int helper(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 1;
        if(tn[n]!=0) return tn[n];
        else {
            tn[n]=helper(n-1)+helper(n-2)+helper(n-3);
            return tn[n];
        }
    }

    //mine 直接遍历
/*    public int tribonacci(int n) {
        int []tn=new int[38];
        tn[0]=0;
        tn[1]=1;
        tn[2]=1;
        for(int i=3;i<=n;i++){
            for(int j=i-3;j<i;j++){
                tn[i]+=tn[j];
            }
        }
        return tn[n];
   } */
}
