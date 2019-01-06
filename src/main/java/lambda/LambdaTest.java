package lambda;

/**
 * Created by libin on 2018/6/19.
 */
public class LambdaTest {
    public static void runable(int x) {

        new Thread(() -> System.out.println("It's a lambda function!")).start();
    }
    public static void main(String[] args) {

     lambdaI i=(()-> {
         System.out.println("lambda");
     });
   lambdaI a=  new lambdaI(){
         public void sout(){
             System.out.println("tes");
         }
     };
a.sout();
    }
}
