package Tread.Timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by libin on 2018/6/29.
 */
public class Run {
    static  int i =0;
    static public  class MyTask extends TimerTask{

        @Override
        public void run() {
            System.out.println("执行了"+i);

        }

        public static void main(String[] args) throws InterruptedException {
            while (true){
                i++;
                Timer timer =new Timer();
                MyTask task=new MyTask();
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dataString ="2018-6-29 10:11:00";
                Date date= null;
                try {
                    date = simpleDateFormat.parse(dataString);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                timer.schedule(task,date);
                //Thread.sleep(1000);
                timer.cancel();

          }
        }
    }
}
