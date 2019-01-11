package leetcode;

import java.util.*;

/**
 * Created by libin on 2019/1/10.
 */
public class leet438 {
    //先把匹配串排序  然后依次开始比较
    //比较时，先排序后比较     4949ms
  /*   public List<Integer> findAnagrams(String s, String p) {
        LinkedList<Integer> result=new LinkedList<>();
         char []sorterString =p.toCharArray();
             Arrays.sort(sorterString);
            String sortS= Arrays.toString(sorterString);
             int plength=p.length();
             int slength=s.length();
             for(int i=0;(i+plength)<=slength;i++) {
                 System.out.println(i);
                 char []tempS = s.substring(i,i+plength).toCharArray();
                 Arrays.sort(tempS);
                 if ( Arrays.toString(tempS).equals(sortS)) result.add(i);
             }

             return result;

    }*/
  //窗口滑动算法   17ms
  static  public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s == null||s.length() == 0||p == null||p.length()==0)
            return result;
        int[] hash = new int[256];
        char[] pp = p.toCharArray();
        for(char i:pp){
            hash[i]++;
        }
        int left = 0, right = 0, count = p.length();
        while(right < s.length())
        {
            if(hash[s.charAt(right++)]-- > 0)  //窗口右移；相应的hash值减小；如果这个位置的Hash值是正的，表示p字符串也包含这个，所以count做减法
                count--;
            if(count == 0)
                result.add(left);//count指示器，为0表示和p对应的hash值完全一致
            if(right - left == p.length() && hash[s.charAt(left++)]++ >= 0)
                //如果当窗口大小一定的时候即窗口大小和需要比较的字符串大小一致的时候，将窗口左边的指针向右边移动，移动的同时左边的字符计数因为在第一个if的地方hash值减小过，所以需要执行对应恢复操作，即：hash值增加，count计数值增加。
                count++;
        }
        return result;

    }




  //窗口滑动算法   set版本   56ms
// static    public List<Integer> findAnagrams(String s, String t) {
//        List<Integer> result = new LinkedList<>();
//        if(t.length()> s.length()) return result;
//        Map<Character, Integer> map = new HashMap<>();
//        //将t串的每个字符放到set中
//        for(char c : t.toCharArray()){
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
//        //不同字母的个数
//        int counter = map.size();
//
//        int begin = 0, end = 0;
//        int head = 0;
//        int len = Integer.MAX_VALUE;
//        //启动窗口滑动
//        while(end < s.length()){
//            //从end开始匹配
//            char c = s.charAt(end);
//            if( map.containsKey(c) ){
//                map.put(c, map.get(c)-1);
//                //该字母匹配完毕
//                if(map.get(c) == 0) counter--;
//            }
//            //指针后移
//            end++;
//
//
//            //匹配完成一个t串 ，窗口开始滑动
//            while(counter == 0){
//                char tempc = s.charAt(begin);
//                //恢复现场
//                if(map.containsKey(tempc)){
//                    map.put(tempc, map.get(tempc) + 1);
//                    if(map.get(tempc) > 0){
//                        counter++;
//                    }
//                }
//                //如果counter==0时，窗口的长度正好等于t串的查高度
//                if(end-begin == t.length()){
//                    result.add(begin);
//                }
//                //窗口前指针后移
//                begin++;
//            }
//        }
//        return result;
//    }

    public static void main(String[] args) {
        List <Integer> s=findAnagrams("cbaebabacd","abc");
        for(Integer a:s){
            System.out.print(a);
        }
    }



}
