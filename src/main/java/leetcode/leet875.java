package leetcode;

public class leet875 {
    public int minEatingSpeed(int[] piles, int H) {
    int left=1,right=(int)1e9;

    while (left<right){

      int mid=(left+right)/2;

      if(helper(mid,piles,H)){
         right=mid;
      }else {
         left=mid+1;
      }
    }
    return right;

    }

    boolean helper(int i,int []piles,int H){
        int res=0;

        for (int pile : piles) {
            //res=res+(pile/i)+((pile%i)==0?0:1);
          //优化
            res+=(pile-1)/i+1;
        }
        System.out.println(res<=H);
       return res<=H;
    }
}
