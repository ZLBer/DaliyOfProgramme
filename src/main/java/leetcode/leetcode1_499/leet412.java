package leetcode.leetcode1_499;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by libin on 2017/9/9.
 */
public class leet412 {
    public List<String> fizzBuzz(int n) {
        List<String> result=new LinkedList<String>();
         for(int i=1;i<=n;i++){
             if(i%3==0&&i%5==0) result.add("FizzBuzz");
            else if(i%3==0) result.add("Fizz");
             else if(i%5==0) result.add("Buzz");

         else result.add(i+"");
         }
         return  result;
    }
}
