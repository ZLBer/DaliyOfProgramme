package leetcode.leetcode1000_;

public class leet1347 {
    //mine haskmap
/*    public int minSteps(String s, String t) {
      Map<Character,Integer> map=new HashMap<>();
      for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
      int res=0;
      for(char c:t.toCharArray()){
           if(map.containsKey(c)&&map.get(c)>0){
               map.put(c,map.get(c)-1);
           }else res++;
      }
      return res;
    }*/
    //mine 数组
    public int minSteps(String s, String t) {
     int[] arr=new int[26];
        for(char c:s.toCharArray()){
           arr[c-'a']++;
        }
        int res=0;
        for(char c:t.toCharArray()){
           if(arr[c-'a']>0){
               arr[c-'a']--;
           }else {
               res++;
           }
        }
        return res;
    }
}
