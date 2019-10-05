package zookeeper;

import Tread.lock;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
  //自己实现的非公平锁
public class zookeeperUnfairLock implements Watcher {

 CountDownLatch countDownLatch;
    zookeeperUnfairLock(CountDownLatch countDownLatch){
    this.countDownLatch=countDownLatch;
    }
    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getType() == Event.EventType.NodeDeleted){
            System.out.println("唤醒");
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
      /*  String lockPath = "/lock/orderLock";
        ZooKeeper zk = new ZooKeeper("47.94.134.137:2181", 5000, //
                new ZooKeeperProSync());
        zk.create(lockPath, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);*/
        for(int i=0;i<10;i++){
            new Thread(new setOrder()).start();

        }
    }


}


