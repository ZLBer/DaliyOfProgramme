package leetcode;

public class leet1140$ {
    //sum用来存从i到最后的数目
/*    private int[] sums;//the sum from piles[i] to the end
    private int[][] hash; //用来缓存在i和M的情况下，改位置可以得到的最多的数目
    public int stoneGameII(int[] piles) {
        if(piles == null || piles.length == 0) return 0;
        int n = piles.length;
        sums = new int[n];
        sums[n-1] = piles[n-1];
        for(int i = n -2; i>=0;i--) {
            sums[i] = sums[i+1] + piles[i]; //the sum from piles[i] to the end
        }

        hash = new int[n][n];
        return helper(piles, 0, 1);
    }

    private int helper(int[] a, int i, int M) {
        //遍历到了最后
        if(i == a.length) return 0;
       // i+2*M >= a.length  表示可以全部收下
        if(2*M >= a.length - i) {
            return sums[i];
        }
        if(hash[i][M] != 0) return hash[i][M];
        int min = Integer.MAX_VALUE;//the min value the next player can get
        for(int x=1;x<=2*M;x++){
            //i<- 中间表示给对手的->i+x x表示对手拿到的个数
             min = Math.min(min, helper(a, i+x, Math.max(M,x)));
        }
        hash[i][M] = sums[i] - min;  //max stones = all the left stones - the min stones next player can get
        return hash[i][M];
    }*/









  //自己再重写一遍

    public int stoneGameII(int[] piles) {
     int []sums=new int[piles.length];
    int  catchs[][] =new int[piles.length][piles.length];

    sums[piles.length-1]=piles[piles.length-1];
    for(int i=piles.length-2;i>=0;i--){
        sums[i]=sums[i+1]+piles[i];
    }

    return  helper(piles,sums,catchs,0,1);

    }

     int helper(int[]piles,int[]sums,int [][]catchs,int i,int M){
        if(i==piles.length)return 0;
        if(i+2*M>=piles.length){
            return sums[i];
        }


        if(catchs[i][M]!=0) return catchs[i][M];
        int min=Integer.MAX_VALUE;

        for(int x=1;x<=2*M;x++){
            min=Math.min(min,helper(piles,sums,catchs,i+x,Math.max(x,M)));
        }

        catchs[i][M]=sums[i]-min;
        return catchs[i][M];

     }





}
