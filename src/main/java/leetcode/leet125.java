package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leet125 {

    //alphanumeric字母和数字组合的
/*    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        List<Character> list=new ArrayList<>();
        for(char c:s.toCharArray()){
            if((c>='a'&&c<='z')||(c>='0'&&c<='9'))
                list.add(c);
        }
 int length=list.size();
        for (int i = 0; i < list.size()/2; i++) {
            System.out.println(list.get(i));
            if(list.get(i)!=list.get(length-1-i))
                return false;
        }

        return true;
    }*/


    public boolean isPalindrome(String s) {
        int left=0,right=s.length()-1;
        while (left<right){
            char cleft=s.charAt(left),cright=s.charAt(right);
            if (!Character.isLetterOrDigit(cleft))
                left++;
            else if (!Character.isLetterOrDigit(cright))
                       right--;

           else {
               if(Character.toLowerCase(cleft)==Character.toLowerCase(cright)){
                   left++;
                   right--;
               }
               else return false;
            }

        }
        return true;
    }


    //先替换再反转比较
  /*  public boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }*/
}
