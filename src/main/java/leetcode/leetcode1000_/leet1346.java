package leetcode.leetcode1000_;

import java.util.HashSet;
import java.util.Set;

public class leet1346 {
    //mine 暴力
  /*  public boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]==2*arr[i]||arr[i]==2*arr[j]) return true;
            }
        }
        return false;
    }*/
    //mine hash
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i]/2)||set.contains(arr[i]*2)) return true;
            set.add(arr[i]);
         }
        return false;
       }
    }
