package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class leet1654 {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int []dp=new int[x+b];
        Set<Integer> set=new HashSet<>();
        for (int i : forbidden) {
            set.add(i);
        }
        Arrays.fill(dp,(int)1e9);
        Queue<int []> queue=new LinkedList<>();
        queue.add(new int[]{0,0});
        int step=0;
        while (!queue.isEmpty()){
            int size=queue.size();
            while (size-->0){
                int[] p=queue.poll();

                if(p[0]==x) return step;
                int foreward=p[0]+a;
                if(foreward<=x+10000&&!set.contains(foreward)){
                    set.add(foreward);
                    queue.add(new int[]{foreward,0});
                }

                int backward=p[0]-b;

                if(p[1]!=-1&&backward>0&&!set.contains(backward)) {
                    // set.add(backward);
                    queue.add(new int[]{backward,-1});
                }

            }
            step++;

        }
        return -1;
    }
}
