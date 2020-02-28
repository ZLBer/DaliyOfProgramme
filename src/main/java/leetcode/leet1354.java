package leetcode;

import java.util.PriorityQueue;

public class leet1354 {

    //mine tle  参考别人的才不TLE  要注意很多细节  从减号改成求余  还得用long来存储防止TLE
    public boolean isPossible(int[] target) {
        if(target.length==1){
            if(target[0]==1)return true;
            else return false;
        }
        PriorityQueue<Long> queue=new PriorityQueue<>((a,b)->(int)(b-a));
        long sum=0;
        for (int i = 0; i < target.length; i++) {
            queue.add((long)target[i]);
            sum+=target[i];
        }
        while (queue.peek()>1){
            long a=queue.poll();
            long tsum=sum-a;
            System.out.println("a "+a+"  "+tsum);
            if(a<=tsum) return false;
            if(tsum==1) return true;
            a%=tsum;
            if(a<=0)
                return false;
            queue.offer(a);
            sum=tsum+a;

        }
        return true;

    }


    //别人的
/*
    public boolean isPossible(int[] t) {
    if(t.length==1){
            if(t[0]==1)return true;
            else return false;
        }
        long sum = 0;
        Queue<Long> pq = new PriorityQueue<Long>((a, b) ->{return (int) (b - a);});
        for (int a : t) {
            pq.offer((long)a);
            sum += a;
        }

        while(!pq.isEmpty()) {
            long i = pq.poll();
            sum -= i;

            if(i == 1 // all 1
                    || sum == 1) { // [1, i], will always be true;
                return true;
            }

            if (i < sum) return false; //负数情况

            i %= sum; // find the positive num.

            //i = a positive num + sum;
            if (i == 0) {
                return false;
            }

            sum += i;
            pq.offer(i);
        }

        return true;
    }
*/
  //不用pq
   /* public boolean isPossible(int[] A) {
        if(A.length==1){
            if(A[0]==1)return true;
            else return false;
        }
        long total = 0;
        int n = A.length;
        for (int a: A)
            total += a;
        Arrays.sort(A);
        while (true) {
            int a = A[n - 1];
            total -= a;
            if (a == 1 || total == 1)
                return true;
            if (a < total || a % total == 0)
                return false;
            a %= total;
            total += a;
            A[n - 1] = a;
            Arrays.sort(A);
        }
    }*/
    public static void main(String[] args) {
        PriorityQueue<Integer> queue=new PriorityQueue<>((a,b)->b-a);
   queue.add(1);queue.add(2);
        System.out.println(queue.poll());
    }
}
