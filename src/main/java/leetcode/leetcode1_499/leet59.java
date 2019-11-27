package leetcode.leetcode1_499;

public class leet59 {
    //在上一题的引导下就好做多了

    public int[][] generateMatrix(int n) {
        int[][] res=new int[n][n];
        int top=0;
        int bottom=n-1;
        int left=0;
        int right=n-1;
        int num=1;
        while (top<=bottom&&left<=right){
            for(int i=left;i<=right;i++){
                res[top][i]=num;
                num++;
            }
            top++;
            for(int i=top;i<=bottom;i++){
                res[i][right]=num;
                num++;
            }
            right--;


            if(top<=bottom)
                for(int i=right;i>=left;i--){
                    res[bottom][i]=num;
                    num++;
                }
            bottom--;
            if(left<=right)
                for(int i=bottom;i>=top;i--){
                    res[i][left]=num;
                    num++;
                }
            left++;
        }
        return res;
    }
}
