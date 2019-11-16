package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leet56 {
  static   class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    //错误的做法
/*  static   public int[][] merge(int[][] intervals) {
     List<Interval> list=new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            Interval in=new Interval(intervals[i][0],intervals[i][1]);
            boolean flag=true;
            for (int j = 0; j < list.size(); j++) {
                Interval out=list.get(j);
                if(in.start<=out.end&&in.start>=out.start||in.end<=out.end&&in.end>=out.start||in.start<=out.start&&in.end>=out.end){
                    list.get(j).start=Math.min(in.start,out.start);
                    list.get(j).end=Math.max(in.end,out.end);
                    flag=false;
                    break;
                }


            }  if(flag) list.add(in);
        }
      int [][]res=new int[list.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i][0]=list.get(i).start;
            res[i][1]=list.get(i).end;
        }
        return res;
    }*/


//排序 然后保存一个临时的interval
 /*   public int[][] merge(int[][] intervals) {
        if(intervals.length==0) return new int[0][0];
        Arrays.sort(intervals,(i,j)->-(i[0]-j[0]));;
        List<Interval> res=new ArrayList<>();
        Interval newInterval=new Interval(intervals[0][0],intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if(newInterval.end>intervals[i][0]){
                newInterval.end=Math.max(newInterval.end,intervals[i][1]);
            }else {
                res.add(newInterval);
                newInterval=new Interval(intervals[i][0],intervals[i][1]);
            }
        }
        res.add(newInterval);
       int [][]r=new int[res.size()][2];
        for (int i = 0; i < r.length; i++) {
            r[i][0]=res.get(i).start;
            r[i][1]=res.get(i).end;
        }
        return r;
    }*/

//打乱start和end的顺序，求distinct
    public int[][] merge(int[][] intervals) {
        int []start=new int[intervals.length];
        int []end=new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i]=intervals[i][0];
            end[i]=intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        List<int[]>res=new ArrayList<>();
        for(int i=0,j=0;i<intervals.length;i++){
            if(i==intervals.length-1||start[i+1]>end[i]){
                res.add(new int[]{start[j],end[i]});
                j=i+1;
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
    public static void main(String[] args) {
        /* merge(new int[][]{
                 {1,4},{2,6},{8,10},{15,18}
         });*/
    }
}
