package leetcode.greedy_algotithm;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by libin on 2017/10/7.
 */
public class zuiyouzhuangzai {
     void solution (load []box,int c,int n,int []x){
         Arrays.sort(box,new cmp());
         if(box[1].w>c){
             System.out.println("no answer");
         }
         int i;
         for(i=1;i<=n&&box[i].w<=c;i++){
             x[box[i].index]=1;
             c-=box[i].w;
         }
         System.out.println(i-1);//输出集装箱数量
         for(i=1;i<=n;i++){
             if(x[i]==1) System.out.println(i); //输出集装箱编号
         }
     }






    class cmp implements Comparator<load> {
        /*
         * cmp因子
         * 此处为降序排列，所以<返回-1
         */
        public int compare(load A, load B) ///降序排序
        {
            if(A.w<B.w)
            {
                return 1;
            }
            else if(A.w==B.w)
            {
                return 0;
            }
            else
            {
                return -1;
            }

        }
    }
}

class load{
    int index;
    int w;
}
