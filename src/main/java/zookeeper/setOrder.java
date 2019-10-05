package zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public  class  setOrder implements  Runnable{
    int orderId=0;
    ZooKeeper zk = null;
    String lockPath = "/lock/orderLock";
    CountDownLatch countDownLatch=new CountDownLatch(1);
    setOrder() throws IOException {
        zk=new ZooKeeper("47.94.134.137:2181", 5000, //
                new ZooKeeperProSync());
    }
    @Override
    public void run() {
        zookeeperUnfairLock watcher=  new zookeeperUnfairLock(countDownLatch);
        boolean flag=false;
        while (!flag) {
            try {
                zk.create(lockPath, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
                orderId++;
                System.out.println(orderId+"++++++++++++++++++++++++++++++++++++++++++++"+Thread.currentThread().getName());
                Thread.sleep(1000);
               zk.close();
               // zk=null;
                flag=true;
                //System.gc();
            } catch (KeeperException e) {
                try {
                    Stat stat= zk.exists(lockPath,watcher);
                    countDownLatch.await();
//                       synchronized (setOrder.class) {
//                           setOrder.class.wait(100);
//                       }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                } catch (KeeperException ex) {
                    ex.printStackTrace();
                }
            } catch (InterruptedException e) {

            }


//                   synchronized (setOrder.class) {
//                       setOrder.class.notifyAll();
//                   }
        }
        System.out.println("任务结束");

    }
}
