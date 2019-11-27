package leetcode.leetcode1000_;

public class leet1103 {
    public int[] distributeCandies(int candies, int num_people) {
  int []result=new int[num_people];
        for(int i=0;i<num_people;i++){
            if(candies>=i+1) {
                result[i] = i + 1;
                candies = candies - i - 1;
            }
            else {
                result[i]=candies;
                return result;
            }
        }
        int count=1;
   while (candies>0){
       for(int i=0;i<num_people;i++){
           if(candies>=count*num_people+i+1){
               result[i]+=count*num_people+i+1;
               candies=candies-count*num_people-i-1;
           }
           else {
               result[i]+=candies;
               return result;
           }
       }
       count++;

   }


     return result;
    }
}
