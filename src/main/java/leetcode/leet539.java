package leetcode;

import java.util.List;

public class leet539 {
    //mine 一次过
 /*   public int findMinDifference(List<String> timePoints) {
        List<Integer> minutes=new ArrayList<>();
        for (String timePoint : timePoints) {
            String[] hourAndMinute=timePoint.split(":");
            minutes.add(Integer.valueOf(hourAndMinute[0])*60+Integer.valueOf(hourAndMinute[1]));
        }
        Collections.sort(minutes);
        int res=minutes.get(0)-0+24*60-minutes.get(minutes.size()-1);
        for (int i = 1; i < minutes.size(); i++) {
           res=Math.min(res,minutes.get(i)-minutes.get(i-1));
        }
        return res;
    }
*/
    //mine 优化一下  快了将近一倍
/*    public int findMinDifference(List<String> timePoints) {
        int []minutes=new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String[] hourAndMinute=timePoints.get(i).split(":");
            minutes[i]=Integer.valueOf(hourAndMinute[0])*60+Integer.valueOf(hourAndMinute[1]);
        }
        Arrays.sort(minutes);
    int res=minutes[0]-0+24*60-minutes[minutes.length-1];
        for (int i = 1; i < minutes.length; i++) {
        res=Math.min(res,minutes[i]-minutes[i-1]);
    }
        return res;
}*/

//线性 计数排序
    public int findMinDifference(List<String> timePoints) {
        boolean[] mark = new boolean[24 * 60];
        for (String time : timePoints) {
            String[] t = time.split(":");
            int h = Integer.parseInt(t[0]);
            int m = Integer.parseInt(t[1]);
            if (mark[h * 60 + m]) return 0;
            mark[h * 60 + m] = true;
        }

        int prev = 0, min = Integer.MAX_VALUE;
        int first = Integer.MAX_VALUE, last = Integer.MIN_VALUE;
        for (int i = 0; i < 24 * 60; i++) {
            if (mark[i]) {
                if (first != Integer.MAX_VALUE) {
                    min = Math.min(min, i - prev);
                }
                first = Math.min(first, i);
                last = Math.max(last, i);
                prev = i;
            }
        }

        min = Math.min(min, (24 * 60 - last + first));

        return min;
    }
}
