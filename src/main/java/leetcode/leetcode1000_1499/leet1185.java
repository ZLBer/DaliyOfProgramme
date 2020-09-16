package leetcode.leetcode1000_1499;

import java.time.Month;
import java.time.Year;

public class leet1185 {
    String [] weeks=new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
 /*   public String dayOfTheWeek(int day, int month, int year)  {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date datet = null;
        try {
            datet = (Date) f.parse(year+"-"+month+"-"+day);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.setTime(datet);
        int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
        return weeks[week_index];
    }*/

    public String dayOfTheWeek(int day, int month, int year) {
        String[] weeks = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int weekOfDay = Year.of(year).atMonth(Month.of(month)).atDay(day).getDayOfWeek().getValue() - 1;
        return weeks[weekOfDay];
    }


}
