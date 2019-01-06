package Tread.Communication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by libin on 2018/6/28.
 */
public class Mystack {
    private List list=new ArrayList();
    synchronized   public void push(){

            try {
                if(list.size()==1) {
                    this.wait();
                }
                list.add("anything"+Math.random());
                this.notify();
                System.out.println("push="+list.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }
    synchronized  public  String pop(){
        String returnValue="";
        try {    if(list.size()==0) {
            System.out.println("pop操作中的：" + Thread.currentThread().getName() + "线城是wait状态");

            this.wait();
        }
        returnValue=""+list.get(0);
            list.remove(0);
            this.notify();
            System.out.println("pop="+list.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
     return returnValue;
            }
}

class P{
    private Mystack mystack;
    public  P(Mystack mystack){
        this.mystack=mystack;
    }
    public  void pushService(){
        mystack.push();
    }
}

class  C{
    private Mystack mystack;
    public  C(Mystack mystack){
        this.mystack=mystack;
    }
    public  void popService(){
        System.out.println("pop="+mystack.pop());
    }
}

class P_Thread extends Thread{
    private P p;
    public P_Thread(P p){
        this.p=p;
    }
    public void run(){
        while(true){
   p.pushService();
        }
    }
}

class C_Thread extends Thread{
    private C c;
    public C_Thread(C c){
        this.c=c;
    }
    public void run(){
        while(true){
            c.popService();
        }
    }
}

class run{
    public static void main(String[] args) {
        Mystack mystack=new Mystack();
        P p1=new P(mystack);
        P p2=new P(mystack);
        P p3=new P(mystack);
        P p4=new P(mystack);
        P p5=new P(mystack);
        C c1=new C(mystack);
//        C c2=new C(mystack);
//        C c3=new C(mystack);
//        C c4=new C(mystack);
//        C c5=new C(mystack);


        P_Thread p_thread1=new P_Thread(p1);
        P_Thread p_thread2=new P_Thread(p2);
        P_Thread p_thread4=new P_Thread(p4);
        P_Thread p_thread3=new P_Thread(p3);
        P_Thread p_thread5=new P_Thread(p5);
        C_Thread c_thread1=new C_Thread(c1);
//        C_Thread c_thread2=new C_Thread(c2);
//        C_Thread c_thread3=new C_Thread(c3);
//        C_Thread c_thread4=new C_Thread(c4);
//        C_Thread c_thread5=new C_Thread(c5);



        p_thread1.start();
        p_thread2.start();
        p_thread3.start();
        p_thread4.start();
        p_thread5.start();

        c_thread1.start();
//        c_thread2.start();
//        c_thread3.start();
//        c_thread4.start();
//        c_thread5.start();

    }
}
