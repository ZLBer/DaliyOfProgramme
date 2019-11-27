package leetcode.leetcode1_499;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class leet384 {

    // 不是很明白这个初衷是什么，类似于洗牌的意思？
    class Solution {
          int []pre;
        public Solution(int[] nums) {
         pre=nums;
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
         return  pre;
        }

        /** Returns a random shuffling of the array. */
 /*       public int[] shuffle() {
           List<Integer> list=new ArrayList<>();
            for (int i = 0; i < pre.length; i++) {
                list.add(pre[i]);
            }
            int []shuffle=new int[pre.length];
            Random random=new Random();
            int count=0;
            while (list.size()>0){
                int index=random.nextInt(list.size());
                shuffle[count++]=list.get(index);
                list.remove(index);
            }
            return shuffle;

        }*/

        public int[] shuffle() {
            Random random=new Random();
            int [] shuffle=pre.clone();
            for(int j=1;j<pre.length;j++){
                int i=random.nextInt(j+1);
                swap(shuffle,i,j);
            }

            return  shuffle;
        }
    }
    private void  swap(int [] num,int i,int j){
         int temp=num[i];
         num[i]=num[j];
         num[j]=temp;
    }
}
