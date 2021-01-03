package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leet911 {


    //NONONONO
/*    class TopVotedCandidate {

       int[][]sum=new int[5000][5000];
       int []times;
       int []persons;
        public TopVotedCandidate(int[] persons, int[] times) {
            this.times=times;
            this.persons=persons;
            for (int i = 0; i < times.length; i++) {
                sum[persons[i]][times[i]]++;
            }

            for (int i = 0; i < sum.length; i++) {
                for (int j = 1; j < sum[0].length; j++) {
                    sum[i][j]+=sum[i][j-1];
                }
            }

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 31; j++) {
                    System.out.print(sum[i][j]);
                }
                System.out.println();
            }   

        }

        public int q(int t) {
         int l=0,r=times.length-1;
         while (l<r){
             int mid=(l+r)/2;
           if(times[mid]<t){
               l=mid;
           } else if(times[mid]>t){
               r=mid-1;
           }else {
             l=mid;
             break;
           }
         }

            int index=l;

            int max=0;

            for (int i = 0; i < sum.length; i++) {
                max=Math.max(sum[i][times[index]],max);
            }
            //System.out.println(index);
          //  System.out.println(max);

            for (int i = index; i >= 0; i--) {
              if(sum[i][index]==max) return i;
            }

            return -1;

        }
    }*/


    class TopVotedCandidate {
        List<int[]> list = new ArrayList<>();

        public TopVotedCandidate(int[] persons, int[] times) {
            Map<Integer, Integer> map = new HashMap<>();
            int leader = -1;
            int votes = 0;
            for (int i = 0; i < persons.length; i++) {
                int p = persons[i], t = times[i];
                int v = map.getOrDefault(p, 0) + 1;
                if (v >= votes) {
                    if (leader != p) {
                        leader = p;
                        list.add(new int[]{leader, t});
                    }

                    votes = v;
                }

                map.put(p, v);
            }
        }

        public int q(int t) {
            int left = 0;
            int right = list.size() - 1;
            int index = -1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (t >= list.get(mid)[1]) {
                    index = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return list.get(index)[0];
        }
    }

  int help(int []alice,int []bob){
      int []dis=new int[alice.length];
      for (int i = 0; i < dis.length; i++) {
          dis[i]=alice[i]-bob[i];
      }

      Arrays.sort(dis);

      int a=0;int b=0;
       int left=0,right=dis.length-1;

       while (left<right){
           //a取值
          int l=dis[left];
          int r=dis[right];
        if(Math.abs(l)<=Math.abs(r)){
           right--;
           a+=r;
        }else {
          left++;
          a+=l;
        }

        //b取
           l=dis[left];
          r=dis[right];
           if(Math.abs(l)>=Math.abs(r)){
               left++;
               b+=(-l);
           }else {
               right--;
               b+=(-r);
           }
      }

       if(a>b){
           return 1;
       }else if(a<b){
           return -1;
       }else {
           return 0;
       }

  }






}
