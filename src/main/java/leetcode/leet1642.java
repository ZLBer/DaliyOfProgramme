package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class leet1642 {


    //TLE
/*   public int furthestBuilding(int[] heights, int bricks, int ladders) {
     return dfs(0,heights,bricks,ladders);
    }

    Map<String,Integer> map=new HashMap<>();

    int dfs(int index,int []heights,int bricks,int ladders){
       if(index==heights.length-1){
           return heights.length-1;
       }

       String key=index+"-"+bricks+"-"+ladders;

       if(map.containsKey(key)) return map.get(key);

       int cur=heights[index],next=heights[index+1];

       int max=index;
       if(next<=cur) max=dfs(index+1,heights,bricks,ladders);
       else {
         if(next-cur<=bricks){
            max=Math.max(max,dfs(index+1,heights,bricks-(next-cur),ladders));
         }
         if(ladders>0){
             max=Math.max(max,dfs(index+1,heights,bricks,ladders-1));

         }
       }

       map.put(key,max);
      return max;
    }*/



//mine 优先使用砖头
/*
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> priorityQueue =new PriorityQueue<>((a,b)->b-a);

        int i=0;
        for (i = 0; i < heights.length-1; i++) {
           int cur=heights[i];
           int next=heights[i+1];
          if(cur>=next) continue;

          int dis=next-cur;
          if(bricks>=dis){
            bricks-=dis;
            priorityQueue.add(dis);
          }else if(ladders>0){
              ladders--;
              if(priorityQueue.isEmpty()) continue;
             int pre=priorityQueue.peek();
             if(pre>dis){
                priorityQueue.poll();
                priorityQueue.add(dis);
                bricks+=(pre-dis);
             }
          }else {
              break;
          }
        }
        return i;
    }
*/


    //优先使用梯子  简洁了很多
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length, sum = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i < heights.length; i++) {
            int diff = heights[i] - heights[i - 1];
            if (diff > 0) {
                queue.offer(diff);
                if (queue.size() > ladders) {
                    sum += queue.poll();
                }
                if (sum > bricks)
                    return i - 1;
            }
        }
        return n - 1;
    }

    //二分也可
/*    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int l = ladders, r = heights.length - 1;
        while(l <= r) {
            int mid = l + r >>> 1;
            if(check(heights, bricks, ladders, mid))
                l = mid + 1;
            else
                r = mid - 1;
        }
        return r;
    }
    private boolean check(int[] heights, int bricks, int ladders, int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(heights[i + 1] - heights[i] > 0) {
                list.add(heights[i + 1] - heights[i]);
            }
        }
        Collections.sort(list);
        int sum = 0;
        for(int i = 0; i < list.size() - ladders; i ++) {
            sum += list.get(i);
            if(sum > bricks)
                return false;
        }
        return true;
    }*/

//深度优先居然过了也过了，我的记忆化居然没过？key为string复杂度太高了

/*    private int ans = 0;
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        dfs(heights, 0, bricks, ladders);
        return ans;
    }
    private void dfs(int[] heights, int cur, int bricks, int ladders) {
        if(ans == heights.length - 1) //这句剪枝是关键，缺少这一句，会超时。
            return;
        if(cur == heights.length - 1 || (heights[cur + 1] - heights[cur] > bricks && ladders == 0)) {
            ans = Math.max(ans, cur);
            return;
        }
        if(heights[cur] >= heights[cur + 1])
            dfs(heights, cur + 1, bricks, ladders);
        else{
            if(bricks >= heights[cur + 1] - heights[cur])
                dfs(heights, cur + 1, bricks + heights[cur] - heights[cur + 1], ladders);
            if(ladders >= 1)
                dfs(heights, cur + 1, bricks, ladders - 1);
        }

    }*/





}
