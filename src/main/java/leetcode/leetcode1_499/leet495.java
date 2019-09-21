package leetcode.leetcode1_499;

/**
 * Created by libin on 2019/1/4.
 */
public class leet495 {

    //O(n)
  static   public int findPoisonedDuration(int[] timeSeries, int duration) {
      if (timeSeries.length==0) return 0;
        if (timeSeries.length == 1) return duration;
        int begin = timeSeries[0];
        int end = 0;
        int poisonedDuration=0;
        end = begin + duration;
        //遍历判断持续时间此次开始时间是否重合
        for (int i = 1; i < timeSeries.length; i++) {
            //开始时间大于上次结束时间
            if (timeSeries[i] >= end){
                 poisonedDuration+=(end-begin);
                 begin=timeSeries[i];
                 end=timeSeries[i]+duration;
            }
            //开始时间小于上次结束时间
            else {
                end=timeSeries[i]+duration;
            }
        }
        //遍历到最后需要再尖酸一次
        poisonedDuration+=(timeSeries[timeSeries.length-1]+duration-begin);
        return  poisonedDuration;
    }
// amazing idea  很简洁
//    public int findPoisonedDuration(int[] timeSeries, int duration) {
//        if (timeSeries.length == 0) return 0;
    //初始化开始时间和总计时间
//        int begin = timeSeries[0], total = 0;
//        for (int t : timeSeries) {
      //每次判断（上次时间+duration） 和  这次时间  的大小
//            total = total + (t < begin + duration ? t - begin : duration);
//            begin = t;
//        }
//        return total + duration;
//    }

    public static void main(String[] args) {

        System.out.println( findPoisonedDuration(new int[]{1,2},2));
    }
}
