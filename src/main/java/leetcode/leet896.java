package leetcode;

/**
 * Created by libin on 2018/12/31.
 */
public class leet896 {
   static public boolean isMonotonic(int[] A) {
        int up=0;
        int down=0;
        for(int i=1;i<A.length;i++){
        if(down==1&&up==1)return false;
            if (A[i-1]>A[i])  down=1;
            else  if(A[i-1]<A[i]) up=1;
            else continue;
        }
       if(down==1&&up==1)return false;
       else return true;



    }

    public static void main(String[] args) {
        System.out.println(isMonotonic(new int []{6,5,4,4}));
    }
}
