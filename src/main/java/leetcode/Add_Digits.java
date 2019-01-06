package leetcode;

/**
 * Created by libin on 2017/9/24.
 */
public class Add_Digits {

        public int addDigits(int num) {
           while(num>9){
           String s= String.valueOf(num);
               System.out.println(s);
           num=0;
           for(int i=0;i<s.length();i++) {
               System.out.println(s.charAt(i));
               num += Integer.valueOf(s.charAt(i) + "");
           }
        }
        return num;
    }
}


