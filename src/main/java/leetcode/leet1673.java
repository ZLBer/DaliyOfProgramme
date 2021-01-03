package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class leet1673 {

/*    public int[] mostCompetitive(int[] nums, int k) {
     int [][]arr=new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arr[i][0]=nums[i];
            arr[i][1]=i;
        }
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        for (int i = 0; i < arr.length; i++) {
           int min=arr[i][1];
          if(arr.length-min<k) continue;
           List<Integer> list=new ArrayList<>();
           list.add(arr[i][0]);
            System.out.println(i);
            for (int j = i+1; list.size()<k&&j < arr.length; j++) {
              if(arr[j][1]>min){
                  min=arr[j][1];
                  list.add(arr[j][0]);
              }
            }
           if(list.size()>=k) return list.stream().mapToInt(a->a).toArray();
            list=new ArrayList<>();
            list.add(arr[i][0]);
            for (int j = arr[i][1]+1; list.size()<k&&j < arr.length; j++) {
                System.out.println(nums[j]);
              list.add(nums[j]);
            }
          return list.stream().mapToInt(a->a).toArray();
        }
      return null;
    }*/



/*  static   public int[] mostCompetitive(int[] nums, int k) {
        int [][]arr=new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arr[i][0]=nums[i];
            arr[i][1]=i;
        }
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        List<Integer> list=new ArrayList<>();
       helper(0,arr,k,list,nums,Integer.MAX_VALUE);
      return list.stream().mapToInt(a->a).toArray();
    }

  static boolean helper(int index,int [][]arr,int k,List<Integer> list,int []nums,int m){
if(index>=arr.length)return false;
       if(k==0) return true;
      if(arr.length-arr[index][1]==k){ //
          for(int i=arr[index][1];i<nums.length;i++){
            list.add(nums[i]);
          }
          return true;
      }
        for (int i = index; i < arr.length; i++) {
             int min=arr[i][1];
             if(arr.length-min<k) continue;

            if(min>m){
                list.add(arr[i][0]);
                if(helper(i+1,arr,k-1,list,nums,min)) return true;
                list.remove(list.size()-1);
            }

        }
        return false;
    }*/


    public static void main(String[] args) {
        //   mostCompetitive(new int[]{84,10,71,23,66,61,62,64,34,41,80,25,91,43,4,75,65,13,37,41,46,90,55,8,85,61,95,71},24);
    }

    //contest的时候搞了好久才搞出来   直接爆炸
    public int[] mostCompetitive(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.size() + (nums.length - i) > k && deque.peekLast() > nums[i]) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
            if (deque.size() > k) deque.pollLast();

        }
        return deque.stream().mapToInt(a -> a).toArray();
    }

    //优先队列  本质就是窗口取最小
/*    public int[] mostCompetitive(int[] nums, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int n = nums.length;

        //先初始化 尽可能多的放入 ，剩下的数保证能组成k个
        for (int i = 0; i < n - k; i++) {
            priorityQueue.add(new int[]{nums[i], i});
        }
        int index = -1;
        int[] res = new int[k];
        //进行k轮筛选
        for (int i = 0; i < k; i++) {
            //首先添加新的数字 保证每轮队列都不空
            priorityQueue.add(new int[]{nums[n-k+i],n-k+i});
            //把坐标比之前小的筛选掉
            while (priorityQueue.peek()[1] < index) {
                priorityQueue.poll();
            }
            //取最小
            int[] p = priorityQueue.poll();
            index = p[1];
            res[i] = p[0];
        }
        return res;
    }*/
}
