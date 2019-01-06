package lambda;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by libin on 2019/1/2.
 */
public class stream {
    //第三章变成练习
   static int addUp(Stream<Integer> numbers){
        return numbers.reduce(0,(acc,x)->acc+x);
    }
    public static void main(String[] args) {
//        List<String> collected = Stream.of("a", "b", "c")
//                                        .collect(toList());
//        List<String> beginningWithNumbers
//                = Stream.of("a", "1abc", "abc1")
//                .filter(value -> isDigit(value.charAt(0)))
//                .collect(toList());
//      //  int count = Stream.of(1, 2, 3)
// //               .reduce(0, (acc, element) -> acc + element);
//    //    System.out.println(count);
//        BinaryOperator<Integer> accumulator = (acc, element) -> acc + element;
//        int count = accumulator.apply(
//                accumulator.apply(
//                        accumulator.apply(0, 1),
//                        2),
//                3);
     //   Stream.iterate(1, item -> item + 1).limit(10).forEach(System.out::println);

     //    test01();
//        System.out.println(Stream.of(1, 2, 3, 4).reduce(100, (I,S ) -> S + I));
//        System.out.println(Stream.of(1, 2, 3, 4).reduce(100, Integer::sum));
//
//        Function<String> testFun=s-> System.out.println(s);
//        testFun.testFunction("haol");
         Integer nums[]=new Integer[9999999];
        for(int i=0;i<9999999;i++){
             nums[i]=(int)Math.random();
        }
      long begintime=  System.currentTimeMillis();
      Stream.of(nums)
//                .parallel()
                .map(n -> n*n)
                .count();
        long endtime=  System.currentTimeMillis();
        System.out.println(endtime-begintime);

         begintime=  System.currentTimeMillis();
        Stream.of(nums)
                .parallel()
                .map(n -> n*n)
               .count();
         endtime=  System.currentTimeMillis();
        System.out.println(endtime-begintime);


    }
    /*
      1.  给定一个数字列表，如何返回一个由每个数的平方构成的列表呢？
      ，给定【1，2，3，4，5】， 应该返回【1，4，9，16，25】。
  */
   static void test01(){
       //只有惰性方法函数不会执行
       Stream.of().collect(Collectors.toCollection(TreeSet::new));
  //     Stream.of().collect(averagingInt(num->num+1));
       List<Integer> l=new LinkedList();
       Integer []a=l.toArray(new Integer[l.size()]);
       Stream.of(new Integer[]{1,2,3,4}).peek(System.out::println).count();
    }




}
