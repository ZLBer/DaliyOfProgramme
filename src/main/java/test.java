import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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


//        int []a={1,2};
//        int []b= Arrays.copyOf(a,5);
//      for(int c:b){
//          System.out.println(c);
//      }



            int num = 1;
            String userName = "";
            String password = "";
            Scanner in = new Scanner(System.in);
            while (true) {
                if (num > 1) System.out.println("用户名或密码不正确");
                System.out.println("请输入用户名");
                userName = in.nextLine();
                System.out.println(userName);
                System.out.println("请输入密码");
                password = in.next();

                System.out.println(userName.equals("admin"));
                System.out.println(password);
                num++;
                if(userName == "admin" && password == "111") break;
            }
            System.out.println("登陆成功");

    }
}
