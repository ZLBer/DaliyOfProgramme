package leetcode.leetcode1000_1499;

public class leet1360 {
    //api
 /*   public int daysBetweenDates(String date1, String date2) {
        return Math.abs((int) ChronoUnit.DAYS.between(LocalDate.parse(date1), LocalDate.parse(date2)));
    }*/

    //mine
    public int daysBetweenDates(String date1, String date2) {
return  Math.abs(countDayFrom1971(date1)-countDayFrom1971(date2));
    }

    int countDayFrom1971(String date){
        int[] monthDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
     String[]data=date.split("-");
     int year=Integer.parseInt(data[0]);
     int month=Integer.parseInt(data[1]);
     int day=Integer.parseInt(data[2]);
     int days=day;
     for(int i=1971;i<year;i++){
         days+=(isLeapYear(i)?366:365);
     }
     for(int i=1;i<month;i++){
         if(i==2&&isLeapYear(year)){
             days++;
         }
         days+=monthDays[i];
     }
     return days;
    }

    boolean isLeapYear(int year){
        return (year%4==0&&year%100!=0)||year%400==0;
    }


    //直接从1年开始
/*    static int monthDays[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int daysBetweenDates(String date1, String date2) {
        int[] d1 = stringDateConvertor(date1);
        int[] d2 = stringDateConvertor(date2);

        int date1Days = d1[0] * 365 + d1[2];

        // Add number of days for the given month
        for (int i = 0; i < d1[1] - 1; i++)
        {
            date1Days += monthDays[i];
        }

        // Since each leap year has 366 days,
        // Add an extra day for every leap year we meet.
        date1Days += countLeapYear(d1[0], d1[1]);

        int date2Days = d2[0] * 365 + d2[2];
        for (int i = 0; i < d2[1] - 1; i++)
        {
            date2Days += monthDays[i];
        }
        date2Days += countLeapYear(d2[0], d2[1]);

        // Return number of days between Two dates.
        return Math.abs(date1Days - date2Days);
    }

    public int[] stringDateConvertor(String date) {
        int[] dateTrans = new int[3];

        String[] d = date.split("-");
        dateTrans[0] = Integer.valueOf(d[0]);
        dateTrans[1] = Integer.valueOf(d[1]);
        dateTrans[2] = Integer.valueOf(d[2]);

        return dateTrans;
    }

    public int countLeapYear(int year, int month) {
        // If the current year not reach to Feb., then we do not need to consider it
        // for the count of leap years.
        if (month <= 2)
        {
            year--;
        }

        // A leap year is a multiple of 4, multiple of 400 BUT not a multiple of 100.
        return year / 4 - year / 100 + year / 400;
    }*/
}
