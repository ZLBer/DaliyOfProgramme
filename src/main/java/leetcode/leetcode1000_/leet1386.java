package leetcode.leetcode1000_;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leet1386 {

    //TLE 48/53
/*    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Set<String> set=new HashSet<>();
        for (int[] reservedSeat : reservedSeats) {
            set.add(reservedSeat[0]+""+reservedSeat[1]);
        }

       int count=0;
         for(int row=1;row<=n;row++) {
             boolean flag = true;
             for (int col = 5; col >= 2; col--) {
                 if (set.contains(row + "" + col)) {
                     flag = false;
                     break;
                 }
             }
             if (flag) count++;
             boolean flag2 = true;
             for (int col = 4; col <= 7; col++) {
                 if (set.contains(row + "" + col)) {
                     flag2 = false;
                     break;
                 }
             }
             if (flag2) count++;
             boolean flag3 = true;
             for (int col = 6; col <= 9; col++) {
                 if (set.contains(row + "" + col)) {
                     flag3 = false;
                     break;
                 }
             }
             if (flag3) count++;

             if((flag&&flag2)||(flag2&&flag3)) count--;
         }
         return count;
    }*/


    //MLE   48 / 53
  /*  public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        boolean[][]visited=new  boolean[n+1][10+1];
        for (int[] reservedSeat : reservedSeats) {
           visited[reservedSeat[0]][reservedSeat[1]]=true;
        }

        int count=0;
        for(int row=1;row<=n;row++) {
            boolean flag = true;
            for (int col = 5; col >= 2; col--) {
                if (visited[row][col]) {
                    flag = false;
                    break;
                }
            }
            if (flag) count++;
            boolean flag2 = true;
            for (int col = 4; col <= 7; col++) {
                if (visited[row][col]) {
                    flag2 = false;
                    break;
                }
            }
            if (flag2) count++;
            boolean flag3 = true;
            for (int col = 6; col <= 9; col++) {
                if (visited[row][col]) {
                    flag3 = false;
                    break;
                }
            }
            if (flag3) count++;

            if((flag&&flag2)||(flag2&&flag3)) count--;
        }
        return count;
    }*/



    //TLE
  /*  public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Set<String> set=new HashSet<>();
        for (int[] reservedSeat : reservedSeats) {
            set.add(reservedSeat[0]+""+reservedSeat[1]);
        }

        int count=0;
        for(int row=1;row<=n;row++) {
            boolean leftFlag = true;
            if(set.contains(row+""+4)||set.contains(row+""+5)) leftFlag=false;
            boolean rightFlag = true;
            if(set.contains(row+""+6)||set.contains(row+""+7)) rightFlag=false;
            if(!leftFlag&&!rightFlag) continue; //剪枝
            boolean lleftFlag = true;
            if(set.contains(row+""+2)||set.contains(row+""+3)) lleftFlag=false;
            boolean rrightFlag = true;
            if(set.contains(row+""+8)||set.contains(row+""+9)) rrightFlag=false;
            if(leftFlag){
                if(lleftFlag){
                    leftFlag=false;
                    count++;
                }
            }
            if(rightFlag){
                if(rrightFlag) {
                    count++;
                   rightFlag=false;
                }
            }
            if(leftFlag&&rightFlag) count++;
        }
        return count;
    }*/

  //提示  用位运算

/*    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
      Map<Integer, List<Integer>> map=new HashMap<>();
        int mid=(1<<6|1<<5|1<<4|1<<3);
        int left=(1<<6|1<<5|1<<7|1<<8);
        int right=(1<<1|1<<2|1<<4|1<<3);
        for (int[] reservedSeat : reservedSeats) {
           if(!map.containsKey(reservedSeat[0]))map.put(reservedSeat[0],new ArrayList<>());
           map.get(reservedSeat[0]).add(reservedSeat[1]);
                  }*//*
        for (int i = 0; i < bits.length; i++) {
            System.out.println(Integer.toBinaryString(bits[i]));
        }*//*
        int count=0;
        for (int i = 1; i <= n; i++) {
           if(!map.containsKey(i)) {
               count+=2;
               continue;
           }
           int bit=0;
           for(int col:map.get(i)){
              bit|=(1<<(10-col));
           }
           boolean flag=true;
           if((bit&left)==0){
               flag=false;
               count++;
           }
           if((bit&right)==0){
               flag=false;
               count++;
           }
           if(flag&&((bit&mid)==0))count++;
        }
        
        return count;
    }*/

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, List<Integer>> map=new HashMap<>();
        int mid=(1<<6|1<<5|1<<4|1<<3);
        int left=(1<<6|1<<5|1<<7|1<<8);
        int right=(1<<1|1<<2|1<<4|1<<3);
        for (int[] reservedSeat : reservedSeats) {
            if(!map.containsKey(reservedSeat[0]))map.put(reservedSeat[0],new ArrayList<>());
            map.get(reservedSeat[0]).add(reservedSeat[1]);
        }/*
        for (int i = 0; i < bits.length; i++) {
            System.out.println(Integer.toBinaryString(bits[i]));
        }*/
        int count=0;

        for(Map.Entry<Integer,List<Integer>>entry:map.entrySet()){
            int bit = 0;
            for (int col : entry.getValue()) {
                bit |= (1 << (10 - col));
            }
            int c=0;
            if ((bit & left) != 0) {
                c++;
                count++;
            }
            if ((bit & right) != 0) {
                c++;
                count++;
            }
            if (c==2&&((bit & mid) == 0)) count--;
            System.out.println(entry.getKey()+"  "+count);
        }

        return 2*n-count;
    }
}
