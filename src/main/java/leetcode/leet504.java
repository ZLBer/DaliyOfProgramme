package leetcode;

/**
 * Created by libin on 2019/3/8.
 */
public class leet504 {
  static   public String convertToBase7(int num) {
      if (num == 0) return "0";

      StringBuilder sb = new StringBuilder();
      boolean negative = false;

      if (num < 0) {
          negative = true;
          num=-num;
      }
        while (num!=0){
           sb.append(num%7);
           num/=7;
        }
        if(negative) sb.append("-");
        System.out.println(sb.reverse());
        return  sb.reverse().toString();
    }

    public static void main(String[] args) {
convertToBase7(100);
    }
}
