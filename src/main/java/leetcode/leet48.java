package leetcode;

public class leet48 {
    //mine 找规律 就是规律有点不好找
    public void rotate(int[][] matrix) {
       for(int circle=0;circle<matrix.length/2;circle++){
           for(int upright=circle;upright<matrix.length-circle-1;upright++){
              int temp= matrix[circle][upright];
              matrix[circle][upright]=matrix[matrix.length-upright-1][circle];
               matrix[matrix.length-upright-1][circle]=matrix[matrix.length-1-circle][matrix.length-upright-1];
               matrix[matrix.length-1-circle][matrix.length-upright-1]=matrix[upright][matrix.length-1-circle];
               matrix[upright][matrix.length-1-circle]=temp;
             /* int  []index1={circle,upright};
              int []index2={upright,matrix.length-1-circle};
              int []index3={matrix.length-1-circle,matrix.length-upright-1};
              int []index4={matrix.length-upright-1,circle};
               System.out.println(index1[0]+"   "+index1[1]);
               System.out.println(index2[0]+"   "+index2[1]);
               System.out.println(index3[0]+"   "+index3[1]);
               System.out.println(index4[0]+"   "+index4[1]);*/
           }
       }
    }

    //结果居然可以这样  先 swap(matrix[i][j], matrix[j][i])  根据对角线交换 ，
    //然后swap(matrix[i][j], matrix[i][matrix.length-1-j] 根据竖直中线变换
    /*public void rotate(int[][] matrix) {
        for(int i = 0; i<matrix.length; i++){
            for(int j = i; j<matrix[0].length; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i =0 ; i<matrix.length; i++){
            for(int j = 0; j<matrix.length/2; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }*/
}
