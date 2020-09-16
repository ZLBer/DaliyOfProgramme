package leetcode;

public class leet1574 {
    //mine
/*    public int findLengthOfShortestSubarray(int[] arr) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        map.put(arr[0],0);

        int i=1;
        for (; i < arr.length; i++) {
            if(arr[i]>=arr[i-1]){
            map.put(arr[i],i);
            }else {
            break;
            }
        }

      //  System.out.println(map.size());
      if(i==arr.length) return 0;//不需要删
         int res=arr.length-i;
        int start=0;
        for ( i = arr.length-2; i >= 0; i--) {
           if(arr[i]<=arr[i+1])continue;
           else {
           start= i+1 ;
           break;
           }
        }
       // System.out.println(start);
         res=Math.min(res,start);
       for( i=start;i<arr.length;i++){
        Integer pre=map.floorKey(arr[i]);
        //   System.out.println(pre);
        if(pre==null){
            res=Math.min(i,res);
        }else {
            res=Math.min(i-map.get(pre)-1,res);
        }
       }
       return res;
    }*/

  //可以不用set 用双指针来计算
    public int findLengthOfShortestSubarray(int[] arr) {
        int left = 0;
        while(left + 1 < arr.length && arr[left] <= arr[left+1]) left++;
        if(left == arr.length - 1) return 0;

        int right = arr.length - 1;
        while(right > left && arr[right-1] <= arr[right]) right--;
        int result = Math.min(arr.length - left - 1, right);

        int i = 0;
        int j = right;
        while(i <= left && j < arr.length) {
            if(arr[j] >= arr[i]) {
                result = Math.min(result, j - i - 1);
                i++;
            }else {
                j++;
            }
        }
        return result;
    }

}
