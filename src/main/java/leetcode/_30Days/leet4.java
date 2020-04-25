package leetcode._30Days;

import java.util.*;

public class leet4 {
/*  static public int minJump(int[] jump) {
     int[]maxStep=new int[jump.length];
     int maxIndex=0;
     int max=0;
     int []maxTwoStep=new int[jump.length];
        for (int i = 0; i < jump.length; i++) {
            if(i+jump[i]>=max){
                max=i+jump[i];
                maxIndex=i;
            }
            maxStep[i]=maxIndex;

          maxTwoStep[i]=Math.max(maxIndex+jump[maxIndex],i+jump[i]);
        }


     int k=0;
     int count=0;
     while (k<jump.length){
         if(maxStep[k]==k){
             count++;
             k=jump[maxStep[k]]+maxStep[k];
         }
         else {
             if(k+jump[k]>=jump.length) return count+1;
             if(maxStep[k]+jump[maxStep[k]]>=jump.length) return count+2;
             int a=maxStep[k+jump[k]]+jump[maxStep[k+jump[k]]];
             int b=maxStep[k]+jump[maxStep[k]];

             if(maxStep[k+jump[k]]+jump[maxStep[k+jump[k]]]<=maxStep[k]+jump[maxStep[k]]){
                 k=jump[maxStep[k]]+maxStep[k];
                 count+=2;
             }else {
                 k+=jump[k];
                 count++;
             }

         }

     }
     return count;

    }*/

//TLE 40/41
static public int minJump(int[] jump) {
    Queue<Integer>queue=new LinkedList<>();
    queue.add(0);
    Set<Integer> visited=new HashSet<>();


    int minIndex=0;
    int step=0;
    while (!queue.isEmpty()){
        int size=queue.size();
        step++;
        while (size-->0){
            int index=queue.poll();
            if(index+jump[index]>=jump.length) return step;
            for(int i=minIndex;i<index;i++){
                 if(!visited.contains(i)){
                     queue.add(i); visited.add(i);
                 }

            }

            if(!visited.contains(index+jump[index])){
                visited.add(index+jump[index]);
                queue.add(index+jump[index]);
            }


            minIndex=index+1;

        }
    }
    return -1;
}
    public static void main(String[] args) {
        minJump(new int[]{2, 5, 1, 1, 1, 1});
    }
}
