package leetcode.leetcode1000_;

public class leet1256 {
    public String encode(int num) {
        if(num==0) return "";
        int bit=1;
        while ((num-(1<<bit))>=0){
            num-=(1<<bit);
            bit++;
            System.out.println(num);
        }
        String res= Integer.toBinaryString(num-1);
        while (res.length()<bit){
            res="0"+res;
        }
        return res;
    }



    //找规律
  /*  public String encode(int num) {
        return Integer.toBinaryString(num + 1).substring(1);
    }*/


    //递归方法
 /*   public String encode(int n) {
        return n > 0 ? encode((n - 1) / 2) + "10".charAt(n % 2) : "";
    }*/
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(23));
    }
}
