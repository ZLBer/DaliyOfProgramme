package leetcode;

import java.util.Arrays;

/**
 * Created by libin on 2019/2/27.
 */
public class leet455 {
    //mine 贪心法
    public int findContentChildren(int[] g, int[] s) {
      int i=0,j=0;
      Arrays.sort(g);
        Arrays.sort(s);
      while (i<g.length&&j<s.length){

          if(g[i]<=s[j]){
              i++;
              j++;
          }else {
              j++;
          }


      }

      return i;
    }
}
