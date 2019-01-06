package lambda;

/**
 * Created by libin on 2019/1/3.
 */
public class test {
   static void testde(double...numbers){
       for(double c:numbers){
           System.out.println(c);
       }
       System.out.println(numbers);
   }

    public static void main(String[] args) {
 testde(new double[]{12,3,2,1,2});
    }
}
