package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class leet1610 {

    //contest的时候写的很乱
/*    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {

      int Ax=location.get(0),Ay=location.get(1);
      int Bx=location.get(0),By=-1;
      int all=0;
      List<Double> list =new ArrayList<>(points.size());
      for (int i = 0; i < points.size(); i++) {
           int Cx=points.get(i).get(0),Cy=points.get(i).get(1);
          if(Cx==Ax&&Cy==Ay) {
              all++;continue;
          }
            int []AB=new int[]{Bx-Ax,By-Ay};
            int []AC=new int[]{Cx-Ax,Cy-Ay};
            double cos = (AB[0] * AC[0] + AB[1] * AC[1]) / (Math.sqrt(AB[0] * AB[0] + AB[1] * AB[1]) * Math.sqrt(AC[0] * AC[0] + AC[1] * AC[1]));
         // System.out.println(cos);
            if(Cx>=Ax){ //右侧
                double acos = Math.acos(cos);
                list.add(acos);

            }else {
               // 取反-2

                double acos = Math.acos(-cos)+3.14/2;
                list.add(acos);

            }

        }

        Collections.sort(list);
//        for (int i = 0; i < list.size(); i++) {
//           // System.out.println(list.get(i));
//        }
         int res=0;
        for (int i = 0; i < list.size(); i++) {
             if(i>0&&list.get(i)==list.get(i-1)) continue;
             double from=list.get(i);

             int temp=0;
             double  end=from+Math.toRadians(angle);
            //System.out.println(end);
            for (int j = i; j < list.size(); j++) {
                //System.out.println("cc"+(end-list.get(j)));
                if(end-list.get(j).intValue()>=0) {
                  //  System.out.println("ccccccc");
                    temp++;}
                else break;;
            }
            res=Math.max(res,temp);
        } 
return res+all;
    }*/

    public static void main(String[] args) {
        System.out.println(Math.atan(1));
}



//看了提示自己写出来的
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        double Ax=location.get(0),Ay=location.get(1);

        List<Double> angles=new ArrayList<>(points.size());
        int inPlace=0;
        for (int i = 0; i < points.size(); i++) {
          int Bx=points.get(i).get(0),By=points.get(i).get(1);
          if(Bx==Ax&&By==Ay){
            inPlace++;
          }
          else if(Bx==Ax){
            if(By>Ay){
                angles.add(Math.PI/2);
            }else {
               angles.add(-Math.PI/2);
            }

          }else if(By==Ay){
              if(Bx>Ax){
                  angles.add(0.0);
              }else {
                 angles.add(Math.PI*3/2);
              }
          }else if(Bx>Ax){
              Double a=Math.atan((By-Ay)/(Bx-Ax));
             angles.add(a);
          }else {
              Double a=Math.atan((By-Ay)/(Bx-Ax));
             angles.add(a+Math.PI);
          }
        }

        Collections.sort(angles);


        int right=0;
        int res=0;
        int size=angles.size();
        for (int i = 0; i < size; i++) {
       double end = angles.get(i)+Math.toRadians(angle);
            while (right<angles.size()&&angles.get(right)<=end) {
             right++;
          }
       angles.add(angles.get(i)+Math.PI*2); //破除边界 ，很重要的一步
     res=Math.max(res,right-i+1);
        } 
       return res+inPlace;
    }
}
