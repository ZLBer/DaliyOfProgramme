package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class leet1389 {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < index.length; i++) {
            list.add(index[i],nums[i]);
        }
        int []res=new int[nums.length];
        for (int i = 0; i < list.size(); i++) {
            res[i]=list.get(i);
        }
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
        return res;

     //就是这样  写起来简洁跑起来慢
        //   return list.stream().mapToInt(i->i).toArray();
    }
}
