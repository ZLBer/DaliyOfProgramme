package leetcode.leetcode1000_;

import java.util.HashMap;

public class leet1297 {

    //mine 暴力即可
 /*   public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int maxCount=0;
        String maxString="";
        for(int length=minSize;length<=maxSize;length++){
            Map<String,Integer> map=new HashMap<>();
           for(int begin=0;begin+length<=s.length();begin++){
               String key=s.substring(begin,begin+length);
               map.put(key,map.getOrDefault(key,0)+1);
           }

           for(Map.Entry<String,Integer> e:map.entrySet()){
               if(e.getValue()>maxCount&&check(e.getKey(),maxLetters)){
                   maxCount=e.getValue();
               }
           }
        }
          return maxCount;
    }
    boolean check(String s,int maxLetters){
        Set<Character> set=new HashSet<>();
        for(char c:s.toCharArray()){
            set.add(c);
        }
        if(set.size()>maxLetters)
            return false;
        else return true;
    }*/


   // sliding window
    //证明maxSize是没用的  可以直接用minSize来滑动窗口
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<String,Integer> map=new HashMap<>();
        int res=0;
        int[] ch=new int[128];
        //lettter表示不同字母的个数
        int l=0, r=0, letter=0;
        while(r<s.length()){
            if(ch[s.charAt(r++)]++==0) letter++;
            //额外过滤了一种情况
            while(letter>maxLetters || (r-l)>minSize){

                if(ch[s.charAt(l++)]--==1) letter--;
            }
            //正好等于minSize
            if((r-l)==minSize){
                String sb=s.substring(l, r);
                //统计次数
                map.put(sb, map.getOrDefault(sb,0)+1);
                res=Math.max(res, map.get(sb));
            }
        }
        return res;
    }
}
