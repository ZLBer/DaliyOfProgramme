package leetcode;

public class leet492 {
    //mine
/*    public int[] constructRectangle(int area) {
      if(area==1) return new  int[]{1,1};
        int L=(int)Math.sqrt(area),W=area/L;
        //L需要向上取整
        if(L*L!=area){
            L++;
            W=area/L;
        }
      for( ;L<=area;){
        if(L*W==area) return new int[]{L,W};
        L++;W=area/L;
      }
      return null;
    }*/


    //简单的操作  从w的角度来看，并且改成求余操作
    public int[] constructRectangle(int area) {
        int w = (int)Math.sqrt(area);
        while (area%w!=0) w--;
        return new int[]{area/w, w};
    }
}
