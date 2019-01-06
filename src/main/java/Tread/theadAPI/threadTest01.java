package Tread.theadAPI;

/**
 * Created by libin on 2018/6/26.
 */
public  class threadTest01 extends Thread{
    private int count=5;
    threadTest01(){}

    threadTest01(String name){
        super();
        this.setName(name);
    }
    @Override
    public void run(){
      super.run();
//      count--;
//        System.out.println(this.currentThread().getName()+"   "+count);
        while(count>0){
            count--;
        System.out.println(this.currentThread().getName()+"   "+count);
        }

    }

}

class run{
    public static void main(String[] args) {
        threadTest01 my=new threadTest01();
        Thread a=new Thread(my,"A");
        Thread b=new Thread(my,"B");
        Thread c=new Thread(my,"C");
        Thread d=new Thread(my,"D");
        Thread e=new Thread(my,"E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
//        threadTest01 t1=new threadTest01("A");
//        threadTest01 t2=new threadTest01("B");
//        threadTest01 t3=new threadTest01("C");
//        t1.start();
//        t2.start();
//        t3.start();
    }
}
