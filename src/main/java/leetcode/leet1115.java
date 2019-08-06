package leetcode;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class leet1115 {
    //CyclicBarrier
   /* class FooBar {
        private int n;
        CyclicBarrier foo=new CyclicBarrier (2);
        CyclicBarrier bar =new CyclicBarrier(2);
        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {

                // printFoo.run() outputs "foo". Do not change or remove this line.
                try {
                    foo.await();
                    printFoo.run();
                    foo.reset();
                    bar.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                try {
                   foo.await();
                    bar.await();
                    printBar.run();
                    bar.reset();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.

            }
        }
    }*/
   //mine Semaphore
 /*   class FooBar {
        private int n;

        Semaphore semaphore=new Semaphore(0);
        Semaphore semaphore1=new Semaphore(1);
        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                semaphore1.acquire();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                semaphore.release();

            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

             for (int i = 0; i < n; i++) {
                 semaphore.acquire();
                    printBar.run();
                    semaphore1.release();
                // printBar.run() outputs "bar". Do not change or remove this line.

            }
        }
    }*/


  /*  class FooBar {
        private int n;

         boolean foo=true;
       boolean bar=false;
        public FooBar(int n) {
            this.n = n;
        }

        public synchronized void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
               while (bar){
                  wait();
               }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
               bar=true;
               foo=false;
               notifyAll();


            }
        }

        public synchronized void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                while (foo){
                   wait();
                }
                printBar.run();
                foo=true;
                bar=false;
                 notifyAll();
                // printBar.run() outputs "bar". Do not change or remove this line.

            }
        }
    }*/
//synchronized
/*    class FooBar {
        private int n;
        private  int count=0;
        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
             synchronized (this){
                while (count==1)
                    wait();

                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
             count=1;
             notifyAll();
            }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
synchronized (this){
    while (count==0){
          wait();
    }


                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                  count=0;
                  notifyAll();
            }}
        }
    }*/

  //ReentrantLock
   /* class FooBar {

        private int n;
        //flag 0->foo to be print  1->foo has been printed
        private int flag=0;
        ReentrantLock reentrantLock= new ReentrantLock();
        Condition fooPrintedCondition=reentrantLock.newCondition();
        Condition barPrintedCondition=reentrantLock.newCondition();

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                reentrantLock.lock();
                while (flag ==1){
                    barPrintedCondition.await();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                flag=1;
                fooPrintedCondition.signalAll();
                reentrantLock.unlock();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                reentrantLock.lock();
                while (flag==0){
                    fooPrintedCondition.await();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag=0;
                barPrintedCondition.signalAll();
                reentrantLock.unlock();
            }
        }
    }*/

    class FooBar {
        private int n;
        //flag 0->foo to be print  1->foo has been printed  using volatile
        private volatile int flag = 0;


        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                while (true) {
                    if (flag == 0) {
                        printFoo.run();
                        flag = 1;
                        break;
                    }
                    Thread.sleep(1);
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                while (true) {
                    if (flag == 1) {
                        printBar.run();
                        flag = 0;
                        break;
                    }
                    Thread.sleep(1);
                }
            }
        }
    }
}
