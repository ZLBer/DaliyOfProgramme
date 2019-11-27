package leetcode.leetcode500_999;

import java.util.Arrays;

public class leet621$ {
    public int leastInterval(char[] tasks, int n) {
       int[] count=new int[26];
        for (char task : tasks) {
            count[task-'A']++;
        }
        Arrays.sort(count);
        int maxCount=count[25];
        int res=(count[25]-1)*(n+1)+1;
        for(int i=24;i>=0;i--){
            if(count[i]==maxCount) res++;
        }
        return Math.max(res,tasks.length);
    }
}
