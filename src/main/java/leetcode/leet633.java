package leetcode;

import java.util.stream.IntStream;

public class leet633 {
  /*  public boolean judgeSquareSum(int c) {
  for(int i=0;i<Math.sqrt(c)+1;i++){
      int temp=(int)Math.sqrt(c-i*i);
      if((i*i+temp*temp)==c)return true;
  }
  return false;
    }*/


    //这都可以用双指针
/*    public boolean judgeSquareSum(int c) {
        int left=0,right=(int)Math.sqrt(c);
        while (left<=right){
            int cur=left*left+right*right;
            if(cur==c)
                return true;
            else if(cur<c){
                left++;
            }else {
                right--;
            }
        }
        return false;
    }*/

//用set
/*    public boolean judgeSquareSum(int c) {
        HashSet<Integer> set = new HashSet<Integer>();

        for (int i = 0; i <= Math.sqrt(c); i++) {
            set.add(i * i);
            if (set.contains(c - i * i)) {
                return true;
            }
        }
        return false;
    }*/

    //挑战stream  不成功 Time Limit Exceeded
  /*  public boolean judgeSquareSum(int c) {
      return   IntStream.rangeClosed(0,(int)Math.sqrt(c)).filter(
                a->IntStream.rangeClosed(0,(int)Math.sqrt(c)).filter(b->a*a+b*b==c).findAny().isPresent()
        ).findAny().isPresent();
    }
    //挑战stream  成功
    public boolean judgeSquareSum(int c) {
        return   IntStream.rangeClosed(0,(int)Math.sqrt(c)).filter(a->{
            int temp=(int)Math.sqrt(c-a*a);
            if((a*a+temp*temp)==c)return true;
            else return false;
        }).findAny().isPresent();
    }*/
    public boolean judgeSquareSum(int c) {
        return   IntStream.rangeClosed(0,(int)Math.sqrt(c)).filter(a->(int)Math.sqrt(c-a*a)*(int)Math.sqrt(c-a*a)+a*a==c).findAny().isPresent();
    }
}
