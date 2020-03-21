package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leet916 {

    //mine 就数组统计然后比较

    public List<String> wordSubsets(String[] A, String[] B) {
        int []countB=new int[26];
        for (int i = 0; i < B.length; i++) {
            int []temp=new int[26];
            for(char c:B[i].toCharArray()){
               temp[c-'a']++;
            }
            for (int j = 0; j < countB.length; j++) {
                countB[j]=Math.max(countB[j],temp[j]);
            }
        }
        List<String> res=new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            int []countA=new int[26];
            for(char c:A[i].toCharArray()){
                countA[c-'a']++;
            }
            boolean breakFlag=false;
            for (int j = 0; j < countB.length; j++) {
                if(countB[j]>countA[j]){
                    breakFlag=true;
                    break;
                }
            }
            if(!breakFlag) res.add(A[i]);
        }
        return res;
    }


    //一样的思路  代码好点
  /*  public List<String> wordSubsets(String[] A, String[] B) {
        int[] count = new int[26], tmp;
        int i;
        for (String b : B) {
            tmp = counter(b);
            for (i = 0; i < 26; ++i)
                count[i] = Math.max(count[i], tmp[i]);
        }
        List<String> res = new ArrayList<>();
        for (String a : A) {
            tmp = counter(a);
            for (i = 0; i < 26; ++i)
                if (tmp[i] < count[i])
                    break;
            if (i == 26) res.add(a);
        }
        return res;
    }

    int[] counter(String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) count[c - 'a']++;
        return count;
    }*/
}
