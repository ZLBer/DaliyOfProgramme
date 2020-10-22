package leetcode;

public class leet372 {
    public int superPow(int a, int[] b) {
return  helper(a,b,b.length-1);
    }

    int helper(int a,int []b,int length){
        if(length<0) return 1;

      int last = b[length];

      int part1=pow(a,last);

      int part2=pow(helper(a,b,length-1),10);

  return  (part1*part2)%mod;
    }
    int mod=1337;


    //求a的k次方
    int pow(int a,int k){
   if(k==0) return 1;
   a%=mod;
   if(k%2==1){
      return a*pow(a,k-1)%mod;
   }else {
       int sub=pow(a,k/2);
     return (sub*sub)%mod;
   }
    }
}
