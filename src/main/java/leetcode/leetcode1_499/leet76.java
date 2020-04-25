package leetcode.leetcode1_499;


public class leet76 {


    //mine 就典型的滑动窗口
/*
  static   public String minWindow(String s, String t) {
      int left=0,right=0;
      Map<Character,Integer> map=new HashMap<>();
      Map<Character,Integer> expect=new HashMap<>();

for(int i=0;i<t.length();i++){
    char c=t.charAt(i);
    expect.put(c,expect.getOrDefault(c,0)+1);
}


int min=Integer.MAX_VALUE;
String res=""; int count=0;
      while (left+t.length()<=s.length()){


       while (right<s.length()&&count<expect.size()){
           char c=s.charAt(right++);
           map.put(c,map.getOrDefault(c,0)+1);
          int val=map.get(c);
         if(expect.containsKey(c)&&val==expect.get(c)) count++;
       }

    if(right-left<min&&count==expect.size()){
        min=right-left;
        res=s.substring(left,right);
    }
    char c=s.charAt(left++);
    map.put(c,map.get(c)-1);
    int val=map.get(c);
    if(expect.containsKey(c)&&val<expect.get(c)){
        count--;
    }
      }
return res;
         }
*/


    //用数组代替map
    //这种滑动看的清楚点
    public String minWindow(String s, String t) {
        int [] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
        while (end < s.length()) {
            final char c1 = s.charAt(end);
            //不能用=0判断 因为有多余的字符用负数表示
            if (map[c1] > 0) counter--;
            map[c1]--;
            end++;
            while (counter == 0) {
                if (minLen > end - start) {
                    minLen = end - start;
                    minStart = start;
                }
                final char c2 = s.charAt(start);
                map[c2]++;
                //同样不能用0判断
                if (map[c2] > 0) counter++;
                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
    public static void main(String[] args) {
     //   minWindow("ADOBECODEBANC", "ABC");
    }
}
