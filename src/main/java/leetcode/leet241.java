package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class leet241{
        public List<Integer> diffWaysToCompute(String input) {
 return null;
        }


        static int test(Function<Integer,Integer> predicate, int value){
                return predicate.andThen(predicate).apply(value);
        }
        int[]  returnInt(){
            List<Integer> list=new ArrayList<>();
           return list.stream().mapToInt((a)->a).toArray();
        }
        public static void main(String[] args) {
               Function<Integer,Integer> function=(a)->a;
                Comparator<Integer> comparator=Comparator.comparing(function).reversed().thenComparing(function);
        }

}
