package leetcode.leetcode1_499;

import java.util.Arrays;
import java.util.TreeSet;

public class leet264 {

    //mine 优先级队列
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        TreeSet<Long> treeSet=new TreeSet<>();
        treeSet.add(1L);
        int count=1;
        while (count<n){
            long num=treeSet.pollFirst();
            treeSet.addAll(Arrays.asList(num*2,num*3,num*5));
            count++;
        }
        return treeSet.pollFirst().intValue();
    }




    //六个变量分别记录数字和index   https://leetcode.com/problems/ugly-number-ii/discuss/69362/O(n)-Java-solution
   /* public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i=1;i<n;i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            ugly[i] = min;
            if(factor2 == min)
                factor2 = 2*ugly[++index2];
            if(factor3 == min)
                factor3 = 3*ugly[++index3];
            if(factor5 == min)
                factor5 = 5*ugly[++index5];
        }
        return ugly[n-1];
    }*/
   //只需要三个变量
/*    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        int t2=0,t3=0,t5=0;
        int []k=new int[n];
        k[0]=1;
        for(int i=1;i<n;i++){
            k[i]=Math.min(k[t2]*2,Math.min(k[t3]*3,k[t5]*4));
            if(k[i]==k[t2]*2) t2++;
            if(k[i]==k[t3]*3) t3++;
            if(k[i]==k[t5]*5) t5++;
        }
        return k[n-1];
    }*/

}
