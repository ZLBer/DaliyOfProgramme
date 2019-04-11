package leetcode;

/**
 * Created by libin on 2019/4/10.
 */
public class leet985 {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
         int [] result=new int[A.length];
         int sumEven=0;
        for (int i=0;i<A.length ;i++) {
             if(A[i]%2==0) {
                 sumEven+=A[i];
             }
        }
        System.out.println(sumEven);
        for (int i = 0; i < queries.length; i++) {
          int temp=  A[queries[i][1]];
            System.out.println("temp"+temp);
            if(temp%2==0&&(temp+queries[i][0])%2==0){
                sumEven+=queries[i][0];
            }else if(temp%2==0){
                sumEven-=temp;

            }else if((temp+queries[i][0])%2==0){

                sumEven+=(temp+queries[i][0]);

            }
         A[queries[i][1]]+=queries[i][0];
        result[i]=sumEven;
        }
        return result;
    }
}
