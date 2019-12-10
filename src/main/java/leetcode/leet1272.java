package leetcode;

import java.util.*;

public class leet1272 {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]) {
                    return (o1[1]-o2[1]);
                }else {
                    return (o1[0]-o2[0]);
                }
            }
        });

        for (int i = 0; i < intervals.length; i++) {
            int begin=intervals[i][0];
            int end=intervals[i][1];

            //左边不相交
            if(end<=toBeRemoved[0]){
                res.add(Arrays.asList(begin,end));
            }
            //左边相交一部分
            else if(begin<toBeRemoved[0]&&end<toBeRemoved[1]){
                res.add(Arrays.asList(begin,toBeRemoved[0]));
            }
            //右边相交一部分
            else if(begin<toBeRemoved[1]&&end>toBeRemoved[1]){
                res.add(Arrays.asList(toBeRemoved[1],end));
            }else if(begin>toBeRemoved[1]){
                res.add(Arrays.asList(begin,end));
                //跨越
            }else if(begin<toBeRemoved[0]&&end>toBeRemoved[1]){
                res.add(Arrays.asList(begin,toBeRemoved[0]));
                res.add(Arrays.asList(toBeRemoved[1],end));
            }
        }
return res;
    }
}
