package leetcode.tianchi;

public class tianchi0906 {
  static   public String guessYear(int[][] inputQueries) {
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < inputQueries.length; i++) {
            String res=check(inputQueries[i]);
            sb.append(res);
        }
        return sb.toString();
    }
static  int[] days=new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
   static String check(int[] arr) {

        //假设是平年


       if(arr[0]==arr[2]) {//同一个月

        if(arr[1]<arr[3]) { //同一年
            if (arr[0] != 2) return "?"; //不在2月
            else {  //在2月
                if (arr[3] == 29 || arr[1] == 29) return "R";
                else return "?";
            }
        }else { //跨年
            if(arr[0]>=3) return "?";
            int day = days[arr[0] - 1] - arr[1];//第一个月剩余
            day += arr[3];//最后一个月多出
            for (int i = arr[0] + 1; i <= 12; i++) {
                day += days[i - 1];
            }
            for (int i =1; i < arr[2]; i++) {
                day += days[i - 1];
            }

            if (day == arr[4]) return "P";
            else return "R";
        }
       }
      else if(arr[2]>arr[0]) { //没有跨年
           if(arr[0]>=3) return "?";

           if(arr[2]==2){
              if(arr[3]==29) return "R";
              if(arr[3]<29) return "?";
           }


          int day = days[arr[0] - 1] - arr[1];//第一个月剩余
           day += arr[3];//最后一个月多出
           for (int i = arr[0] + 1; i < arr[2]; i++) {
               day += days[i - 1];
           }

           if (day == arr[4]) return "P";
           else return "R";

       }
       else {//跨过一年


           if(arr[0]>=3) return "?";
           int day = days[arr[0] - 1] - arr[1];//第一个月剩余
           day += arr[3];//最后一个月多出
           for (int i = arr[0] + 1; i <= 12; i++) {
               day += days[i - 1];
           }
           for (int i =1; i < arr[2]; i++) {
               day += days[i - 1];
           }

           if (day == arr[4]) return "P";
           else return "R";
       }
    }

    public static void main(String[] args) {
        guessYear(new int[][]{
                {2,28,1,1,307}
        });
    }



    public boolean judge(String s1, String s2) {
      if(s1.length()!=s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
          String temp=s1.substring(i)+s1.substring(0,i);
          if(temp.equals(s2)) return true;
        }
        return false;
    }
}
