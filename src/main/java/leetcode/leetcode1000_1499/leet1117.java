package leetcode.leetcode1000_1499;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class leet1117 {
  static   class H2O {
       Lock lock=new ReentrantLock();
      Condition condition=lock.newCondition();
        int two=2;
        public H2O() {

        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
          try {
              lock.lock();
              while (true){
                  if (two > 0) {
                      releaseHydrogen.run();
                      two--;
                      if(two==0){
                          condition.signalAll();
                      }
                      return;
                  }else {
                      condition.await();
                  }
              }

          }finally {
              lock.unlock();
          }





        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {

            // releaseOxygen.run() outputs "O". Do not change or remove this line.
    try {
        lock.lock();
        while (true) {
            if (two == 0) {
                releaseOxygen.run();
                two = 2;
                condition.signalAll();
                return;
            } else {
                condition.await();
            }
        }

    }finally {
        lock.unlock();
    }



        }
    }

    public static void main(String[] args) {
        H2O h2O = new leet1117.H2O();
    }

}
