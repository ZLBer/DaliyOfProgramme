package zookeeper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ZkLockTest {

    // zk地址
    private String CONNECT_STRING = "47.94.134.137:2181";

    // 公平
    public void testFair() throws Throwable {
        test(true);
    }

    // 非公平
    public void testUnFair() throws Throwable {
        test(false);
    }

    public void test(boolean isFair) throws Exception {
        List<Thread> threads = new ArrayList<>();
        // 线程数
        int threadCount = 10;
        // 等待所有线程执行完毕
        CountDownLatch latch = new CountDownLatch(threadCount);
        // 准备线程及执行任务
        for (int i = 0; i < threadCount; i++) {
            threads.add(new Thread(() -> {
                ZookeeperDistributedLock zkLock = ZookeeperDistributedLock.create(CONNECT_STRING, "zhh_lock", isFair);
                try {
                    // 抢锁
                    zkLock.lock();
                    // 模拟做事
                    doSomething(1);
                    // 解锁
                    zkLock.unlock();
                    latch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "thread-" + i));
        }
        // 并行
        threads.parallelStream()
                .forEach(Thread::start);
        // 等待所有线程执行完毕
        latch.await();
    }

    // 模拟做一些事情
    private void doSomething(int second) {
        try {
            System.out.println(Thread.currentThread().getName() + "获得了锁，开始执行任务！");
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        new ZkLockTest().test(true);
    }
}
