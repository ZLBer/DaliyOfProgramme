package zookeeper;

import org.apache.zookeeper.KeeperException;

import java.io.IOException;

public class TicketSeller {
    static int count=0;
    private void sell(){
        System.out.println("售票开始");
        // 线程随机休眠数毫秒，模拟现实中的费时操作
        int sleepMillis = (int) (Math.random() * 2000);
        try {
            //代表复杂逻辑执行了一段时间
            Thread.sleep(sleepMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("售票结束");
    }

    public void sellTicketWithLock() throws KeeperException, InterruptedException, IOException {
        LockSample lock = new LockSample();
        lock.acquireLock();
        sell();
        System.out.println(count+++"++++++++++++++++++++++++++++++++++++++++++++++++");
        lock.releaseLock();
    }

    public static void main(String[] args) throws KeeperException, InterruptedException, IOException {
        TicketSeller ticketSeller = new TicketSeller();
        for(int i=0;i<10;i++){

            Thread thread=new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        ticketSeller.sellTicketWithLock();
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            });
            thread.start();

        }
    }
}
