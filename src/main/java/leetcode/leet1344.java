package leetcode;

public class leet1344 {
    //mine 给时针和分针分别定位
    //一个小格子是6度
    public double angleClock(int hour, int minutes) {
        //时针所在的位置
        double hourLocal= (hour%12)*5+minutes/60.0*5;
        System.out.println(hourLocal);
       //分针所在的位置
        double minutesLocal=minutes;
        System.out.println(minutesLocal);

        double angle=Math.abs(hourLocal-minutesLocal)*6;
        return angle<=180?angle:360-angle;
    }
}
