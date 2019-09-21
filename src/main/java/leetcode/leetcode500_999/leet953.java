package leetcode.leetcode500_999;

/**
 * Created by libin on 2019/1/21.
 */
public class leet953 {


    //mine  就是依次比较相邻单词
    public boolean isAlienSorted(String[] words, String order) {

        for(int i=1;i<words.length;i++){
            for(int j=0;j<words[i-1].length();j++){
                System.out.println(j);
                      if(j>=words[i].length()) return false;
                  int alpthA=words[i-1].charAt(j);
                  int alpthB=words[i].charAt(j);
                  if(alpthA==alpthB) continue;
                  boolean flag=false;
                  for(int c=0;c<order.length();c++){
                     if(order.charAt(c)==alpthB) return false;
                     if (order.charAt(c)==alpthA){
                         flag=true;
                         break;
                     }
                     if(flag) break;
                  }
            }
        }
           return true;
    }


//先映射再比较
/*
    int[] mapping = new int[26];
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.length(); i++)
            mapping[order.charAt(i) - 'a'] = i;
        for (int i = 1; i < words.length; i++)
            if (compare(words[i - 1], words[i]) > 0)
                return false;
        return true;
    }

    int compare(String s1, String s2) {
        int n = s1.length(), m = s2.length(), cmp = 0;
        for (int i = 0, j = 0; i < n && j < m && cmp == 0; i++, j++) {
            cmp = mapping[s1.charAt(i) - 'a'] - mapping[s2.charAt(j) - 'a'];
        }
        return cmp == 0 ? n - m : cmp;
    }*/
}
