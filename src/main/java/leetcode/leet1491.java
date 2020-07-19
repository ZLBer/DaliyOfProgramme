package leetcode;

public class leet1491 {
    public double average(int[] salary) {

        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        double sum=0;
        for (int sa : salary) {
            sum+=sa;
           min=Math.min(min,sa);
           max=Math.max(max,sa);
        }
      return (sum-min-max)/(salary.length-2);
    }
}
