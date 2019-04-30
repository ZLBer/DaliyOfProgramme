package leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by libin on 2019/1/6.
 */
public class leet893$ {
    public int numSpecialEquivGroups(String[] A) {
        HashSet<String> set=new HashSet<>();
        for(String s:A){
            //看成奇数位置是一组，偶数位置是一组。
          int[] even =new int[26];
            int[] odd =new int[26];
          for(int i=0;i<s.length();i++){
              if(i%2==1) odd[s.charAt(i)-'a']++;
              else even[s.charAt(i)-'a']++;
          }

          String sig= Arrays.toString(odd)+Arrays.toString(even);
          set.add(sig);

        }
        return  set.size();


    }
}
