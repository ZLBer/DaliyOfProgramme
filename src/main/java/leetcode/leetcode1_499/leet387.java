package leetcode.leetcode1_499;

/**
 * Created by libin on 2019/1/7.
 */
public class leet387 {
   static public int firstUniqChar(String s) {
       if(s.length()==0) return -1;
        int []flag= new int[26];
        for(int i=0;i<s.length();i++){
            if(flag[s.charAt(i)-'a']==0)  flag[s.charAt(i)-'a']=i+1;
            else if(flag[s.charAt(i)-'a']>0)  flag[s.charAt(i)-'a']=-1;
            else continue;
        }
        int reIndex=Integer.MAX_VALUE;
        for(int a:flag){
      //      System.out.println(a);
               if(a>0&&a<reIndex) reIndex=a;
        }
        if(reIndex==Integer.MAX_VALUE) return -1;
return reIndex-1;
    }
   //先求得每个字母的频率，然后在从头遍历s，freq==1则是最靠左的元素
/*    public int firstUniqChar(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }*/


    //用set和map做，每次将不存在的置于set和map里，将存在的从map里删除
  /*  public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                if (map.get(s.charAt(i)) != null) {
                    map.remove(s.charAt(i));
                }
            } else {
                map.put(s.charAt(i), i);
                set.add(s.charAt(i));
            }
        }
        return map.size() == 0 ? -1 : map.entrySet().iterator().next().getValue();
    }*/

    public static void main(String[] args) {
        System.out.println(firstUniqChar("dabbcb"));
    }
}
