package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leet986 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int []> result=new ArrayList<>();
        int a=0,b=0;
        while (a<A.length&&b<B.length){
            int[]intervalA=A[a];
            int []intervalB=B[b];
            if(intervalA[1]<intervalB[0]){
                a++;
                continue;
            }else if(intervalB[1]<intervalA[0]){
                b++;
                continue;
            }
            int[] res=new int[2];
            //比较头
            if(intervalA[0]<intervalB[0]){
                res[0]=intervalB[0];
            }
            else {
                res[0]=intervalA[0];
            }
            //比较尾
            if(intervalA[1]<intervalB[1]){
                res[1]=intervalA[1];
                a++;
                result.add(res);
            }else {
                res[1]=intervalB[1];
                b++;
                result.add(res);

            }

        }
        int[][] res=new int[result.size()][2];
        for (int i = 0; i < res.length; i++) {
             res[i]=result.get(i);
        }
     return  res;
    }
}
