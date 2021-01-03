package leetcode;

import java.util.Arrays;

public class leet01 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int res=0;
        Arrays.sort(boxTypes,(a,b)->b[1]-a[1]);
        int count=0;
        for (int i = 0; i < boxTypes.length; i++) {
           if(count+boxTypes[i][0]<=truckSize){
              count+=boxTypes[i][0];
              res+=(boxTypes[i][0]*boxTypes[i][1]);
           }else {
              int del=truckSize-count;
              count+=del;
              res+=(boxTypes[i][1]*del);
              break;
           }
        }
        return res;
    }



}
