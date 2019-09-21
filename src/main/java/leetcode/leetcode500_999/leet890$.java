package leetcode.leetcode500_999;

import java.util.*;

/**
 * Created by libin on 2019/1/16.
 */
public class leet890$ {
    //错误的理解成双映射
/*  static   public List<String> findAndReplacePattern(String[] words, String pattern) {
           List<String>  result= new LinkedList<>();
         for(String a: words){
             Map<Character,Character> map=new HashMap<>();
             boolean flag=true;
             for(int i=0;i<a.length();i++){
                 char k=a.charAt(i);
                 char v=pattern.charAt(i);
                 if(!map.containsKey(k)&&!map.containsKey(v)) {
                     map.put(k,v);
                     map.put(v,k);
                 }
                 else  if((map.containsKey(k)&&map.get(k)!=v)||(map.containsKey(v)&&map.get(v)!=k)) flag=false;
             }
          if(flag)  result.add(a);
         }
         return  result;
    }*/


/*static public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList();
        for (String word: words)
            if (match(word, pattern))
                ans.add(word);
        return ans;
    }

  static   public boolean match(String word, String pattern) {
        Map<Character, Character> m1 = new HashMap();
        Map<Character, Character> m2 = new HashMap();

        for (int i = 0; i < word.length(); ++i) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if (!m1.containsKey(w)) m1.put(w, p);
            if (!m2.containsKey(p)) m2.put(p, w);
            if (m1.get(w) != p || m2.get(p) != w)
                return false;
        }
        for(Map.Entry e:m1.entrySet()){
            System.out.println(e.getKey()+"    "+e.getValue());
        }
      for(Map.Entry e:m2.entrySet()){
          System.out.println(e.getKey()+"    "+e.getValue());
      }

        return true;
    }*/

    // 更优雅的做法
   static public List<String> findAndReplacePattern(String[] words, String pattern) {
        int[] p = F(pattern);
        List<String> res = new ArrayList<String>();
        for (String w : words)
            if (Arrays.equals(F(w), p)) res.add(w);
        return res;
    }


    //将w映射成位置的数组
  static   public int[] F(String w) {
        HashMap<Character, Integer> m = new HashMap<>();
        int n = w.length();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            m.putIfAbsent(w.charAt(i), m.size());
            res[i] = m.get(w.charAt(i));
        }
        return res;
    }

    public static void main(String[] args) {
        for(String a:findAndReplacePattern(new String[]{"ao" },"ya"))
            System.out.println(a);
    }
}
