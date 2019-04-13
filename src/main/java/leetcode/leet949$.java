package leetcode;

import java.util.Arrays;

/**
 * Created by libin on 2019/4/12.
 */
public class leet949$ {
    public String largestTimeFromDigits(int[] A) {
       String res="";
       for(int i=0;i<4;i++){
           for(int j=0;j<4;j++){
               for(int k=0;k<4;k++){
                  if(i==j||i==k||j==k) continue;
                   String h=""+A[i]+A[j];
                   String m=""+A[k]+A[6-i-j-k];
                   String time=h+":"+m;
                   if(h.compareTo("24")<0&&m.compareTo("60")<0&&res.compareTo(time)<0)res=time;
               }
           }
       }
       return res;
    }
}
