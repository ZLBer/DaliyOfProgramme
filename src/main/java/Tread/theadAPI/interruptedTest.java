package Tread.theadAPI;

/**
 * Created by libin on 2018/6/26.
 */
public class interruptedTest extends Thread{

}

class runin {
    public static void main(String[] args) {
        interruptedTest in=new interruptedTest();
        in.interrupt();
    }
}