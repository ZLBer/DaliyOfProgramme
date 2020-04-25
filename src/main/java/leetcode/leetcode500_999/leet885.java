package leetcode.leetcode500_999;

import java.util.ArrayList;
import java.util.List;

public class leet885 {
    //mine  找规律
   /* public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int count=R*C;
        int [][]res=new int[count][2];
        int tc=0;
        int circle=1;
        int fromR=r0,fromC=c0;
        res[tc++]=new int[]{r0,c0};
        while (tc<count){
           // System.out.println(tc);
           //向右 行号不变
            int endR=fromR,endC=fromC+circle;
           // System.out.println(fromR+"  "+fromC+"  "+endR+"  "+endC);
            if(endR>=0&&endR<R){
            for(int i=fromC+1;i<=endC;i++){
                if(i>=0&&i<C){
                    res[tc++]=new int[]{fromR,i};
                  //  System.out.println("11");

                }
            }}

            //向下 列号不变
            fromR=endR;fromC=endC;
            endR=fromR+circle;
          //  System.out.println(fromR+"  "+fromC+"  "+endR+"  "+endC);

            if(endC>=0&&endC<C) {
                for (int i = fromR + 1; i <= endR; i++) {
                    if (i < R&&i>=0) {

                        res[tc++] = new int[]{i, endC};
                     //   System.out.println("22");

                    }
                }
            }
            circle++;
            //向左 行号不变
            fromC=endC;fromR=endR;
            endC=endC-circle;endR=fromR;
           // System.out.println(fromR+"  "+fromC+"  "+endR+"  "+endC);

            if(endR>=0&&endR<R) {
                for (int i = fromC - 1; i >= endC; i--) {
                    if (i >= 0&&i<C) {
                        res[tc++] = new int[]{endR, i};
                      //  System.out.println("33");

                    }
                }
            }
         //向上 列号不变
            fromC=endC;fromR=endR;
            endC=fromC;endR=fromR-circle;
           // System.out.println(fromR+"  "+fromC+"  "+endR+"  "+endC);
             if(endC>=0&&endC<C) {
                 for (int i = fromR - 1; i >= endR; i--) {
                     if (i >= 0&&i<R) {
                         res[tc++] = new int[]{i, endC};
                         //System.out.println("33");

                     }
                 }
             }
            circle++;
             fromC=endC;fromR=endR;

        }
        return res;
    }*/



    //害  可真牛皮
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] dirt = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // east, south, west, north
        List<int[]> res = new ArrayList<>();
        int len = 0, d = 0; // move <len> steps in the <d> direction
        res.add(new int[]{r0, c0});
        while (res.size() < R * C) {
            if (d == 0 || d == 2) len++; // when move east or west, the length of path need plus 1
            for (int i = 0; i < len; i++) {
                r0 += dirt[d][0];
                c0 += dirt[d][1];
                if (r0 >= 0 && r0 < R && c0 >= 0 && c0 < C) // check valid
                    res.add(new int[]{r0, c0});
            }
            d = (d + 1) % 4; // turn to next direction
        }
        return res.toArray(new int[R * C][2]);
    }
}
