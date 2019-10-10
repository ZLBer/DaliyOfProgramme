package leetcode;

public class leet565 {


    //mine 初代 Time Limit Exceeded
/*    int max=0;
    public int arrayNesting(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            DFS(nums,nums[i],new boolean[nums.length],1);
        }
        return max;
   }
     void DFS(int nums[],int index,boolean []visited,int deep){
      visited[index]=true;
      if(!visited[nums[index]])
        DFS(nums,nums[index],visited,deep+1);
      else {
          max=Math.max(max,deep);
      }
     }*/



//然后强行欺骗一波  结果过了
    /*    int max=0;
    public int arrayNesting(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
          if(max>(nums.length+1)/2) return max;
            DFS(nums,nums[i],new boolean[nums.length],1);
        }
        return max;
   }
     void DFS(int nums[],int index,boolean []visited,int deep){
      visited[index]=true;
      if(!visited[nums[index]])
        DFS(nums,nums[index],visited,deep+1);
      else {
          max=Math.max(max,deep);
      }
     }*/



    //时间缩短了十倍  ，可以继续短
  /*  int []count;
    public int arrayNesting(int[] nums) {
        boolean[]visited=new boolean[nums.length];
       count=new int[nums.length];
       int max=0;
        for (int i = 0; i < nums.length; i++) {
            count[i]=DFS(nums,nums[i],new boolean[nums.length],1);
            max=Math.max(count[i],max);
        }
        return max;
    }
    int DFS(int nums[],int index,boolean []visited,int deep){
        if(count[index]!=0) return count[index];
        visited[index]=true;
        if(!visited[nums[index]])
           return DFS(nums,nums[index],visited,deep+1);
        else {
           return deep;
        }
    }*/



  //用缓存记录每次的结果  实在优化不动了
/*    int []count;
    public int arrayNesting(int[] nums) {
        count=new int[nums.length];
        int max=0;
        for (int i = 0; i < nums.length; i++) {
            DFS(nums,nums[i],new boolean[nums.length]);
            max=Math.max(count[i],max);
           // if(max>(nums.length+1)/2) return max; //此处不能提前结束
        }

        return max;
    }
    int DFS(int nums[],int index,boolean []visited){
        if(count[index]!=0) return count[index];
        visited[index]=true;
        if(!visited[nums[index]]){
            int deep=DFS(nums,nums[index],visited)+1;
            count[index]=deep;
             return deep;
        }

        else {
            count[index]=1;
            return 1;
        }
    }*/



    //好了  可以直接遍历的
    //此处才真正理解 ：其实是找一个圈.所以不存在找到的是从中间开始的。忽然意识到自己的写法可能有严重的问题
    public int arrayNesting(int[] a) {
        int maxsize = 0;
        for (int i = 0; i < a.length; i++) {
            int size = 0;
            for (int k = i; a[k] >= 0; size++) {
                int ak = a[k];
                a[k] = -1; // mark a[k] as visited;
                k = ak;
            }
            maxsize = Integer.max(maxsize, size);
        }

        return maxsize;
    }
}
