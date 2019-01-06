package Tread.theadAPI;

/**
 * Created by libin on 2018/6/25.
 */
public class Tread01 {
    public static void main(String[] args) throws InterruptedException {
              Thread t=   new MyThread();
             // t.setDaemon(true);
              t.start();
              t.join();
      Thread t1=  new MyThread1();
      t1.start();

     //   new m().run();

    }

    static class MyThread extends Thread {
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("A"+i);
            }
        }

    }

   static class MyThread1 extends Thread {

        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("B"+i);
            }
        }

    }
    class Mythread3 implements Runnable{

        @Override
        public void run() {
            ;
        }
    }
    interface c {
        void  run();
    }
    class v implements c{

        @Override
        public void run() {

        }
    }
    abstract  static class  a{
        void run (){
            System.out.println("非抽象");
        }
        abstract  void t();
    }
   static class m extends a{


        @Override
        void t() {

        }
    }
}

class Mythread2 {
    public static void main(String[] args) {
        
    }
}
