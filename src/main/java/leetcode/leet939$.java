package leetcode;

import java.util.*;

/**
 * Created by libin on 2019/4/20.
 */
public class leet939$ {

    //nice solution
    //也不是什么很高级的方法，也是全部遍历，但是想出怎么解决不容易
   static public int minAreaRect(int[][] points) {
       int min=Integer.MAX_VALUE;
       Map<Integer,HashSet> map=new HashMap<>();
       for(int []a:points){
           if(!map.containsKey(a[0])){
               map.put(a[0],new HashSet());
           }
           map.get(a[0]).add(a[1]);
       }
       for(int []a:points){
           for(int []b:points){
               if(a[0]==b[0]||a[1]==b[1])
                   continue;
               if(map.get(a[0]).contains(b[1])&&map.get(b[0]).contains(a[1]))
                  min=Math.min(min,Math.abs(a[0]-b[0])*Math.abs(a[1]-b[1]));

           }
       }

return min==Integer.MAX_VALUE?0:min;
    }

    public static void main(String[] args) {
   minAreaRect(new int[][]{{1,1},{2,-1},{1,2}});
    }

    private   static class CompareArray implements Comparator<int []> {
        @Override
        public int compare(int[] a, int[] b) {


            if (a[0] > b[0]) return 1;
            else if (a[0] < b[0]) return -1;
            else {
                if (a[1] > b[1])
                    return 1;
                else return -1;

            }
        }
    }
}
