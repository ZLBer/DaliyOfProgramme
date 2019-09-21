package leetcode.leetcode500_999;

import java源码学习.util.LinkedList;
import java源码学习.util.Map;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by libin on 2019/2/27.
 */
public class leet599 {
    //mine   2* n2遍历
  /*  public String[] findRestaurant(String[] list1, String[] list2) {
       int min=Integer.MAX_VALUE;
       LinkedList<String> result=new LinkedList<>();
       for(int i=0;i<list1.length;i++){
           for(int j=0;i+j<min&&j<list2.length;j++){
               if(list1[i].equals(list2[j])&&i+j<min) min=i+j;
           }
       }

        for(int i=0;i<list1.length;i++){
            for(int j=0;j<list2.length;j++){
                if(list1[i].equals(list2[j])&&i+j==min) result.add(list1[i]);           }
        }

return  result.toArray(new String[result.size()]);
    }*/

    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String ,Integer> map=new HashMap<>();
        LinkedList<String> result=new LinkedList<>();
        int min=Integer.MAX_VALUE;
for(int i=0;i<list1.length;i++) map.put(list1[i],i);
for(int i=0;i<list2.length;i++){
    Integer  s=map.get(list2[i]);
    if(s!=null&&s+i<=min){
        if(s+i<min){result.clear(); min=s+i;}
        result.add(list2[i]);
    }
}

return result.toArray(new String[result.size()]);
    }
}
