package leetcode;

public class leet405 {
 /*   public String toHex(int num) {
      return Integer.toHexString(num);
    }*/
 String []hex={"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
    public String toHex(int num) {
        if(num==0) return "0";
        StringBuilder result=new StringBuilder();
      while (num!=0){
           result.insert(0,hex[num&15]);
           num=num>>>4;
      }
      return result.toString();
    }

    public static void main(String[] args) {
        int a=0b11111111111111111111111111111111;
        System.out.println(Integer.toBinaryString(a>>>16));
    }
}
