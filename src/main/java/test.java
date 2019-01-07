import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by libin on 2019/1/7.
 */
public class test {
    public static void main(String[] args) {
//        for(int i=1;i<10;i++){
//            for (int j=1;j<=i;j++){
//                System.out.print(i+"*"+j+"="+i*j+"    ");
//            }
//            System.out.println();
//        }


        int []a={1,2};
        int []b= Arrays.copyOf(a,5);
      for(int c:b){
          System.out.println(c);
      }
    }
}
