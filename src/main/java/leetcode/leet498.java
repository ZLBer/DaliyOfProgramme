package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leet498 {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix==null||matrix.length==0)return new int[0];
    int []res=new int[matrix.length*matrix[0].length];

     int []begin = new int[]{0,0};

     int step=0;
     int index=0;
     while (begin[0]<matrix.length&&begin[1]<matrix[0].length){
         System.out.println(begin[0]+" "+begin[1]);

       List<Integer> temp=new ArrayList<>();
        int x=begin[0],y=begin[1];
        while (x>=0&&y<matrix[0].length){
            temp.add(matrix[x][y]);
            x--;
            y++;
        }
        if(step%2==0){
            for (int tm: temp) {
                res[index++]=tm;
            }
        }else {
            for (int i = temp.size() - 1; i >= 0; i--) {
                res[index++]=temp.get(i);
            }
        }
        step++;
         if(begin[0]<matrix.length-1){
             begin[0]++;
         }else {
             begin[1]++;
         }
     }
     return res;
    }
}
