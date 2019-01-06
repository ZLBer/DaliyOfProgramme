package leetcode;

/**
 * Created by libin on 2019/1/1.
 */
public class leet849 {
    static public int maxDistToClosest(int[] seats) {
        int before=0,behind=0,middle=0,smiddle=0;

        int i=0,j=seats.length-1;
        //从前开始
         for( ;i<seats.length;i++)
             if(seats[i]==0) before++;
            else break;
            //从后开始
        for( ;j>=0;j--)
            if(seats[j]==0) behind++;
            else break;
     //中间位置
            i++;
           while (i<=j){
           if(seats[i]==0) {
               smiddle++;
               i++;
           }
           else {
               if(smiddle>middle){
                   middle=smiddle;
               }
               smiddle=0;
               i++;
           }
           }

           if(middle%2==0) middle/=2;
           else middle=(middle+1)/2;
        return  ((middle)>before?middle:before)>behind?((middle)>before?middle:before):behind;

    }

    public static void main(String[] args) {
        System.out.println(maxDistToClosest(new int[]{1,0,0,0,1,0,1}));
    }
}
