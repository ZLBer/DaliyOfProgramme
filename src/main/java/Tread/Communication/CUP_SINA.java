package Tread.Communication;

/**
 * Created by libin on 2018/6/28.
 */

public class CUP_SINA
{
//    static int num =Runtime.getRuntime().availableProcessors();
//    static CyclicBarrier k = new CyclicBarrier(num);
//    public static void main(String[] args) throws InterruptedException
//    {
//        for(int i=0;i<num;i++)
//        {
//            new Thread(new Run()).start();
//        }
//    }
//    static class Run implements Runnable
//    {
//
//        public void run()
//        {
//
//            final int SAMPLING_COUNT = 200;
//            final double PI = 3.1415926535;
//            final int TOTAL_AMPLITUDE = 300;
//            long startTime = 0;
//            int[] busySpan = new int[SAMPLING_COUNT];
//            int amplitude = TOTAL_AMPLITUDE/2;
//            double radian = 0.0;
//            double radianIncrement = 2.0/(double)SAMPLING_COUNT;
//            for(int i=0;i<SAMPLING_COUNT;i++)
//            {
//                busySpan[i] = (int)(amplitude+Math.sin(PI*radian)*amplitude);
//                radian += radianIncrement;
//            }
//            for(int j=0;;j=(j+1) % SAMPLING_COUNT)
//            {
//                try
//                {
//                    k.await();
//                }
//                catch (InterruptedException e1)
//                {
//                    e1.printStackTrace();
//                }
//                catch (BrokenBarrierException e1)
//                {
//                    e1.printStackTrace();
//                }
//                startTime = System.currentTimeMillis();
//                while((System.currentTimeMillis()-startTime)<=busySpan[j]);
//                try
//                {
//                    Thread.sleep(TOTAL_AMPLITUDE-busySpan[j]);
//                }
//                catch (InterruptedException e)
//                {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
public static final int BUSYTIME=10;
    public static final int IDLETIME=BUSYTIME;
    public static void main(String[] args) throws InterruptedException {
        while(true){
            long startTime=System.currentTimeMillis();//获取开始时间
            while(System.currentTimeMillis()-startTime<=BUSYTIME){
            };
            Thread.sleep(IDLETIME);
        }
    }

}

