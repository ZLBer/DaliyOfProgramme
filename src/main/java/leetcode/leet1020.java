package leetcode;

/**
 * Created by libin on 2019/3/27.
 */
public class leet1020 {
    public boolean canThreePartsEqualSum(int[] A) {
       int sum=0;
        for(int a:A){
sum+=a;
       }
       int subThree=sum/3;
       if(subThree*3!=sum) return false;


       int temp=0;
       int count=0;
       for(int i=0;i<A.length;i++){
        temp+=A[i];

        if(temp==0) {
            temp=0;
            count++;
        }

       }

       if(count==3) return true;
        else return false;


    }
}
