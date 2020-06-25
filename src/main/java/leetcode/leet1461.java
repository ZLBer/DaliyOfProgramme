package leetcode;

import java.util.HashSet;
import java.util.Set;

public class leet1461 {
    //mine
/*    public boolean hasAllCodes(String s, int k) {
     boolean[] arr=new boolean[(1<<k)-1];
        for (int i = 0; i <= s.length()-k; i++) {
          arr[Integer.parseInt(s.substring(i,i+k),2)]=true;
        }
        for (boolean b : arr) {
            if(!b) return false;
        }
        return true;
    }*/

    public boolean hasAllCodes(String s, int k) {
        Set<String> set=new HashSet<>();
        for (int i = 0; i <= s.length()-k; i++) {
            set.add(s.substring(i,i+k));
        }
      if(set.size()==(1<<k))return true;
      else return false;
    }
}
