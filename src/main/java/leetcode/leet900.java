package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class leet900 {

    class RLEIterator {

        Queue<Integer[]>queue=new LinkedList<>();
        public RLEIterator(int[] A) {
            for (int i = 0; i < A.length; i+=2) {
                queue.add(new Integer[]{A[i],A[i+1]});
            }
        }

        public int next(int n) {

            while (!queue.isEmpty()){
            Integer []a=queue.peek();
            if(a[0]==0){
                queue.poll();
                continue;
            }
            if(a[0]<n){
                n-=a[0];
                queue.poll();
                continue;
            }else {
                a[0]-=n;
                return  a[1];
            }

            }
            return -1;

         /*   while (n-->0&&!queue.isEmpty()){

                if(a[0]==0) {
                    n++;
                    queue.poll();
                }else {
                    a[0]--;
                    res=a[1];
                }
            }*/

        }
    }

    //或者不需要用额外的存储空间
/*    class RLEIterator {
        int index;
        int [] A;
        public RLEIterator(int[] A) {
            this.A = A;
            index = 0;
        }

        public int next(int n) {
            while(index < A.length && n > A[index]){
                n = n - A[index];
                index += 2;
            }

            if(index >= A.length){
                return -1;
            }

            A[index] = A[index] - n;
            return A[index + 1];
        }
    }*/

}




