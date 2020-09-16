package leetcode.leetcode1000_1499;

import java.util.*;

public class leet1387 {

    //mine 感觉写的不是很好啊
    static Map<Integer,Integer> map=new HashMap<>();
    public int getKth(int lo, int hi, int k) {
        List<int[]> list=new ArrayList<>();
        for(int i=lo;i<hi;i++){
      list.add(new int[]{i,helper(i)});
      }
        Collections.sort(list,(a,b)->a[2]==b[2]?a[2]-b[2]:a[0]-b[0]);
        list.forEach(a-> System.out.println(a[0]));
        return list.get(k)[0];
    }

    int helper(int num){
        if(num==1) return 0;
       if(map.containsKey(num)) return map.get(num);
       int newVal=num;
       if(num%2==0){
           newVal/=2;
       }else {
           newVal=num*3+1;
       }
        int step= 1+helper(newVal);
        map.put(num,step);
        return step;
    }
}
