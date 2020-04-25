package leetcode.leetcode1000_;

public class leet1281 {
    public int subtractProductAndSum(int n) {
  int product=1;
  int sum=0;
  while (n>0){
      int num=n%10;
      product*=num;
      sum+=num;
      n/=10;
  }
  return product-sum;
    }
}
