package leetcode.leetcode1000_;

import java.util.HashMap;

public class leet1218 {
    //超时了
/*    public int longestSubsequence(int[] arr, int difference) {
         boolean[]visited=new boolean[arr.length];
         int result=0;
        for (int i = 0; i < arr.length; i++) {
            if(visited[i])continue;
            int next=arr[i]+difference;
            int count=1;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]==next){
                    visited[j]=true;
                    next+=difference;
                    count++;
                }
            }
            result= Math.max(result,count);
        }
        return result;
    }*/
 /*  static public int longestSubsequence(int[] arr, int difference) {
        int []dp=new int[arr.length];
        int result=0;
        for (int i = 0; i < arr.length; i++) {
            int pre=arr[i]-difference;
            for(int j=i-1;j>=0;j--){
            if(arr[j]==pre){
                dp[i]=Math.max(dp[j]+1,dp[i]);
            }

            }
            result=Math.max(dp[i],result);
        }
        return result+1;
    }*/

/*    static public int longestSubsequence(int[] arr, int difference) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            //有pre
            if(map.containsKey(arr[i]-difference)){
                //已经有这个了
                if(map.containsKey(arr[i])){
                      map.put(arr[i],Math.max(map.get(arr[i]-difference)+1,map.get(arr[i])));
                  }
                else {
                    map.put(arr[i],map.get(arr[i]-difference)+1);
                }
            }
            else {
                map.put(arr[i],1);
            }
        }
        int max=0;
        for(int key:map.values()){
            max=Math.max(max,key);
        }
        return max;
    }*/



  //更简洁的做法 这么理解：之后存的不会比之前的小，只能大于或等于
    static  public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        int longest = 0;
        for(int i=0; i<arr.length; i++) {
            dp.put(arr[i], dp.getOrDefault(arr[i]-difference, 0)+1);
            longest = Math.max(longest, dp.get(arr[i]));
        }
        return longest;
    }
    public static void main(String[] args) {
        System.out.println(longestSubsequence(new int[]{1,7,8,5,3,4,2,1,5},-2));
    }
}
