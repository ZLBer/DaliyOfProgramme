package Tread.Communication;

/**
 * Created by libin on 2018/6/28.
 */
public class cpuTest extends Thread {
    public static final int BUSYTIME = 10;
    public static final int IDLETIME = BUSYTIME;

    public void run() {
        while (true) {
            long startTime = System.currentTimeMillis();//获取开始时间
            while (System.currentTimeMillis() - startTime <= BUSYTIME) {
            }
            ;
            try {
                Thread.sleep(IDLETIME);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {
        final int SAMPLING_COUNT = 200;
        final double PI = 3.1415926535;
        final int TOTAL_AMPLITUDE = 300;

        int[] busySpan = new int[SAMPLING_COUNT];
        int amplitude = TOTAL_AMPLITUDE / 2;
        double radian = 0.0;
        double radianIncrement = 2.0 / (double) SAMPLING_COUNT;
        for (int i = 0; i < SAMPLING_COUNT; i++) {
            busySpan[i] = (int) (amplitude + Math.sin(PI * radian) * amplitude);
            radian += radianIncrement;
        }

        long startTime = 0;
        for (int j = 0; ; j = (j + 1) % SAMPLING_COUNT) {
            startTime = System.currentTimeMillis();
            while ((System.currentTimeMillis() - startTime) <= busySpan[j])
                ;
            Thread.sleep(TOTAL_AMPLITUDE - busySpan[j]);
        }

    }
}
