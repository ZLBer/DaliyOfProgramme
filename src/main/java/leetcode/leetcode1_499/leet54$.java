package leetcode.leetcode1_499;

import java.util.ArrayList;
import java.util.List;

public class leet54$ {
    //这是不是我参加蓝桥杯那个题.. 其实不是很简单，要是考虑不好还是要考虑很多情况
/*    public List<Integer> spiralOrder(int[][] matrix) {

    List<Integer> result=new ArrayList<>();
        if(matrix.length==0) return  result;
        //表示第几圈
        int max=0;
        if(matrix.length%2==0)
            max=matrix.length/2;
        else max=matrix.length/2+1;
        for(int circle=0;circle<max;circle++){
           for(int i=circle;i<matrix[0].length-circle;i++){
               result.add(matrix[circle][i]);
               System.out.println(1);
           }
           for(int i=circle+1;i<matrix.length-circle;i++){
               result.add(matrix[i][matrix[0].length-1-circle]);
               System.out.println(2);
           }
           for(int i=matrix[0].length-2-circle;i>=circle&&(matrix.length-1-circle)!=circle;i--){
              result.add(matrix[matrix.length-1-circle][i]);
               System.out.println(3);
           }
           for(int i=matrix.length-2-circle;i>circle&&(matrix[0].length-1-circle)!=circle;i--){
               result.add(matrix[i][circle]);
               System.out.println(4);
           }

        }
        return result;
    }*/




    //每次四个边界动态增加  就没有了静态里的重复问题
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result=new ArrayList<>();
            if(matrix.length==0) return  result;
            int rowBegin=0;
            int rowEnd=matrix.length-1;
            int colBegin=0;
            int colEnd=matrix[0].length-1;
            while (rowBegin<=rowEnd&&colBegin<=colEnd){
                for(int i=colBegin;i<=colEnd;i++){
                    result.add(matrix[rowBegin][i]);
                }
                rowBegin++;
                for(int i=rowBegin;i<=rowEnd;i++){
                    result.add(matrix[i][colEnd]);
                }
                colEnd--;

                //防止重复计算 =可以是因为rowBegin是下一行的
                if(rowEnd>=rowBegin)
                for(int i=colEnd;i>=colBegin;i--) {
                    result.add(matrix[rowEnd][i]);
                }
                rowEnd--;
                //防止重复计算
                if(colBegin<=colEnd)
                for(int i=rowEnd;i>=rowBegin;i--) {
                    result.add(matrix[i][colBegin]);
                }
                colBegin++;
            }


            return result;
        }



   /*     //更好理解的方式
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix.length == 0 || matrix[0].length == 0) return res;

        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;



        *//*   //只要有一个边界溢出就表示已经完事了
          例如 1  2   3  或   1
                             2
                             3
         *//*
        while(true){
            for(int i = left; i <= right; i++) res.add(matrix[top][i]);
            top++;
            if(left > right || top > bottom) break;

            for(int i = top; i <= bottom; i++) res.add(matrix[i][right]);
            right--;
            if(left > right || top > bottom) break;

            for(int i = right; i >= left; i--) res.add(matrix[bottom][i]);
            bottom--;
            if(left > right || top > bottom) break;

            for(int i = bottom; i >= top; i--) res.add(matrix[i][left]);
            left++;
            if(left > right || top > bottom) break;
        }

        return res;
    }*/

}
