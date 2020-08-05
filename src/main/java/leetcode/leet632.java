package leetcode;

import java.util.List;
import java.util.PriorityQueue;

public class leet632 {

    //注意是k个
/*    public int[] smallestRange(List<List<Integer>> nums) {
           int i=nums.get(0).size()-1,j=nums.get(1).size()-1,k=nums.get(2).size()-1;
           int low=0;
           int high=Integer.MAX_VALUE;
     while (i>=0||j>=0||k>=0){
     int a=nums.get(0).get(i);
     int b=nums.get(1).get(j);
     int c=nums.get(2).get(k);
     boolean flag=false;
         int tlow=0;
         int thigh=Integer.MAX_VALUE;
     if(a>=b&&a>=c&&i>0){
        tlow=Math.min(b,c);
        thigh=a;
        i--;
        flag=true;
     }else if(b>=a&&b>=c&&j>0){
        tlow=Math.min(a,c);
        thigh=b;
         j--;
         flag=true;
     }else if(k>0){
       tlow=Math.min(a,b);
       thigh=c;
       k--;
         flag=true;
     }
    if(thigh-tlow<high-low){
       high=thigh;
       low=tlow;
    }
    if(!flag) break;
     }
     int tmax=Math.max(nums.get(0).get(i),Math.max(nums.get(1).get(j),nums.get(2).get(k)));
     int tmin=Math.min(nums.get(0).get(i),Math.min(nums.get(1).get(j),nums.get(2).get(k)));
     if(tmax-tmin<=high-low){
        high=tmax;
        low=tmin;
     }
      return new int[]{low,high};
    }*/

// 和上面的思路一样  改成k路而已
    public int[] smallestRange(List<List<Integer>> nums) {
      int low=0;
      int high=Integer.MAX_VALUE;
        PriorityQueue<int []> priorityQueue=new PriorityQueue<>((int []a,int []b)->a[2]-b[2]);
        int max=0;
        for (int i = 0; i < nums.size(); i++) {
        int num=nums.get(i).get(0);
        priorityQueue.add(new int[]{i,0,num});
        max=Math.max(max,num);
        }
        while (priorityQueue.size()==nums.size()){
         int []index=priorityQueue.poll();
         int tlow=index[2];
         int thigh=max;
         if(high-low>thigh-tlow){
            high=thigh;
            low=tlow;
         }
       if(index[1]+1<nums.get(index[0]).size()){
           int n=nums.get(index[0]).get(index[1]+1);
           priorityQueue.add(new int[]{index[0],index[1]+1,n});
          max=Math.max(n,max);
       }
        }

       return new int[]{low,high};
    }



    public static void main(String[] args) {

    }
}
