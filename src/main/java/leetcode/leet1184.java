package leetcode;

import java.util.Arrays;

public class leet1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {

        int index=start;
        int pre=0;
        while (index!=destination){
           pre+=distance[index];
           index=(index+1)%distance.length;
        }
        int last=0;
        while (index!=start){
            last+=distance[index];
            index=(index+1)%distance.length;
        }
        return Math.min(pre,last);
    }
}
