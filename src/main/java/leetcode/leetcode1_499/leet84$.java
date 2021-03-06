package leetcode.leetcode1_499;

import java.util.Arrays;
import java.util.Stack;

public class leet84$ {

    //O(n2)
/*    public int largestRectangleArea(int[] height) {


        int maxArea=0;
   int []leftless=new int[height.length];
   int []rightLess=new int[height.length];

        for (int i = 0; i < leftless.length; i++) {
            int p=i-1;
            while (p>=0&&height[p]>=height[i]){
               p--;
            }
            leftless[i]=p;
        }
        for (int i = 0; i < rightLess.length; i++) {
            int p=i+1;
            while (p<rightLess.length&&height[p]>=height[i]){
                p++;
            }
            rightLess[i]=p;
        }

        for (int i = 0; i < height.length; i++) {
            maxArea=Math.maxSum(maxArea,height[i]*(rightLess[i]-leftless[i]-1));
        }
        return maxArea;
    }*/


    //把less数组优化一下   查找方式有点像并查集
 /*   public int largestRectangleArea(int[] height) {


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
            maxArea=Math.max(maxArea,height[i]*(rightLess[i]-leftless[i]-1));
        }
        return maxArea;
    }*/


    //stack  确实不太好理解啊

    /* static public int largestRectangleArea(int[] height) {
            int len = height.length;
            Stack<Integer> s = new Stack<Integer>();
            int maxArea = 0;
            for(int i = 0; i <= len; i++){
                int h = (i == len ? 0 : height[i]);
                if(s.isEmpty() || h >= height[s.peek()]){
                    //遇到更高的就继续往里放
                    s.push(i);
                }else{
                    int tp = s.pop();
                    // height[tp]表示高度 ， i - 1 - s.peek()表示宽度 ；s.isEmpty()表示之前没有在比 height[tp] 更矮的了，为此刻的全局最低点，所以宽度返回当前位置的i序号
                    //(i - 1 - s.peek())到i之间肯定都是比height[tp]高的
                    maxArea = Math.maxSum(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                    //保持序号不表继续往前找
                    i--;
                }
            }
            return maxArea;
        }*/
    public static void main(String[] args) {
        //largestRectangleArea(new int[]{5,4,5});
    }

    //单调栈维护左右边界
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Arrays.fill(right, heights.length);
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                right[stack.pop()] = i;
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        int res = 0;
        for (int i = 0; i < left.length; i++) {
            int area = heights[i]*(right[i]-left[i]-1);
            res=Math.max(area,res);
        }
        return res;

    }

    public int maximalRectangle(char[][] matrix) {
        if(matrix==null||matrix.length==0)  return 0;

        int []heights=new int[matrix[0].length];
        int res=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]=='1'){
                    heights[j]++;
                }else {
                    heights[j]=0;
                }
            }
            res=Math.max(res,largestRectangleArea(heights));
        }
        return res;
    }
}
