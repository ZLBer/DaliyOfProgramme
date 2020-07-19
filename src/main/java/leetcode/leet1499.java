package leetcode;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class leet1499 {

    //mine Because xi < xj,
    //yi + yj + |xi - xj| = (yi - xi) + (yj + xj)
    //所以只需要找 max yi-xi即可
static     public int findMaxValueOfEquation(int[][] points, int k) {
        int left=0;
    int res=Integer.MIN_VALUE;

        Deque<Integer> deque=new ArrayDeque<>();
        // int []maxXYI=new int[]{points[0][0],points[0][1],0};
        deque.addLast(0);
        for (int i = 1; i < points.length; i++) {
            int []cur=points[i];
            while (Math.abs(cur[0]-points[left][0])>k){ //窗口缩小

                if(deque.peekFirst()==left){
                    deque.pollFirst();

                }
                left++;
            }
           if(!deque.isEmpty()) res=Math.max(Math.abs(cur[0]-points[deque.peekFirst()][0])+cur[1]+points[deque.peekFirst()][1],res);
            while (!deque.isEmpty()&&points[deque.peekLast()][1]-points[deque.peekLast()][0]<cur[1]-cur[0]){
                deque.pollLast();
            }
            deque.addLast(i);

        }

        return res;
    }


    //也可以优先级队列   ，居然比单调栈快，不应该啊

/*    public int findMaxValueOfEquation(int[][] points, int k) {
        int result = Integer.MIN_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - b[0] - (a[1] - a[0])));
        for (int[] point : points) {
            while (!pq.isEmpty() && point[0] - pq.peek()[0] > k) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                int[] head = pq.peek();
                result = Math.max(result, point[1] + head[1] + point[0] - head[0]);
            }
            pq.offer(point);
        }

        return result;
    }*/

    public static void main(String[] args) {
        List<GarbageCollectorMXBean> garbageCollectorMXBeans = ManagementFactory.getGarbageCollectorMXBeans();
         while (true){
             for (GarbageCollectorMXBean garbageCollectorMXBean : garbageCollectorMXBeans) {
                 System.out.println(garbageCollectorMXBean.getName()+" "+garbageCollectorMXBean.getCollectionTime());
             }
             try {
                 TimeUnit.SECONDS.sleep(1);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }

//        findMaxValueOfEquation(new int[][]{
//                {1,3},{2,0},{5,10},{6,-10}
//        },1);
    }
}
