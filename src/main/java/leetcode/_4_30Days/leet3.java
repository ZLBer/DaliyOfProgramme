package leetcode._4_30Days;

import java.util.Arrays;
import java.util.TreeSet;

public class leet3 {
    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
     int C=0,R=0,H=0;
     int []res=new int[requirements.length];
        Arrays.fill(res,-1);
        TreeSet<Integer> set=new TreeSet<>();
        int [][]sortRequirements=new int[requirements.length][2];
        for (int i = 0; i < sortRequirements.length; i++) {
            sortRequirements[i][0]=(requirements[i][0]+requirements[i][1]+requirements[i][2]);
            sortRequirements[i][1]=i;
            set.add(i);
        }
        Arrays.sort(sortRequirements,(a,b)->a[0]-b[0]);



        for (int i = 0; i < requirements.length; i++) {
                if(sortRequirements[i][0]>C+R+H) break;
                int index=sortRequirements[i][1];
                if(res[index]!=-1) continue;
                if(requirements[index][0]<=C&&requirements[index][1]<=R&&requirements[index][2]<=H){
                    res[index]=0;
                  set.remove(i);
                }

        }
        for (int j = 0; j < increase.length; j++) {
            C+=increase[j][0];
            R+=increase[j][1];
            H+=increase[j][2];
         if(set.isEmpty() ) return res;
            for (int i = set.first(); i < requirements.length; i++) {
                if(sortRequirements[i][0]>C+R+H) break;
                int index=sortRequirements[i][1];
                if(res[index]!=-1) continue;
                if(requirements[index][0]<=C&&requirements[index][1]<=R&&requirements[index][2]<=H){
                    res[index]=j+1;
               set.remove(i);
                }

            }
        }
        return res;
    }
}
