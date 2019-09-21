package leetcode.leetcode500_999;

import java.util.*;

/**
 * Created by libin on 2019/4/11.
 */
public class leet970 {
    //mine   Time Limit Exceeded
//    public List<Integer> powerfulIntegers(int x, int y, int bound) {
//       Set<Integer> result=new HashSet<>();
//        int boundX=(int)log(bound,x);
//        int boundY=(int)log(bound,y);
//       // System.out.println(boundX+"  "+boundY);
//       for(int i = 0; i<= boundX; i++){
//           for(int j=0;j<=boundY;j++){
//               int temp=(int)Math.pow(x,i)+(int)Math.pow(y,j);
//             //  System.out.println(temp);
//               if(temp<=bound) result.add(temp);
//           }
//
//       }
//       return new ArrayList<>(result);
//    }
//    static public double log(double value, double base) {
//         return Math.log(value) / Math.log(base);
//    }


  //看看人家的代码！
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> s = new HashSet<>();
        for (int i = 1; i < bound; i *= x > 1? x : bound + 1)//若是i运算后<=1,强行使i越界 ,如x=0,1
            for (int j = 1; i + j <= bound; j *= y > 1 ? y : bound + 1)
                s.add(i + j);
        return new ArrayList<>(s);
    }
}
