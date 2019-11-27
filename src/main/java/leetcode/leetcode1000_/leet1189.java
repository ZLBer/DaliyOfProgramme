package leetcode.leetcode1000_;

public class leet1189 {

    //mine straightforward
 /*   public int maxNumberOfBalloons(String text) {
      int[] letters=new int[26];
      for (char c:text.toCharArray()){
          letters[c-'a']++;
      }

      int result=0;
      while (letters['b'-'a']>=1&&letters['a'-'a']>=1&&letters['l'-'a']>=2&&letters['o'-'a']>=2&&letters['n'-'a']>=1){
          letters['b'-'a']-=1;
          letters['a'-'a']-=1;
          letters['l'-'a']-=2;
          letters['o'-'a']-=2;
          letters['n'-'a']-=1;
          result++;
      }
return result;
    }*/


    public int maxNumberOfBalloons(String text) {
        int[] chars = new int[26]; //count all letters
        for (char c : text.toCharArray()) {
            chars[c - 'a']++;
        }
        int min = chars[1];//for b
        min = Math.min(min, chars[0]);//for a
        min = Math.min(min, chars[11] / 2);// for l /2
        min = Math.min(min, chars[14] / 2);//similarly for o/2
        min = Math.min(min, chars[13]);//for n
        return min;
    }
}
