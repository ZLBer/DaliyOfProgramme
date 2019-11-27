package leetcode.leetcode1000_;

import java.util.ArrayList;

/**
 * Created by libin on 2019/3/28.
 */
public class leet1006 {


    //BF
    public int clumsy(int N) {
        ArrayList<Integer> ls=new ArrayList<>();
        for(int i=N;i>=1;){
            if(i-2>0) {
                ls.add(i*(i-1)/(i-2));
                i=i-3;
                if(i>0) ls.add(i--);
                else break;
//                if(i>0) ls.add(i--);
//                else  break;
            }
             else if(i-1>0){
                ls.add(i*(i-1));
                i=i-2;
                if(i>0) ls.add(i--);
                else break;
//                if(i>0) ls.add(i--);
//                else  break;
            }
             else if (i>0){
                 ls.add(i);
                 i=i-1;
                if(i>0) ls.add(i--);
                else break;
//                if(i>0) ls.add(i--);
//                else  break;
            }
       }

//       for(int a:ls){
//           System.out.print(a+"  ");
//       }
        int result=ls.get(0);
        for(int i=1;i<ls.size();){
            result+=ls.get(i++);
            if(i<ls.size()) result-=ls.get(i++);
        }

        return result;
    }


   //递归
/*    public int clumsy(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        if (N == 2) return 2;
        if (N == 3) return 6;
        return N * (N - 1) / (N - 2) + helper(N - 3);
    }
    public int helper(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        if (N == 2) return 1;
        if (N == 3) return 1;
        return N - (N - 1) * (N - 2) / (N - 3) + helper(N - 4);
    }*/


  //找规律
   /* public int clumsy(int N) {
        if (N == 1) return 1;
        if (N == 2) return 2;
        if (N == 3) return 6;
        if (N == 4) return 7;
        if (N % 4 == 1) return N + 2;
        if (N % 4 == 2) return N + 2;
        if (N % 4 == 3) return N - 1;
        return N + 1;
    }*/
}
