package leetcode;

import java.math.BigInteger;

/**
 * Created by libin on 2019/3/8.
 */
public class leet415 {
    //直接用大整数运算
   /* public String addStrings(String num1, String num2) {
        BigInteger b1=new BigInteger(num1);
           BigInteger b2 =new BigInteger(num2);
           return b1.add(b2).toString();
    }*/

   //mine
    public String addStrings(String num1, String num2) {
        int lens1=num1.length()-1;
        int lens2=num2.length()-1;
       StringBuilder result=new StringBuilder();
       int jinwei=0;
       while (lens1>=0&&lens2>=0){
   int  a=num1.charAt(lens1)-'0';
   int b=num2.charAt(lens2)-'0';
   int sum=a+b+jinwei;
   result.append(sum%10);
    jinwei=sum/10;
    lens1--;
    lens2--;
        }

        while (lens1>=0){
   int a=num1.charAt(lens1)-'0'+jinwei;
            result.append(a%10);
            jinwei=a/10;
            lens1--;

        }
        while (lens2>=0){
            int b=num2.charAt(lens2)-'0'+jinwei;
            result.append(b%10);
            jinwei=b/10;
            lens2--;

        }
        if(jinwei>0) result.append(jinwei);
            return result.reverse().toString();
    }

//one loop
 /*   public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }*/


}
