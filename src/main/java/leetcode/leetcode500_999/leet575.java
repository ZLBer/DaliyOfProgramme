package leetcode.leetcode500_999;

/**
 * Created by libin on 2017/9/6.
 */
public class leet575 {
    public int distributeCandies(int[] candies) {
        sort(candies,0,candies.length-1);
        for(int i=0;i<candies.length-1;i++){
            System.out.println(candies[i]);
        }
        int count=candies.length;
        for(int i=0;i<candies.length-1;i++){
            if(candies[i]==candies[i+1])count--;
        }
        if(count>candies.length/2) return count=candies.length/2;
        else return count;
    }


    public static int partition(int []array,int lo,int hi){
        //固定的切分方式
        int key=array[lo];
        while(lo<hi){
            while(array[hi]>=key&&hi>lo){//从后半部分向前扫描
                hi--;
            }
            array[lo]=array[hi];
            while(array[lo]<=key&&hi>lo){//从前半部分向后扫描
                lo++;
            }
            array[hi]=array[lo];
        }
        array[hi]=key;
        return hi;
    }

    public static void sort(int[] array,int lo ,int hi){
        if(lo>=hi){
            return ;
        }
        int index=partition(array,lo,hi);
        sort(array,lo,index-1);
        sort(array,index+1,hi);
    }
}
