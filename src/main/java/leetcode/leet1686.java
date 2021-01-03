package leetcode;

import java.util.Arrays;

public class leet1686  {


    //此种贪心不行
/*    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int [][]dis=new int[aliceValues.length][2];

        for (int i = 0; i < dis.length; i++) {
            dis[i][0]=aliceValues[i]-bobValues[i];
            dis[i][1]=i;
        }

        Arrays.sort(dis,(a, b)->a[0]-b[0]);

        int a=0;int b=0;
        int left=0,right=dis.length-1;

        while (left<=right){
            //a取值
            int l=dis[left][0];
            int r=dis[right][0];
            if(Math.abs(l)<=Math.abs(r)){
                a+=aliceValues[dis[right][1]];
                right--;

            }else {
                a+=aliceValues[dis[left][1]];
                left++;
            }
            if(right<left) break;
            //b取
            l=dis[left][0];
            r=dis[right][0];
            if(Math.abs(l)>=Math.abs(r)){
                b+=bobValues[dis[left][1]];
                left++;
            }else {
                b+=bobValues[dis[right][1]];
                right--;
            }
        }

        if(a>b){
            return 1;
        }else if(a<b){
            return -1;
        }else {
            return 0;
        }
    }*/

    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int [][]dis=new int[aliceValues.length][2];

        for (int i = 0; i < dis.length; i++) {
            dis[i][0]=aliceValues[i]+bobValues[i];
            dis[i][1]=i;
        }

        Arrays.sort(dis,(a, b)->-a[0]+b[0]);
        int a=0,b=0;
        for (int i = 0; i < dis.length; i++) {
            if(i%2==0){
             a+=aliceValues[dis[i][1]];
            }else {
              b+=bobValues[dis[i][1]];
            }
        }
        if(a>b){
            return 1;
        }else if(a<b){
            return -1;
        }else {
            return 0;
        }
    }
}
