package leetcode.leetcode1000_1499;

public class leet1176 {
    //最朴素的版本
/*       public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
       int score=0;
        for(int i=0;i+k<=calories.length;i++){
           int sum=0;
           for(int j=i;j<i+k&&j<calories.length;j++){
             sum+=calories[j];
           }
           if(sum<lower)
               score--;
           else if(sum>upper)
               score++;
       }
        return score;
    }*/

    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int score=0;
        int slideWindows=0;
        for(int i=0;i<k;i++){
             slideWindows+=calories[i];
        }

        if(slideWindows<lower)
            score--;
        else if(slideWindows>upper)
            score++;
        for(int i=1;i+k<=calories.length;i++){
            slideWindows-=calories[i+1];
            slideWindows+=calories[i+k-1];
            if(slideWindows<lower)
                score--;
            else if(slideWindows>upper)
                score++;
        }
        return score;
    }


    public static void main(String[] args) {
        //dietPlanPerformance(new int[]{3,2},2,0,1);
    }
}
