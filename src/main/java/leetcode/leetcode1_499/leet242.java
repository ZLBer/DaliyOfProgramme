package leetcode.leetcode1_499;

/**
 * Created by libin on 2019/2/18.
 */
public class leet242 {
    //第一版
   /* public boolean isAnagram(String s, String t) {
     if(s.length()!=t.length()) return false;
     HashMap<Character,Integer> yx=new HashMap<>();
        //获取映射
     for(int i=0;i<s.length();i++){
             yx.put(s.charAt(i),yx.getOrDefault(s.charAt(i),0)+1);
     }
        for(int i=0;i<t.length();i++) {
          //  System.out.println(i);
         //   System.out.println(yx.getOrDefault(t.charAt(i),0));
      if(yx.getOrDefault(t.charAt(i),0)==0)  return false;
      else yx.put(t.charAt(i),yx.get(t.charAt(i))-1);
        }
        return true;
    }*/
    //第二版
/*    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character,Integer> yx=new HashMap<>();
        //获取映射
        for(int i=0;i<s.length();i++){
            char a=s.charAt(i);
            yx.put(a,yx.getOrDefault(a,0)+1);
        }
        for(int i=0;i<t.length();i++) {
            char a=t.charAt(i);
            if(yx.getOrDefault(a,0)==0)  return false;
            else yx.put(a,yx.get(a)-1);
        }
        return true;
    }*/

//用数组代替map ，肯定更快
    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }


}
