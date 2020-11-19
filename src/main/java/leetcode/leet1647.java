package leetcode;

import java.util.HashSet;
import java.util.Set;

public class leet1647 {
    public int minDeletions(String s) {
      int []arr=new int[26];
        for (char c : s.toCharArray()) {
            arr[c-'a']++;
        }

        int res=0;
        Set<Integer> set=new HashSet<>();
        for (int i : arr) {


          while (set.contains(i)&&i!=0){
              i--;
              res++;
          }
            if(i==0)continue;
           set.add(i);
        }
       return res;

    }
}
