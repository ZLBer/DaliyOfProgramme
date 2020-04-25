package leetcode.leetcode1000_;

public class leet1394 {
    //mine map 不能不加max  map对int也不是有序的  自己以前的理解有问题
   /* Map<Integer,Integer> map=new HashMap<>();
    public int findLucky(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        int res=-1;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()==entry.getKey()) res=Math.max(res,entry.getKey());
        }
        return res;
    }*/


   //mine 数组
   int []count=new int[501];
    public int findLucky(int[] arr) {
        int res=-1;
        for (int i = 0; i < arr.length; i++) {
          count[arr[i]]++;
        }
        for (int i = 500; i >=1; i--) {
            if(count[i]==i) return i;
        }
        return -1;
    }
}
