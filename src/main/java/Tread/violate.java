package Tread;

/**
 * Created by libin on 2018/6/25.
 */
public class violate {
     boolean done = false;
    void test(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while( ! done ){
                    System.out.println("dosomting");

                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                done=true;
                for (int i = 0; i <999 ; i++) {
                    System.out.println("-----------------------------------------------"+done);
                }

            }
        }).start();
       }
    public static void main(String[] args) {
      violate v=  new violate();
    v.test();
    }
}
