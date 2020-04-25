package leetcode.leetcode500_999;

import java.util.Arrays;

public class leet593 {
    //mine 没考虑斜着的
/*    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        List<int[]> list=new ArrayList<>();
       list.add(p1);list.add(p2);list.add(p3);list.add(p4);
        Collections.sort(list,(a,b)->a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]);
         int length=-1;
        for (int i = 1; i < list.size(); i++) {
            int tlength=getLength(list.get(i),list.get(i-1));
          if(length==-1||length==tlength) {
              length=tlength;
              continue;
          }
          else return false;
        }
        return true;
    }

    int getLength(int[]p1,int []p2){
    if(p1[0]==p2[0]) return Math.abs(p1[1]-p2[1]);
    else return Math.abs(p1[0]-p2[0]);
    }*/

//考虑对角线也是不对的
   /* public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        List<int[]> list=new ArrayList<>();
        list.add(p1);list.add(p2);list.add(p3);list.add(p4);
        List<Double> res=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
          double minLength=Integer.MIN_VALUE;
            for(int j=0;j<list.size();j++){
              if(i==j) continue;
              minLength=Math.max(getLength(list.get(i),list.get(j)),minLength);
          }
            res.add(minLength);
        }
        double dis=0.00001;
        for (int i = 1; i < res.size(); i++) {
            System.out.println(res.get(i)+"  "+res.get(i-1));
            System.out.println(res.get(i)==res.get(i-1));
            if(Math.abs(res.get(i-1)-res.get(i))>dis) return false;
        }
        return true;
    }

    double getLength(int[]p1,int []p2){
        int t1=p1[0]-p2[0];
        int t2=p1[1]-p2[1];

        double val= Math.sqrt(Math.abs(t1*t1+t2*t2));
        System.out.println(p1[0]+" "+p1[1]+"  "+p2[0]+" "+ p2[1]+"  "+ val);
     return val;
    }*/


    //考虑的太复杂了

   //之前的排序以为不对
    public double dist(int[] p1, int[] p2) {
        return (p2[1] - p1[1]) * (p2[1] - p1[1]) + (p2[0] - p1[0]) * (p2[0] - p1[0]);
    }
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] p={p1,p2,p3,p4};
        //排序
        Arrays.sort(p, (l1, l2) -> l2[0] == l1[0] ? l1[1] - l2[1] : l1[0] - l2[0]);
        //比较四条边
        return dist(p[0], p[1]) != 0 && dist(p[0], p[1]) == dist(p[1], p[3]) && dist(p[1], p[3]) == dist(p[3], p[2]) && dist(p[3], p[2]) == dist(p[2], p[0])   && dist(p[0],p[3])==dist(p[1],p[2]);
    }


   //找规律呗就
/*
    public double dist(int[] p1, int[] p2) {
        return (p2[1] - p1[1]) * (p2[1] - p1[1]) + (p2[0] - p1[0]) * (p2[0] - p1[0]);
    }
    public boolean check(int[] p1, int[] p2, int[] p3, int[] p4) {
        return dist(p1,p2) > 0 && dist(p1, p2) == dist(p2, p3) && dist(p2, p3) == dist(p3, p4) && dist(p3, p4) == dist(p4, p1) && dist(p1, p3) == dist(p2, p4);
    }
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return check(p1, p2, p3, p4) || check(p1, p3, p2, p4) || check(p1, p2, p4, p3);
    }
*/


}
