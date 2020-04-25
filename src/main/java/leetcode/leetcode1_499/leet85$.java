package leetcode.leetcode1_499;

import java.util.Arrays;

public class leet85$ {

    //按照之前那个题目的思路来做  直接复用之前的函数
/*    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0) return 0;
        int[] hight=new int[matrix[0].length];
        int maxArea=0;
        for(int row=0;row<matrix.length;row++){
            for(int col=0;col<matrix[0].length;col++){
                if(matrix[row][col]=='1') hight[col]++;
                else hight[col]=0;

            }
            for(int col=0;col<matrix[0].length;col++){
                System.out.println(hight[col]);
            }
            maxArea=Math.maxSum(maxArea,largestRectangleArea(hight));
        }
        return maxArea;
    }


    //把less数组优化一下   查找方式有点像并查集
    public int largestRectangleArea(int[] height) {


        if (height.length==0) return 0;

        int maxArea=0;
        int []leftless=new int[height.length];
        int []rightLess=new int[height.length];



        //初始化条件
        leftless[0]=-1;
        for (int i = 0; i < leftless.length; i++) {
            int p=i-1;
            while (p>=0&&height[p]>=height[i]){
                p=leftless[p];
            }
            leftless[i]=p;
        }

        //初始化条件
        rightLess[rightLess.length-1]=height.length;
        for (int i = height.length-2; i>=0; i--) {
            int p=i+1;
            while (p<rightLess.length&&height[p]>=height[i]){
                p=rightLess[p];
            }
            rightLess[i]=p;
        }

        for (int i = 0; i < height.length; i++) {
            maxArea=Math.maxSum(maxArea,height[i]*(rightLess[i]-leftless[i]-1));
        }
        return maxArea;
    }*/

    public int maximalRectangle(char[][] matrix) {

        if(matrix.length==0) return 0;
        int []left=new int[matrix[0].length];
        int[]right=new int[matrix[0].length];
        int []height=new int[matrix[0].length];
        Arrays.fill(right,matrix[0].length);
 int maxArea=0;
        for (int i = 0; i < matrix.length; i++) {

            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1') height[j]++;
                else height[j]=0;
            }


            int cur=0;
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1') left[j]=Math.max(left[j],cur);
                else{
                    left[j]=0;
                    cur=j+1;
                }
            }
            cur=matrix[0].length;
            for(int j=matrix[0].length-1;j>=0;j--){
                if(matrix[i][j]=='1') right[j]=Math.min(right[j],cur);
                else{
               right[j]=matrix[0].length;
                    cur=j;
                }
            }

            for(int j=0;j<matrix[0].length;j++){
                maxArea=Math.max(maxArea,height[j]*(right[j]-left[j]));
            }
        }
        return maxArea;

    }
}
