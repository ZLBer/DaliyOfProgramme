package Tread.Concurrency;

/**
 * Created by libin on 2018/6/27.
 */
public class Main {
    public int i=10;
    synchronized  public  void operateIMainMethod(){
        try {
            System.out.println("begin Main method"+i);
            i--;
            Thread.sleep(5000);
            System.out.println("ends Main method"+i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Sub extends Main {
    synchronized  public void operateISunMethod(){
        try {
            System.out.println("begin sub method"+i);
            i--;
            Thread.sleep(3000);
            System.out.println("end sub method"+i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}

class run934 {
    public static void main(String[] args) {
        Sub m=new Sub();
   new Thread(new Runnable() {
       @Override
       public void run() {
           m.operateIMainMethod();

       }
   }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

              m.operateISunMethod();
            }
        }).start();

    }

}
