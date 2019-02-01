package leetcode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by libin on 2019/2/1.
 */
public class leet7 {
 static    public int reverse(int x) {
        if(x==0) return 0;
         boolean flag=false;
        if(x>0) flag=true;
        else {
            System.out.println("ccccccccccc");
            System.out.println(Math.abs(x));
            x = Math.abs(x);
        }
        List<Integer> numbers=new LinkedList<>();
     System.out.println(x);
        while (x>0){
         //   System.out.println(x);
            numbers.add(x%10);
            x/=10;
        }
    //    System.out.println(numbers.size());

        int i=0;
        while (numbers.get(i)==0) i++;
 StringBuilder sb=new StringBuilder();
    //    System.out.println(i);
        while (i<numbers.size()){
    sb.append(numbers.get(i)+"");
    i++;
        }

        if(Double.parseDouble(sb.toString())> Integer.MAX_VALUE) return 0;
     //   System.out.println(sb.toString());
        if(flag) return Integer.parseInt(sb.toString());
        else return -Integer.parseInt(sb.toString());

    }

    public static void main(String[] args) {
        System.out.println(Math.abs(-2147483648));

        reverse(-2147483648);
        System.out.println();
    }

}
