package leetcode.华科复试;

/**
 * Created by libin on 2019/3/3.
 */
public class bigThanThis {
   static void solution(int nums[]){
        for(int i=0;i<nums.length;i++){
            int index=i;
            int last=(i+1)%nums.length;
            while (last!=index){
           if(nums[last]>nums[index]){
               System.out.print(nums[last]+"  ");
          break;
           }
         last=(last+1)%nums.length;
            }
            if(last==index)
            System.out.print(-1+"  ");
        }
    }

    public static void main(String[] args) {
        solution(new int[]{1,2,1,6,3,4});
    }
}
