package leetcode.leetcode1_499;

/**
 * Created by libin on 2019/2/1.
 */
public class leet7 {
// static    public int reverse(int x) {
//        if(x==0) return 0;
//         boolean flag=false;
//        if(x>0) flag=true;
//        else {
//            System.out.println("ccccccccccc");
//            System.out.println(Math.abs(x));
//            x = Math.abs(x);
//        }
//        List<Integer> numbers=new LinkedList<>();
//     System.out.println(x);
//        while (x>0){
//         //   System.out.println(x);
//            numbers.add(x%10);
//            x/=10;
//        }
//    //    System.out.println(numbers.size());
//
//        int i=0;
//        while (numbers.get(i)==0) i++;
// StringBuilder sb=new StringBuilder();
//    //    System.out.println(i);
//        while (i<numbers.size()){
//    sb.append(numbers.get(i)+"");
//    i++;
//        }
//
//        if(Double.parseDouble(sb.toString())> Integer.MAX_VALUE) return 0;
//     //   System.out.println(sb.toString());
//        if(flag) return Integer.parseInt(sb.toString());
//        else return -Integer.parseInt(sb.toString());
//
//    }

//优雅的做法
  /*static  public int reverse(int x)
    {
        int result = 0;

        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            System.out.println(newResult+"    "+tail+"    "+result);

            if ((newResult - tail) / 10 != result)
            { return 0; }
            result = newResult;
            x = x / 10;
        }

        return result;
    }*/

    int reverse(int x) {
        int sign = x < 0 ? -1 : 1; //判断符号
        x = Math.abs(x); //取绝对值
        int res = 0;
        while (x > 0) {
            if (Integer.MAX_VALUE / 10 < res || (Integer.MAX_VALUE - x % 10) < res * 10) { //判断是否溢出 ，倒置溢出 或者 加值溢出
                return 0;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }

        return sign * res;
    }


    public static void main(String[] args) {
//        System.out.println(Math.abs(-2147483648));
//
//
//        System.out.println(reverse(2147483647));
//        System.out.println();
//
//        System.out.println(746384741*10);

        int rollMeOver= Integer.MIN_VALUE - 1;
        System.out.println(rollMeOver);


        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));

        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));

        System.out.println(-1);
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(1));

    }

}
