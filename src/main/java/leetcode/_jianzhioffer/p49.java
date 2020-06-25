package leetcode._jianzhioffer;

public class p49 {
    public int nthUglyNumber(int n) {
      int i=0,j=0,k=0;
      int[]arr=new int[n];
      arr[0]=1;
      int index=1;
      while (index<n){
         int min=Math.min(arr[i]*2,Math.min(arr[j]*3,arr[k]*5));
         if(arr[i]*2==min)   i++;
         if(arr[j]*3==min)  j++;
         if(arr[k]*5==min) k++;
        arr[index++]=min;
      }
      return arr[arr.length-1];
    }
}
