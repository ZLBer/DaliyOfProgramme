package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LCP23 {
  static public boolean isMagic(int[] target) {
       int k=0;
       if(target[0]%2==0) k=1;
       else return false;
        for (int i = 1; i < target.length; i++) {
          if(target[i]%2==0&&target[i]-2==target[i-1]) {
           k++;
          }else break;
        }
        //求的k
       System.out.println(k);
        //检查
       List<Integer> list=new ArrayList<>();
      for(int i=1;i<=target.length;i++){
          list.add(i);
      }

if(k>=target.length/2) {
    int pre = 1;
    for (int i = k; i < target.length; i++) {
        if (target[i] == pre) {
            pre += 2;
            k++;
        } else {
            break;
        }
    }
}
 int cout=0;
     while (true){
       //取偶数位放在前面
         List<Integer> temp=help(list);
         if(!check(target,k,temp,cout)) return false;
         list=built(temp,k);
       if(list.size()==0) return true;
       cout++;
     }
    }
  static List<Integer> built(List<Integer> list,int k){
      List<Integer> res=new ArrayList<>();
     for(int i=k;i<list.size();i++){
         res.add(list.get(i));
     }
     return res;
   }
 static   List<Integer> help(List<Integer> list){
    List<Integer> ji=new ArrayList<>();
    List<Integer> ou=new ArrayList<>();
       for (int i = 0; i < list.size(); i++) {
         if(i%2==0) ou.add(list.get(i));
         else {
            ji.add(list.get(i));
         }
       }
     List<Integer> res=new ArrayList<>();
     res.addAll(ji);  res.addAll(ou);

       return res;
   }
 static   boolean check(int []taget,int k,List<Integer> list,int count){
       for (int i = 0; i < k&&i<list.size(); i++) {
          if(list.get(i)!=taget[k*count+i]) return false;
       }
      return true;
   }

    public static void main(String[] args) {
isMagic(new int[]{2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,46,48,50,52,54,56,58,1,5,9,13,17,21,25,29,33,37,41,45,49,53,57,61,60,3,7,11,15,19,23,27,31,35,39,43,47,55,51,59});
    }
}
