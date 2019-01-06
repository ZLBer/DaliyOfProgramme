package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by libin on 2018/6/19.
 */
public class LamTest {
    public static  void mapTest() {
        List<Double> cost = Arrays.asList(10.0, 20.0,30.0);
        cost.stream().map(x -> x + x*0.05).forEach(x -> System.out.println(x));
        ArrayList<Integer> L=new ArrayList();


    }
    public  static void mapReduceTest() {
        List<Double> cost = Arrays.asList(10.0, 20.0,30.0);
        double allCost = cost.stream().map(x -> x+x*0.05).reduce((sum,x) -> sum + x).get();
        System.out.println(allCost);
    }
    public static void main(String[] args) {
    mapTest();
    }
}
