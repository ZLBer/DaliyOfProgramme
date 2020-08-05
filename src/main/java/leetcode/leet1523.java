package leetcode;

public class leet1523 {
/*    public int countOdds(int low, int high) {
    int res=0;
    for(int i=low;i<=high;i++){
        if((i&1)==1) res++;
    }
    return res;
    }*/

    //正确写法
    public int countOdds(int low, int high) {
        return (high - low) / 2 + ((low % 2 != 0 || high % 2 != 0)?1:0);
    }
}
