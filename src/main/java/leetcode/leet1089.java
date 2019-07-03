package leetcode;

public class leet1089 {
/*    public void duplicateZeros(int[] arr) {
     int []result=new int[arr.length];
     int i=0,j=0;
     while (j<result.length&&i<arr.length){
         if(arr[i]==0){
             result[j++]=0;
             if(j<result.length)
                result[j++]=0;
         }
         else {
             result[j++]=arr[i];
         }
         i++;
     }
     
        for(i=0;i<result.length;i++){
            arr[i]=result[i];
        }
    }*/

    // 不用额外的空间消耗
    public void duplicateZeros(int[] arr) {
        int zero=0;
        for(int i:arr){
            if(i==0) zero++;
        }
        int j=zero+arr.length;
        int i=arr.length-1;

        for(;i>=0;i--,j--){
            if(arr[i]!=0){
                if(j<arr.length) arr[j]=arr[i];
            }
            else {
                 if(j<arr.length) arr[j]=0;
                 j--;
                 if(j<arr.length) arr[j]=0;
            }
        }
    }
}
