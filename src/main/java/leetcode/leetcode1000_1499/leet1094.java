package leetcode.leetcode1000_1499;

public class leet1094 {
    public boolean carPooling(int[][] trips, int capacity) {
  int tempCapacity=0;
  int over=0;
   for(int i=0;i<trips.length;i++){
       if(trips[i][2]>over)
           over=trips[i][2];
   }
   int []temp= new int[over];

   for(int [] trip:trips){
       int begin=trip[1],end=trip[2];
       for(int i=begin;i<end;i++){
           temp[i]+=trip[0];
       }

   }

        for (int i = 0; i < temp.length; i++) {
            if(temp[i]>capacity) return false;
        }



   return  true;
    }
}
