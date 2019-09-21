package leetcode.leetcode500_999;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leet859 {
    //mine
    public boolean buddyStrings(String A, String B) {
        if(A.length()!=B.length()) return false;
      char []charA=A.toCharArray();
      char []charB=B.toCharArray();
      boolean flag=false;//是否有重复字母
        List<Character> list=new ArrayList<>();
        Set<Character> set=new HashSet<>();
    for(int i=0;i<A.length();i++){
        if(set.contains(charA[i])){
            flag=true;
        }
        set.add(charA[i]);
        if(charA[i]!=charB[i]) {
            list.add(charA[i]);
            list.add(charB[i]);
        }
    }
    if(list.size()==0&&flag) return true;
    else if(list.size()!=4) return false;
    else if(list.get(0)==list.get(3)&&list.get(1)==list.get(2))return true;
    return false;
          }


  //想法一样  实现不一样
  /*  public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.equals(B)) {
            Set<Character> s = new HashSet<Character>();
            for (char c : A.toCharArray()) s.add(c);
            return s.size() < A.length();
        }
        List<Integer> dif = new ArrayList<>();
        for (int i = 0; i < A.length(); ++i) if (A.charAt(i) != B.charAt(i)) dif.add(i);
        return dif.size() == 2 && A.charAt(dif.get(0)) == B.charAt(dif.get(1)) && A.charAt(dif.get(1)) == B.charAt(dif.get(0));
    }*/
}
