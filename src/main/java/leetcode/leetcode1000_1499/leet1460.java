package leetcode.leetcode1000_1499;

public class leet1460 {
/*    public boolean canBeEqual(int[] target, int[] arr) {
     Map<Integer,Integer> map=new HashMap<>();
        for (int i : target) {
           map.put(i,map.getOrDefault(i,0)+1);
        }
        for (int i : arr) {
         if(!map.containsKey(i)) return false;
        int val=map.get(i);
       if(val==1) map.remove(i);
       else {
          map.put(i,val-1);
       }
        }
        return true;
    }*/
/*    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);

        for (int i = 0; i < target.length; i++) {
            if(target[i]!=arr[i]) return false;
        }
        return true;
    }*/



    //桶排序
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] bucket = new int[1001];//因为数据量就是这么大
        for (int i=0;i<target.length;i++)
            bucket[target[i]]++;

        for (int i=0;i<arr.length;i++) {
            bucket[arr[i]]--;
        }
        for(int j=0;j<bucket.length;j++){
            if(bucket[j]!=0)
                return false;
        }

        return true;
    }
}
