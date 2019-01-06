package leetcode;

/**
 * Created by libin on 2017/9/17.
 */
public class leet520 {
    public boolean detectCapitalUse(String word) {
    int up=0;
    int low=0;

      if(word.charAt(0)>64&&word.charAt(0)<91) {
          for (int i = 1; i < word.length(); i++) {
              if (word.charAt(i) > 64 && word.charAt(i) < 91) up++;
              else low++;
          }
          if(up==0||low==0) return true;
          else return false;
      }
        if(word.charAt(0)>96&&word.charAt(0)<123){
            for (int i = 1; i < word.length(); i++)
                if (word.charAt(i) < 96 || word.charAt(i) > 123)  return false;
        }
        return true;
    }

}
