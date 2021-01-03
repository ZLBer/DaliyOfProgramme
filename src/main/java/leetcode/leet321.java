package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class leet321 {
/*  static   public int[] maxNumber(int[] nums1, int[] nums2, int k) {


        PriorityQueue<int[]>priorityQueue=new PriorityQueue<>((a,b)->b[0]-a[0]);

        for (int i = 0; i < nums1.length; i++) {
            priorityQueue.add(new int[]{nums1[i],0,i});
        }
        for (int i = 0; i < nums2.length; i++) {
            priorityQueue.add(new int[]{nums2[i],1,i});
        }

     int []res=new int[k];
     int index1=-1,index2=-1;
      for(int i=0;i<k;i++){
        int []p=priorityQueue.poll();
          System.out.println(p[0]);
        while (!priorityQueue.isEmpty()&&((p[1]==0&&p[2]<index1)||(p[1]==1&&p[2]<index2))){
           p= priorityQueue.poll();
        }



      if(p[1]==0){
          //剩下的要可一组成k个
          if(nums1.length-p[2]-1+nums2.length-index2-1<k-i) {
            i--; continue;
          }
         index1=p[2];
      }else {
          if(nums1.length-index1-1+nums2.length-p[2]-1<k-i) {
              i--; continue;
          }
        index2=p[2];
      }

     res[i]=p[0];
      }
      return res;
    }*/

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

     int start=Math.max(k-nums2.length,0),end=Math.min(nums1.length,k);
   int []maxSub=new int[k];
      //两个数组分别贡献x y个序列
   for(int x=start;x<=end;x++){
       System.out.println(x+" "+(k-x));
      int []subl=maxSub(nums1,x);
      int []sub2=maxSub(nums2,k-x);
       System.out.println(subl.length+" "+sub2.length);
    int []mer=merge(subl,sub2);
    if(compare(mer,maxSub)){
        maxSub=mer;
    }
   }
   return maxSub;
    }

  static   int [] maxSub(int []arr,int len){
        Deque<Integer> deque=new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            while (!deque.isEmpty()&&arr.length-i>len-deque.size()&&deque.peekLast()<arr[i]){
                deque.pollLast();
            }
           if(deque.size()<len){
               deque.addLast(arr[i]);
           }
        }
        
      return   deque.stream().mapToInt(a->a).toArray();
    }

    public static void main(String[] args) {
        maxSub(new int[]{6,7},2);
    }

   int []merge(int []arr1,int []arr2){
     int []res=new int[arr1.length+arr2.length];
     int l=0,r=0;
     int i=0;
     for(;l<arr1.length&&r<arr2.length&&i<res.length;i++){
       if(arr1[l]<arr2[r]){
           res[i]=arr2[r++];
       }else if(arr1[1]>arr2[r]){
           res[i]=arr1[l++];
       }else {
           if(compare(arr1,l,arr2,r)){
               res[i]=arr1[l++];
           }else {
               res[i]=arr2[r++];
           }
         }
     }

    while (l<arr1.length){
        res[i++]=arr1[l++];
    }
    while (r<arr2.length){
        res[i++]=arr2[r++];
    }
     return res;
   }

   boolean compare(int []arr1,int []arr2){
       for (int i = 0; i < arr1.length; i++) {
           if(arr1[i]>arr2[i]){
               return true;
           }else if(arr1[i]<arr2[i]){
               return false;
           }
       }
      return false;
   }

   boolean compare(int []arr1,int index1,int []arr2,int index2){
       while (index1<arr1.length&&index2<arr2.length){
           if(arr1[index1]==arr2[index2]){
               index1++;index2++;
           }else if(arr1[index1]>arr2[index1]){
               return true;
           }else {
               return false;
           }
       }
       return index1<arr1.length;
   }
}
