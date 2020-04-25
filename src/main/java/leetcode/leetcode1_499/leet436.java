package leetcode.leetcode1_499;

import java.util.Arrays;

public class leet436 {

    //mine
    public int[] findRightInterval(int[][] intervals) {
    int []res=new int[intervals.length];
    int[][]arr=new int[intervals.length][3];
        for (int i = 0; i < intervals.length; i++) {
            arr[i][0]=intervals[i][0];
            arr[i][1]=intervals[i][1];
            arr[i][2]=i;
        }
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        for (int i = 0; i < arr.length; i++) {
          res[arr[i][2]]=search(i+1,arr.length-1,arr[i][1],arr);
        }
        return res;
    }

    //遍历
/*    int search(int start,int end,int num,int[][]arr){
        for(int i=start;i<arr.length;i++){
            if(arr[i][0]>=num) return arr[i][2];
        }
        return -1;
    }*/
//mine  二分
    int search(int start,int end,int num,int[][]arr) {

        while (start<end){
            int mid=(start+end)/2;
            if(arr[mid][0]==num){
                return arr[mid][2];
            }
            else if(arr[mid][0]>num){
                  end=mid;
            }else {
                 start=mid+1;
            }
        }
        if(start>=arr.length||arr[start][0]<num)  return -1;
          else  return arr[start][2];

    }

//TreeMap二叉搜索树
  /*  public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer,Integer>treeMap=new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            treeMap.put(intervals[i][0],i);
        }

        int []res=new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            Map.Entry<Integer,Integer> entry=treeMap.ceilingEntry(intervals[i][1]);
            if(entry==null){
                res[i]=-1;
            }else {
                res[i]=entry.getValue();
            }
        }
        return res;
    }*/


}
