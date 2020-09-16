package leetcode.leetcode1000_1499;

public class leet1154 {
    int []monthDay={31,28,31,30,31,30,31,31,30,31,30,31};
    public int dayOfYear(String date) {
    String[]strings= date.split("-");

     return  checkMonth(Integer.parseInt(strings[0]),Integer.parseInt(strings[1]))+Integer.parseInt(strings[2]);


    }

   int checkMonth(int year,int month){
        //闰年标志，闰年二月有29天
        boolean flag=isLeapYear(year);
        int result=0;
        for(int i=0;i<month-1;i++){
            result+=monthDay[i];
        }

        if(month>2&&isLeapYear(year)) result++;
        return result;


   }

   boolean isLeapYear(int year){
      return (year%4==0&&year%100!=0)||year%400==0;
    }
}
