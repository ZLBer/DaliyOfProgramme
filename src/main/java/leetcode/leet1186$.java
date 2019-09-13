package leetcode;

public class leet1186$ {
 /*  static public int maximumSum(int[] arr) {
  int[]dp=new int[arr.length+1];
  int max=Integer.MIN_VALUE;
  int deletion=0;
        for (int i = 1; i <= arr.length; i++) {
           if(dp[i-1]-deletion<=0){
               dp[i]=arr[i-1];
               deletion=0;
           }
           else{
               dp[i]=dp[i-1]+arr[i-1];
               deletion=Math.min(arr[i-1],deletion);
           }

           if(deletion<0){
               max=Math.max(max,dp[i]-deletion);
               System.out.println(max);
           }
           else {
            max=Math.max(max,dp[i]);
            System.out.println(max);
        }

        }
        return max;
    }
*/

    static  public int maximumSum(int[] arr) {
int []forward=new int[arr.length];
int []backward=new int[arr.length];
int max=arr[0];
forward[0]=arr[0];
for(int i=1;i<arr.length;i++){
    forward[i]=Math.max(arr[i],forward[i-1]+arr[i]);
    max=Math.max(max,forward[i]);
}

backward[arr.length-1]=arr[arr.length-1];
for(int i=arr.length-1;i>0;i--){
    backward[i-1]=Math.max(arr[i-1],backward[i]+arr[i-1]);
}

for(int i=1;i<arr.length-1;i++){
    max=Math.max(forward[i-1]+backward[i+1],max);
}
return max;
    }
    public static void main(String[] args) {
        maximumSum(new int[]{11,-10,-11,8,7,-6,9,4,11,6,5,0});
    }
}
