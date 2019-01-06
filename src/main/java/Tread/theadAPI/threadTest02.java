package Tread.theadAPI;

/**
 * Created by libin on 2018/6/26.
 */
public class threadTest02 {
    private static String username;
    private static String password;
     public synchronized   static void  login(String u,String p) {

        username =u;
        if(username.equals("aa")){
            ;
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        password=p;
        System.out.println(username+"   "+password);
    }
}

class a extends  Thread{
    @Override
    public  void run() {
        super.run();
        threadTest02.login("aa","aa");

    }
}

class b extends  Thread {
    @Override
    public void run() {
        super.run();
        threadTest02.login("bb", "bb");

    }
}

class run02{
    public static void main(String[] args) {
        a a1=new a();
        a1.start();
        b b1=new b();
        b1.start();
    }
   ;

        }

