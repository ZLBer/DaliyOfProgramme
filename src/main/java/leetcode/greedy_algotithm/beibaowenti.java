package leetcode.greedy_algotithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by libin on 2017/9/30.
 */
public class beibaowenti {
double knapsack(int n,bag[]a,double c) {
    Arrays.sort(a, 0, n, new cmp());
    double cleft = c;
    int i = 0;
    double b = 0;
    while (i < n && a[i].w < cleft) {
        cleft -= a[i].w;
        b += a[i].v;
        a[a[i].index].x = 1.0;
        i++;
    }
    if(i<n){
        a[a[i].index].x=1.0*cleft/a[i].w;
        b+=a[a[i].index].x*a[i].v;
    }
    return b;
}

}

class cmp implements Comparator<bag> {
   /*
    * cmp因子
    * 此处为降序排列，所以<返回-1
    */
   public int compare(bag A, bag B) ///降序排序
   {
       if(A.c<B.c)
       {
           return 1;
       }
       else if(A.c==B.c)
       {
           return 0;
       }
       else
       {
           return -1;
       }

   }
}
class bag{
    int w;
    int v;
    double c;
    int index;
    double x;
}
