package Tread;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by libin on 2018/6/25.
 */
public class lock {
    private static Lock lock = new ReentrantLock();
  static  int i=0;
  static  synchronized    void  l(){
      //lock.lock();
   i++;
   //lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {

        long begin = System.nanoTime();
Thread [] ts=new Thread[20];
        for (int m = 0; m <20 ; m++) {


            int finalM = m;
           ts[m]=  new Thread(new Thread() {
            @Override
            public void run() {
                for (int j = 0; j <50000 ; j++) {
                l();
          //     System.out.println(Thread.currentThread().getName());
                    System.out.println( getName()+"线程"+ finalM +"   "+i);
                }

            }
        });
        }
                    for(Thread t:ts) {
                t.start();
            }
        for(Thread t:ts) {
            t.join(); System.out.println("==============================================");

        }

        long end = System.nanoTime();
        System.out.println("花费时间："+(end-begin));
    }
//    public static void main(String[] args) throws Exception{
//        final int max = 10;
//        final int loopCount = 100000;
//        long costTime = 0;
//        for (int m = 0; m < max; m++) {
//            long start1 = System.nanoTime();
//            final AtomicIntegerWithLock value1 = new AtomicIntegerWithLock(0);
//            Thread[] ts = new Thread[max];
//            for(int i=0;i<max;i++) {
//                ts[i] = new Thread() {
//                    public void run() {
//                        for (int i = 0; i < loopCount; i++) {
//                            value1.incrementAndGet();
//                        }
//                    }
//                };
//            }
//            for(Thread t:ts) {
//                t.start();
//            }
//            for(Thread t:ts) {
//                t.join();
//            }
//            long end1 = System.nanoTime();
//            costTime += (end1-start1);
//        }
//        System.out.println("cost1: " + (costTime));
//        //
//        System.out.println();
//        costTime = 0;
//        //
//        final Object lock = new Object();
//        for (int m = 0; m < max; m++) {
//            staticValue=0;
//            long start1 = System.nanoTime();
//            Thread[] ts = new Thread[max];
//            for(int i=0;i<max;i++) {
//                ts[i] = new Thread() {
//                    public void run() {
//                        for (int i = 0; i < loopCount; i++) {
//                            synchronized(lock) {
//                                ++staticValue;
//                            }
//                        }
//                    }
//                };
//            }
//            for(Thread t:ts) {
//                t.start();
//            }
//            for(Thread t:ts) {
//                t.join();
//            }
//            long end1 = System.nanoTime();
//            costTime += (end1-start1);
//        }
//        //
//        System.out.println("cost2: " + (costTime));
//    }
//
//
//    static int staticValue = 0;
}


// class AtomicIntegerWithLock {
//
//    private int value;
//
//    private Lock lock = new ReentrantLock();
//
//    public AtomicIntegerWithLock() {
//        super();
//    }
//
//    public AtomicIntegerWithLock(int value) {
//        this.value = value;
//    }
//
//    public final int get() {
//        lock.lock();
//        try {
//            return value;
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public final void set(int newValue) {
//        lock.lock();
//        try {
//            value = newValue;
//        } finally {
//            lock.unlock();
//        }
//
//    }
//
//    public final int getAndSet(int newValue) {
//        lock.lock();
//        try {
//            int ret = value;
//            value = newValue;
//            return ret;
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public final boolean compareAndSet(int expect, int update) {
//        lock.lock();
//        try {
//            if (value == expect) {
//                value = update;
//                return true;
//            }
//            return false;
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public final int getAndIncrement() {
//        lock.lock();
//        try {
//            return value++;
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public final int getAndDecrement() {
//        lock.lock();
//        try {
//            return value--;
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public final int incrementAndGet() {
//        lock.lock();
//        try {
//            return ++value;
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public final int decrementAndGet() {
//        lock.lock();
//        try {
//            return --value;
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public String toString() {
//        return Integer.toString(get());
//    }
//}