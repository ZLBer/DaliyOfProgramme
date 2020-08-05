package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class byteCamp01 {
    public static void main(String[] args) {
        Set<Integer> m31=new HashSet<>(Arrays.asList(1,3,5,7,8,10,12));
        Set<Integer> m30=new HashSet<>(Arrays.asList());

        Scanner in = new Scanner(System.in);
         String s=in.nextLine();
         Map<String,Integer> map=new HashMap<>();
        String[] split = s.split("-");

        for (int i = 0; i+2 < split.length; i++) {
           String d=split[i];
          if(d.length()>2){
             d=d.substring(d.length()-2);
          }
          String m=split[i+1];
          String y=split[i+2];
          if(m.length()>2) continue;
          if(y.length()!=4) continue;
          int iy=Integer.parseInt(y);
          if(iy<2001||iy>2021) continue;//判断年份
          int im=Integer.parseInt(m);
          int id=Integer.parseInt(d);
          if(im<1||im>12) continue; //判断月份

          if(id==31){
              if(!m31.contains(im)) continue;
          }
           if(im==2){ //二月
             if(isY(im)){ ////闰年
               if(id>29) continue;
             }else {
                if(id>28) continue;
             }
            }
   map.put(d+"-"+m+"-"+y,map.getOrDefault(d+"-"+m+"-"+y,0)+1);

        }
       int count=0;
       String res="";
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            if(stringIntegerEntry.getValue()>count){
                count=stringIntegerEntry.getValue();
                res=stringIntegerEntry.getKey();
            }
        }
        System.out.println(res);
 
    }

  static boolean isY(int y){
      return (y%400==0||(y%4==0&&y%100!=0));
   }
}
