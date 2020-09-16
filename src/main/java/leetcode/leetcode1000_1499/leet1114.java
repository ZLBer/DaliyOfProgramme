package leetcode.leetcode1000_1499;

public class leet1114 {

    //用Semaphore实现
  /*  class Foo {
        Semaphore run1,run2;
        public Foo() {
          run1=new Semaphore(0);
          run2=new Semaphore(0);
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            run1.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
           run1.acquire();

            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            run2.release();

        }

        public void third(Runnable printThird) throws InterruptedException {
           run2.acquire();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }*/



  //用notifyAll实现
   /* class Foo {

        private  boolean onePrinted;
        private  boolean twoPrinted;

        public Foo() {
            onePrinted = false;
            twoPrinted = false;
        }

        public synchronized void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            onePrinted = true;
            notifyAll();
        }

        public synchronized void second(Runnable printSecond) throws InterruptedException {
            while(!onePrinted) {
                wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            twoPrinted = true;
            notifyAll();
        }

        public synchronized void third(Runnable printThird) throws InterruptedException {
            while(!twoPrinted) {
                wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }

    }*/



   //用CountDownLatch实现
  /*  class Foo {

        private final CountDownLatch l2;
        private final CountDownLatch l3;

        public Foo() {
            l2 = new CountDownLatch(1);
            l3 = new CountDownLatch(1);
        }

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            l2.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            l2.await();
            printSecond.run();
            l3.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            l3.await();
            printThird.run();
        }
    }*/


  //用AtomicInteger实现
 /*   class Foo {

        AtomicInteger count = new AtomicInteger();

        public Foo() {
            count.set(0);
        }

        public void first(Runnable printFirst) throws InterruptedException {

            while(!count.compareAndSet(0, 1)){
                // printFirst.run() outputs "first". Do not change or remove this line.
            }
            printFirst.run();

        }

        public void second(Runnable printSecond) throws InterruptedException {
            while(!count.compareAndSet(1, 2)){
                // printSecond.run() outputs "second". Do not change or remove this line.
            }
            printSecond.run();

        }

        public void third(Runnable printThird) throws InterruptedException {
            while(!count.compareAndSet(2, 3)){
                // printThird.run() outputs "third". Do not change or remove this line.
            }
            printThird.run();

        }
    }*/


// 用synchronized和notifyAll实现
    class Foo {

        int count = 0;

        public Foo() {
        }

        public synchronized void first(Runnable printFirst) throws InterruptedException {


            printFirst.run();
            count++;
            this.notifyAll();

        }

        public synchronized void second(Runnable printSecond) throws InterruptedException {

            while(count != 1){
                this.wait();
            }
            printSecond.run();
            count++;
            this.notifyAll();
        }

        public synchronized void third(Runnable printThird) throws InterruptedException {

            while(count != 2){
                this.wait();
            }
            printThird.run();
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable printFirst=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("first");
            }
        });
        Runnable printSecond=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("second");
            }
        });
        Runnable printThird=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("third");
            }
        });
        Runnable start=new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        Foo foo=new leet1114().new Foo();

      Thread s1=  new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.third(printThird);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
       new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.first(printFirst);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.second(printSecond);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

s1.start();


    }
}
