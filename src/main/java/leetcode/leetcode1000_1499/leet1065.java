package leetcode.leetcode1000_1499;

import java.util.*;

public class leet1065 {
    //太坑了 还必须按顺序来
    public int[][] indexPairs(String text, String[] words) {
        List<int[]> list=new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
             String temp=text;
             int seat=temp.indexOf(words[i]);
             int sublength=0;
             while (seat>=0){
                 list.add(new  int[]{sublength+seat,sublength+seat+words[i].length()-1});
                 temp=temp.substring(seat+1);
                 sublength+=seat+1;
                 seat=temp.indexOf(words[i]);
             }
        }
        Collections.sort(list, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            else return a[1] - b[1];
        });
        int[][]result=new int[list.size()][2];
        int count=0;
        for (int i = 0; i < list.size(); i++) {
            result[count++]=list.get(i);
        }
        return result;
    }


}
